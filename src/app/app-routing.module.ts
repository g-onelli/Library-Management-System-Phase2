import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibrarianLoginComponent } from './auth/component/librarian-login/librarian-login.component';
import { LoginComponent } from './auth/component/login/login/login.component';
import { LogoutComponent } from './auth/component/logout/logout/logout.component';
import { PasswordResetComponent } from './auth/component/password-reset/password-reset.component';
import { SignUpComponent } from './auth/component/sign-up/sign-up.component';
import { UsernameVerifyComponent } from './auth/component/username-verify/username-verify.component';
import { AuthguardService } from './auth/service/authguard.service';
import { BookComponent } from './component/book/book.component';
import { CheckedoutComponent } from './component/checkedout/checkedout.component';
import { EventComponent } from './component/event/event.component';
import { FeeComponent } from './component/fee/fee.component';
import { LibbookComponent } from './component/libbook/libbook.component';
import { LibdashboardComponent } from './component/libdashboard/libdashboard.component';
import { LibfeeComponent } from './component/libfee/libfee.component';
import { LibrequestComponent } from './component/librequest/librequest.component';
import { LibroomComponent } from './component/libroom/libroom.component';
import { LibvideoComponent } from './component/libvideo/libvideo.component';
import { PatdashboardComponent } from './component/patdashboard/patdashboard.component';
import { PatronComponent } from './component/patron/patron.component';
import { RequestComponent } from './component/request/request.component';
import { RoomComponent } from './component/room/room.component';
import { VideoComponent } from './component/video/video.component';

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'login', component: LoginComponent},
  {path:'liblogin', component: LibrarianLoginComponent},
  {path:'sign-up', component: SignUpComponent},
  {path:'password-reset', component: UsernameVerifyComponent},
  {path:'password-reset-form', component: PasswordResetComponent},
  {path:'patdashboard', component: PatdashboardComponent, canActivate:[AuthguardService],
  data: {
    role: 'PATRON'
  }},
  {path:'libdashboard', component: LibdashboardComponent, canActivate:[AuthguardService],
  data: {
    role: 'LIBRARIAN'
  }},
  {path:'book', component: BookComponent, canActivate:[AuthguardService],
  data: {
    role: 'PATRON'
  }},
  {path:'video', component: VideoComponent, canActivate:[AuthguardService],
  data: {
    role: 'PATRON'
  }},
  {path:'request', component: RequestComponent, canActivate:[AuthguardService],
  data: {
    role: 'PATRON'
  }},
  {path:'libbook', component: LibbookComponent, canActivate:[AuthguardService],
  data: {
    role: 'LIBRARIAN'
  }},
  {path:'libvideo', component: LibvideoComponent, canActivate:[AuthguardService],
  data: {
    role: 'LIBRARIAN'
  }},
  {path:'librequest', component: LibrequestComponent, canActivate:[AuthguardService],
  data: {
    role: 'LIBRARIAN'
  }},
  {path:'patron', component: PatronComponent, canActivate:[AuthguardService],
  data: {
    role: 'LIBRARIAN'
  }},
  {path:'checkedout', component: CheckedoutComponent, canActivate:[AuthguardService],
  data: {
    role: 'PATRON'
  }},
  {path:'event', component: EventComponent, canActivate:[AuthguardService],
  data: {
    role: 'LIBRARIAN'
  }},
  {path:'libfee', component: LibfeeComponent, canActivate:[AuthguardService],
  data: {
    role: 'LIBRARIAN'
  }},
  {path:'libroom', component: LibroomComponent, canActivate:[AuthguardService],
  data: {
    role: 'LIBRARIAN'
  }},
  {path:'fee', component: FeeComponent, canActivate:[AuthguardService],
  data: {
    role: 'PATRON'
  }},
  {path:'room', component: RoomComponent, canActivate:[AuthguardService],
  data: {
    role: 'PATRON'
  }},
  {path:'logout', component: LogoutComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
