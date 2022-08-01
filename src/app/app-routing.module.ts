import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { BookComponent } from './component/book/book.component';
import { CheckedoutComponent } from './component/checkedout/checkedout.component';
import { EventComponent } from './component/event/event.component';
import { FeeComponent } from './component/fee/fee.component';
import { LibdashboardComponent } from './component/libdashboard/libdashboard.component';
import { LoginComponent } from './component/login/login.component';
import { PatdashboardComponent } from './component/patdashboard/patdashboard.component';
import { PatronComponent } from './component/patron/patron.component';
import { RequestComponent } from './component/request/request.component';
import { RoomComponent } from './component/room/room.component';
import { VideoComponent } from './component/video/video.component';

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'patdashboard', component: PatdashboardComponent},
  {path:'libdashboard', component: LibdashboardComponent},
  {path:'book', component: BookComponent},
  {path:'video', component: VideoComponent},
  {path:'request', component: RequestComponent},
  {path:'patron', component: PatronComponent},
  {path:'book', component: BookComponent},
  {path:'checkedout', component: CheckedoutComponent},
  {path:'event', component: EventComponent},
  {path:'fee', component: FeeComponent},
  {path:'room', component: RoomComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
