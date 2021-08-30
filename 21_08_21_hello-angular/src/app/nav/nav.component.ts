import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-nav',
  template: `
    <nav>
      <a routerLink="dashboard">Dashboard</a>
      <a routerLink="heroes">Heroes</a>
      <a [routerLink]="['/']">Home</a>
    </nav>
  `,
  styles: ['h1 {font-size: 1.2em; margin-bottom: 0;}',
    'h2 { font-size: 2em; margin-top: 0; padding-top: 0;}',
    'nav a {padding: 5px 10px;text-decoration: none; margin-top: 10px; display: inline-block; background-color: #eee; border-radius: 4px;}',
    'nav a:visited, a:link {  color: #334953;}',
    'nav a:hover {  color: #039be5;  background-color: #cfd8dc;}',
    'nav a.active {color: #039be5;}'
  ]
})

export class NavComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }
}
