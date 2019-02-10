import { Component, OnInit } from '@angular/core';
import { FormGroup, FormArray, FormBuilder } from '@angular/forms';
import { AppDataService } from 'app/services/app-data.service';
import { BillboardService } from 'app/services/billboard.service';
import { User } from 'app/model/user';

@Component({
  selector: 'app-new-billboard',
  templateUrl: './new-billboard.component.html',
})
export class NewBillboardComponent implements OnInit {


  orderForm: FormGroup;
  items: FormArray;

  constructor(private billboardService: BillboardService,
    private formBuilder: FormBuilder, private appDataService: AppDataService) { }


  ngOnInit() {
    this.orderForm = this.formBuilder.group({
      customerName: '',
      email: '',
      items: this.formBuilder.array([ this.createItem() ])
    });
  }

  addItem(): void {
    this.items = this.orderForm.get('items') as FormArray;
    this.items.push(this.createItem());
  }


  createItem(): FormGroup {
    return this.formBuilder.group({
      name: '',
      description: '',
      price: ''
    });
  }


  /*
  profesors$;
  createBillboardForm: FormGroup;
  users: FormArray;

  constructor(private billboardService: BillboardService,
    private formBuilder: FormBuilder, private appDataService: AppDataService) { }

  ngOnInit() {
    this.createBillboardForm = this.formBuilder.group({
      nameBillboard: '',
      writeUsers: this.formBuilder.array([])
    });
    this.profesors$ = this.appDataService.getProfesors();
  }




  onSubmit() {
    this.billboardService.create(this.createBillboardForm.value).subscribe(
      result => {
      },
      error => {
        console.log('Error');
      }
    );
  }

  */
}
