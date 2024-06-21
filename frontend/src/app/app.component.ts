import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { environment } from '../environments/environment';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    CommonModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'angular-tdd';
  libros: any = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.GetLibros();
  }

  public GetLibros() {
    this.http.get(`${environment.BASE_URL}/libros`).subscribe(data => this.libros = data);
  }
}
