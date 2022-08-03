import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  constructor(private authService: AuthService){}

  username: string;
  ngOnInit(): void {
    this.authService.username$.subscribe(data=>{
        this.username = data;
    });
  }

}
