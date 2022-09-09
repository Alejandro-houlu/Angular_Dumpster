import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { Registration } from '../models';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  form!:FormGroup

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.createForm()
  }

  @Output()
  onNewRegistration = new Subject<Registration>()

  private createForm(): FormGroup {
    return this.fb.group({

      name: this.fb.control<string>('', Validators.required),
      email: this.fb.control<string>('', Validators.required)
      
    })
  }

  processForm(){
    const registration: Registration = this.form.value as Registration
    console.info('>>>>>Registration form: ', registration)
    this.onNewRegistration.next(registration)
  }

}
