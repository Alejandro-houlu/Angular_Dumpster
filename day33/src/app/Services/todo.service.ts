import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom, Subject, tap } from "rxjs";
import { Todo } from "../model";

@Injectable()
export class TodoService{

    onNewData = new Subject<Todo[]>()

    constructor(private http: HttpClient){}

    getTodo(userId: number): Promise<Todo[]>{
        const params = new HttpParams().set('userId', userId)

        return firstValueFrom(
            this.http.get<Todo[]>('https://jsonplaceholder.typicode.com/todos', {params})

                .pipe(
                    tap(data=>{
                        console.info(">>>>>In tap")
                        this.onNewData.next(data)
                    })
                )
        )
    }
}