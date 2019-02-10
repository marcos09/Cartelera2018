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

  profesors: User[];
  createBillboardForm: FormGroup;
  items: FormArray;

  constructor(private billboardService: BillboardService,
    private formBuilder: FormBuilder, private appDataService: AppDataService) { }


  ngOnInit() {
    this.createBillboardForm = this.formBuilder.group({
      nameBillboard: '',
      items: this.formBuilder.array([ this.createItem() ])
    });
    this.profesors = this.appDataService.getProfesors2$().subscribe(
      res => {
        this.profesors = res;
      }
    );
    this.addItem();
    this.addItem();
    this.addItem();

  }

  addItem(): void {
    this.items = this.createBillboardForm.get('items') as FormArray;
    this.items.push(this.createItem());
  }


  createItem(): FormGroup {
    return this.formBuilder.group({
      username: 'Hola',
      //[{value: 'Username', disabled: true}],
      firstname: '',
      lastname: 's',
    });
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


  deleteUser(i) {
    this.items.removeAt(i);
  }



}
