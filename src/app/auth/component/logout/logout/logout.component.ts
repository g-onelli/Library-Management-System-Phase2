import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/service/auth.service';
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    localStorage.clear();
    this.authService.message$.next('Log out Successful');
    this.authService.username$.next('');
    this.authService.isLoggedIn();
    this.router.navigateByUrl('/login');
  }

}
