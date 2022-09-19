import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookSummary } from 'src/app/models';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books:BookSummary[] = []

  constructor(private bookService: BookService,
    private router: Router) { }

  ngOnInit(): void {
    this.bookService.getBooks()
      .then(result=>{
        console.info('>>>>>Books: ', result)
        this.books = result
      })
      .catch(error=>{
        console.error('>>>>> Error: ',error)
      })


  }

  getBook(bookId:String){
    this.router.navigate(['/api/bookDetails/',bookId])
  }



}
