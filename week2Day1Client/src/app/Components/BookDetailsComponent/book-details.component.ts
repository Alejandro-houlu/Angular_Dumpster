import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { BookDetails } from 'src/app/models';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  bookId!:string
  book!:BookDetails

  constructor(private activeRoute: ActivatedRoute,
    private bookService: BookService,
    private title: Title) { }

  ngOnInit(): void {
    this.bookId = this.activeRoute.snapshot.params['bookId']
    this.title.setTitle(`Book: ${this.bookId}`)
    this.bookService.getBookById(this.bookId)
      .then(result=>{
        console.info(">>>>> Book: ",result)
        this.book = result
      })
      .catch(error=>{
        console.error(">>>>> Error: ",error)
      })
  }




}
