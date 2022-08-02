import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthguardService {

  constructor(private authService: AuthService, private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    //logic for authentication goes here
    let status = this.authService.isLoggedIn();
    if(status==false){
      //redirect to logincomponent
      this.authService.message$.next('Please Login to Continue');
      this.router.navigateByUrl('/login');
    }
    return status;
  }
}
