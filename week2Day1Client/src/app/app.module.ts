import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router'
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { BookListComponent } from './Components/BookListComponent/book-list.component';
import { BookService } from './Services/book.service';
import { BookDetailsComponent } from './Components/BookDetailsComponent/book-details.component';

const appRoutes: Routes = [
  {path: '', component: BookListComponent},
  {path:'api/bookDetails/:bookId',component:BookDetailsComponent},

  //catch all
  {path: '**', redirectTo: '/', pathMatch:'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookDetailsComponent
  ],
  imports: [
    BrowserModule, HttpClientModule,
    RouterModule.forRoot(appRoutes,{useHash:true}),
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
