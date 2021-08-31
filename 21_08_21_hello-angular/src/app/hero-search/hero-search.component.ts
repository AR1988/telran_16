import {Component, EventEmitter, Input, Output} from '@angular/core';
import {HeroService} from "../hero.service";

@Component({
  selector: 'app-hero-search',
  templateUrl: './hero-search.component.html',
  styleUrls: ['./hero-search.component.css']
})
export class HeroSearchComponent {

  @Output()
  searchTerm: EventEmitter<string> = new EventEmitter<string>();

  constructor(public heroService: HeroService) {
  }

  search(term: string): void {
    this.heroService.searchTerms.next(term);

    this.searchTerm.emit('search: ' + term);
  }
}
