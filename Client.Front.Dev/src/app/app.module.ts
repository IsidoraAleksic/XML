import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { IndexComponent } from './components/index/index.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from './modules/material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ImageCarouselComponent } from './components/image-carousel/image-carousel.component';
import { ImageCarouselDialogComponent } from './components/image-carousel/image-carousel-dialog/image-carousel-dialog.component';
import { RangePipe } from './pipes/range.pipe';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    RegisterComponent,
    ImageCarouselComponent,
    ImageCarouselDialogComponent,
    RangePipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    ImageCarouselDialogComponent
  ]
})
export class AppModule { }
