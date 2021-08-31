import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Hero} from "../hero";
import {HeroService} from "../hero.service";
import {debounceTime, distinctUntilChanged, switchMap} from "rxjs/operators";

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {

  heroes$!: Observable<Hero[]>;

  constructor(private heroService: HeroService) {
  }

  ngOnInit(): void {
      this.heroes$ = this.heroService.searchTerms.pipe(
        // wait 300ms after each keystroke before considering the term
        debounceTime(300),
        // ignore new term if same as previous term
        distinctUntilChanged(),
        // switch to new search observable each time the term changes
        switchMap((term: string) => this.heroService.searchHeroes(term))
      );
      // .subscribe(value => this.heroes$ = this.heroService.searchHeroes(value));
  }

}
