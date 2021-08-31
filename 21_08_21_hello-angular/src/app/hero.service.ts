import {Injectable} from '@angular/core';
import {Hero} from "./hero";
import {Observable, of, Subject} from "rxjs";
import {MessageService} from "./message.service";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {catchError, tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  private heroesUrl = 'http://localhost:8080/api/heroes';

  public searchTerms = new Subject<string>();


  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private messageService: MessageService,
              private http: HttpClient) {
  }

  getHeroes(): Observable<Hero[]> {
    return this.http.get<Hero[]>(this.heroesUrl)
      .pipe(
        tap(_ => this.log('fetched heroes')),
        catchError(this.handleError<Hero[]>('getHeroes', []))
      );
  }

  getHero(id: number): Observable<Hero> {
    // api/heroes/15
    return this.http.get<Hero>(`${this.heroesUrl}/${id}`)
      .pipe(
        tap(() => this.messageService.add(`fetched hero id=${id}`)),
        // catchError(this.handleError<Hero>(`getHero id=${id}`))
      );
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`HeroService: ${message}`);
  }

  updateHero(hero: Hero): Observable<void> {
    return this.http.put<void>(this.heroesUrl, hero, this.httpOptions)
      .pipe(
        tap(_ => this.log(`updated hero id=${hero.id}`)),
        catchError(this.handleError<any>('updateHero'))
      );
  }

  addHero(body: Hero): Observable<Hero> {
    return this.http.post<Hero>(this.heroesUrl, body, this.httpOptions)
      .pipe(
        // tap((newHero: Hero) => this.log(`added hero w/ id=${newHero.id}`)),
        tap((newHero: Hero) => this.log(`added hero`)),
        catchError(this.handleError<Hero>('addHero'))
      );
  }

  deleteHero(hero: Hero): Observable<void> {
    const url = `${this.heroesUrl}/${hero.id}`;

    return this.http.delete<void>(url, this.httpOptions)
      .pipe(
        tap(_ => this.log(`deleted hero id=${hero.id}`)),
        catchError(this.handleError<void>('deleteHero'))
      );
  }

  /* GET heroes whose name contains search term */
  searchHeroes(term: string): Observable<Hero[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }

    const param = new HttpParams().append('name', term)
    // const param = {'name': term};

    return this.http.get<Hero[]>(`${this.heroesUrl}/`, {params: param})
      .pipe(
        tap(x => x.length ?
          this.log(`found heroes matching "${term}"`) : this.log(`no heroes matching "${term}"`)),
        catchError(this.handleError<Hero[]>('searchHeroes', []))
      );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation: string = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
