import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Router, RouterEvent, RoutesRecognized } from '@angular/router';
import { AuthService } from './auth/service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  constructor(private authService: AuthService, private router: Router){}

  username: string;
  isPat: boolean;
  isLib: boolean;
  private routeData;
  ngOnInit() {
    this.authService.username$.subscribe(data=>{
        this.username = data;
    });
    this.router.events.subscribe((data) =>{
      if (data instanceof RoutesRecognized) {
      this.routeData = data.state.root.firstChild.data;
        if(this.routeData.role == 'PATRON'){
          this.isPat = true;
        }
        else if(this.routeData.role == 'LIBRARIAN'){
          this.isLib = true;
        }
        else{
          this.isPat = false;
          this.isLib = false;
        }
      }
     });
  }

}
