import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {

  form!:FormGroup
  itemArrCtrl!: FormArray

  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
    this.form = this.createForm()
  }

processForm() {
  const data = this.form.value
  console.info('>>>> data: ', data)
}

addItem(){
  const item = this.fb.group({
    item: this.fb.control<string>(""),
    quantity: this.fb.control<number>(1)
  })
  this.itemArrCtrl.push(item)
}

private createForm(): FormGroup{
  this.itemArrCtrl = this.fb.array([])

  return this.fb.group({
    name: this.fb.control<string>(""),
    mobile: this.fb.control<number>(0),
    items: this.itemArrCtrl
  })

}



}
