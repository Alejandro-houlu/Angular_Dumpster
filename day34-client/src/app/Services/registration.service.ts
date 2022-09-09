import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom } from "rxjs";
import { Registration } from "../models";

@Injectable()
export class RegistrationService{
    constructor(private http: HttpClient){}

    newRegistration(registration: Registration): Promise<Response>{

        const URL = "http://localhost:8080/api/registration"

        const headers = new HttpHeaders()
            .set('Content-Type','application/json')
            .set('Accept','application/json')

            return lastValueFrom(
            this.http.post<Response>(URL, registration,{headers})
                //.pipe()
            )
            
            

    }
}