import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Todo } from '../model';
import { TodoService } from '../Services/todo.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit, OnDestroy {

  todos: Todo[] = []
  sub$!: Subscription

  constructor(private todoSvc: TodoService) { }

  ngOnInit(): void {
    this.sub$ = this.todoSvc.onNewData.subscribe(data=>{
      console.info(">>>>> in sub: ",data)
      this.todos = data
    })
  }

  ngOnDestroy(): void {
      this.sub$.unsubscribe
  }

  

}
