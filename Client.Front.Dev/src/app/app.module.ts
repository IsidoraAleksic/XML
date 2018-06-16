import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FlexLayoutModule } from '@angular/flex-layout';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

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

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    RegisterComponent,
    ImageCarouselComponent,
    ImageCarouselDialogComponent,
    RangePipe,
    NavbarComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    FlexLayoutModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    ImageCarouselDialogComponent
  ]
})
export class AppModule { }
