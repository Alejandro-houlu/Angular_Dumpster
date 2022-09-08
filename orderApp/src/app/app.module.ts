import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { OrderFormComponent } from './components/order-form.component';
import { DisplayComponent } from './components/display.component';

@NgModule({
  declarations: [
    AppComponent,
    OrderFormComponent,
    DisplayComponent
  ],
  imports: [
    BrowserModule,
    FormsModule, ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
