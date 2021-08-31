import {Component, OnInit} from '@angular/core';
import {Hero} from '../hero';
import {HeroService} from '../hero.service';
import {Observable} from "rxjs";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public heroes$!: Observable<Hero[]>;
  str = 'string';

  constructor(public heroService: HeroService) {
  }

  ngOnInit() {
    this.heroes$ = this.heroService.getHeroes();
    this.heroService.searchTerms
      .subscribe(value => console.log('from dashboard: ' + value))
  }

  onEvent(event: string) {
    console.log(event);
  }
}
