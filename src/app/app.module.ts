import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './component/book/book.component';
import { VideoComponent } from './component/video/video.component';
import { CheckedoutbookComponent } from './component/checkedoutbook/checkedoutbook.component';
import { CheckedoutvideoComponent } from './component/checkedoutvideo/checkedoutvideo.component';
import { RoomComponent } from './component/room/room.component';
import { PatronComponent } from './component/patron/patron.component';
import { LibrarianComponent } from './component/librarian/librarian.component';
import { EventComponent } from './component/event/event.component';
import { FeeComponent } from './component/fee/fee.component';
import { RequestComponent } from './component/request/request.component';
import { LibdashboardComponent } from './component/libdashboard/libdashboard.component';
import { PatdashboardComponent } from './component/patdashboard/patdashboard.component';
import { CheckedoutComponent } from './component/checkedout/checkedout.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LibrequestComponent } from './component/librequest/librequest.component';
import { LibbookComponent } from './component/libbook/libbook.component';
import { LibvideoComponent } from './component/libvideo/libvideo.component';
import { LogoutComponent } from './auth/component/logout/logout/logout.component';
import { LoginComponent } from './auth/component/login/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    VideoComponent,
    CheckedoutbookComponent,
    CheckedoutvideoComponent,
    RoomComponent,
    PatronComponent,
    LibrarianComponent,
    EventComponent,
    FeeComponent,
    RequestComponent,
    LibdashboardComponent,
    PatdashboardComponent,
    CheckedoutComponent,
    LoginComponent,
    LibrequestComponent,
    LibbookComponent,
    LibvideoComponent,
    LogoutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
