import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/component/login/login/login.component';
import { LogoutComponent } from './auth/component/logout/logout/logout.component';
import { SignUpComponent } from './auth/component/sign-up/sign-up.component';
import { AuthguardService } from './auth/service/authguard.service';
import { BookComponent } from './component/book/book.component';
import { CheckedoutComponent } from './component/checkedout/checkedout.component';
import { EventComponent } from './component/event/event.component';
import { FeeComponent } from './component/fee/fee.component';
import { LibbookComponent } from './component/libbook/libbook.component';
import { LibdashboardComponent } from './component/libdashboard/libdashboard.component';
import { LibrequestComponent } from './component/librequest/librequest.component';
import { LibvideoComponent } from './component/libvideo/libvideo.component';
import { PatdashboardComponent } from './component/patdashboard/patdashboard.component';
import { PatronComponent } from './component/patron/patron.component';
import { RequestComponent } from './component/request/request.component';
import { RoomComponent } from './component/room/room.component';
import { VideoComponent } from './component/video/video.component';

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'login', component: LoginComponent},
  {path:'sign-up', component: SignUpComponent},
  {path:'patdashboard', component: PatdashboardComponent, canActivate:[AuthguardService]},
  {path:'libdashboard', component: LibdashboardComponent, canActivate:[AuthguardService]},
  {path:'book', component: BookComponent, canActivate:[AuthguardService]},
  {path:'video', component: VideoComponent, canActivate:[AuthguardService]},
  {path:'request', component: RequestComponent, canActivate:[AuthguardService]},
  {path:'libbook', component: LibbookComponent, canActivate:[AuthguardService]},
  {path:'libvideo', component: LibvideoComponent, canActivate:[AuthguardService]},
  {path:'librequest', component: LibrequestComponent, canActivate:[AuthguardService]},
  {path:'patron', component: PatronComponent, canActivate:[AuthguardService]},
  {path:'checkedout', component: CheckedoutComponent, canActivate:[AuthguardService]},
  {path:'event', component: EventComponent, canActivate:[AuthguardService]},
  {path:'fee', component: FeeComponent, canActivate:[AuthguardService]},
  {path:'room', component: RoomComponent, canActivate:[AuthguardService]},
  {path:'logout', component: LogoutComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
