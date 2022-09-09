import { Component, OnInit } from '@angular/core';
import { Registration } from './models';
import { RegistrationService } from './Services/registration.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'day34-client';

  constructor(private regSvc : RegistrationService){}
  
  ngOnInit():void{

  }


  processNewRegistration(registration: Registration){
    console.info(">>>>>From app.root: ", registration)

    this.regSvc.newRegistration(registration)
      .then(result=>{
        console.info(">>>>>Result: ", result)
      })
      .catch(error=>{
        console.error(">>>>>Error: ",error)
      })
  }
}
