import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FlexLayoutModule } from '@angular/flex-layout';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { MaterialModule } from './modules/material/material.module';

import { AppComponent } from './app.component';
import { IndexComponent } from './components/index/index.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ImageCarouselComponent } from './components/image-carousel/image-carousel.component';
import { ImageCarouselDialogComponent } from './components/image-carousel/image-carousel-dialog/image-carousel-dialog.component';
import { NavbarComponent } from './components/navbar/navbar.component';

import { RangePipe } from './pipes/range.pipe';
import { ProfileComponent } from './components/profile/profile.component';
import { V2IndexComponent } from './components/v2-index/v2-index.component';
import { SearchFormComponent } from './components/search-form/search-form.component';
import { NotInPipe } from './pipes/not-in.pipe';
import { AccommodationDetailComponent } from './components/accommodation-detail/accommodation-detail.component';
import { ReviewListDialogComponent } from './components/review-list-dialog/review-list-dialog.component';
import { ConversationComponent } from './components/conversation/conversation.component';
import { LoginDialogComponent } from './components/login-dialog/login-dialog.component';
import { OptionDialogComponent } from './components/option-dialog/option-dialog.component';
import { BeforeTodayPipe } from './pipes/before-today.pipe';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    RegisterComponent,
    ImageCarouselComponent,
    ImageCarouselDialogComponent,
    RangePipe,
    NotInPipe,    
    NavbarComponent,
    ProfileComponent,
    V2IndexComponent,
    SearchFormComponent,
    AccommodationDetailComponent,
    ReviewListDialogComponent,
    ConversationComponent,
    LoginDialogComponent,
    OptionDialogComponent,
    BeforeTodayPipe,
  ],
  imports: [
    BrowserModule,
    FlexLayoutModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    MaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    OptionDialogComponent,
    LoginDialogComponent,
    ReviewListDialogComponent,
    ImageCarouselDialogComponent
  ]
})
export class AppModule { }
