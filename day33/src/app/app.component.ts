import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Todo } from './model';
import { TodoService } from './Services/todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'day33';

  constructor(private todoSvc: TodoService){}

  getData(){
    this.todoSvc.getTodo(Math.floor(Math.random()*10)+1)
      .then(this.take10)
      .then(this.processTodo)
      .catch(err=>{console.error("error: ",err)})
  }

  take10(todo:Todo[]){
    return todo.slice(0,10)
  }

  processTodo(todo:Todo[]){
    console.info(">>>>> processing todos: ",todo)
  }



  
  
}
