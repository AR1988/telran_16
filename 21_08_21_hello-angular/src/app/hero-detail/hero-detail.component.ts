import {Component, OnInit} from '@angular/core';
import {Hero} from "../hero";
import {ActivatedRoute} from "@angular/router";
import {HeroService} from "../hero.service";
import {Location} from '@angular/common';
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {

  hero: Hero | undefined;
  message: string | undefined;

  constructor(private route: ActivatedRoute,
              private heroService: HeroService,
              private location: Location) {
  }

  ngOnInit(): void {

    this.getHero();
  }

  private getHero(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.message = undefined;
    this.heroService.getHero(id)
      .subscribe(value => this.hero = value,
        (error: HttpErrorResponse) => this.getHeroByIdError(error));
  }

  private getHeroByIdError(error: HttpErrorResponse) {

    if (error.status === 0) {
      this.message = 'Connection error';
    }

    if(error.error.errorMsg && error.error.errorMsg === 'HERO not found')
      this.message ='герой не найден';

    if(!this.message)
    this.message =  "error";
    // if (error.error.errorMsg)
    //   this.message = error.error.errorMsg;
    // else
    //   this.message = "что то пошло нет"
  }

  goBack(): void {
    this.location.back();
  }

  save() {
    if (this.hero) {
      this.heroService.updateHero(this.hero)
        .subscribe(() => this.goBack());
    }
  }

}
