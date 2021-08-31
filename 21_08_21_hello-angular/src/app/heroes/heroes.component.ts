import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Hero} from "../hero";
import {HeroService} from "../hero.service";
import {MessageService} from "../message.service";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit, OnDestroy {

  heroes: Hero[] | undefined;
  selectedHero: Hero | undefined;

  form!: FormGroup;
  submitted = false;

  constructor(private heroService: HeroService,
              private messageService: MessageService,
              private router: Router,
              private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.fb.group({
        name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]]
      }
    );

    this.getHeroes();
  }

  getHeroes(): void {
    this.heroService.getHeroes()
      .subscribe(data => this.heroes = data,
        error => console.log(error));
  }


  onSelectHero(id: number): void {
    const promise: Promise<boolean> = this.router.navigate(['details', id],
      {
        fragment: 'fragment',
        queryParams: {param: 'param-pam-pam'}
      });

    promise.then(value => console.log(value))
      .catch(value => console.log(value));
  }

  ngOnDestroy(): void {
    console.log("HeroesComponent destroyed")
  }

  add(name: string): void {
    this.submitted = false;

    name = name.trim();
    if (!name) {
      return;
    }

    this.heroService.addHero({name} as Hero)
      .subscribe(hero => {
        this.getHeroes();
      });
  }

  delete(hero: Hero): void {
    this.heroService.deleteHero(hero)
      .subscribe(() => this.heroes = this.heroes!.filter(h => h !== hero));
  }

  onSubmit() {
    this.submitted = true;

    if (this.form.valid) {
      const heroName = this.form.controls.name.value;
      this.add(heroName);
    }
  }
}
