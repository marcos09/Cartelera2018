import { Component, OnInit } from '@angular/core';
import { FormGroup, FormArray } from '@angular/forms';

@Component({
  selector: 'app-new-billboard',
  templateUrl: './new-billboard.component.html',
})
export class NewBillboardComponent implements OnInit {

  profesors$;
  createBillboardForm: FormGroup;
  users: FormArray;

  constructor() { }

  ngOnInit() {
    this.createBillboardForm = this.formBuilder.group({
      nameBillboard: '',
      writeUsers: this.formBuilder.array([ this.createUser() ])
    });
    this.profesors$ = this.appDataService.getProfesors();

  }

  createUser(): FormGroup {
    return this.formBuilder.group({
      name: '',
      description: '',
      price: ''
    });
  }

  addItem(): void {
    this.users = this.createBillboardForm.get('writeUsers') as FormArray;
    this.users.push(this.createUser());
  }

  onSubmit() {
    this.billboardService.create(this.createBillboardForm.value).subscribe(
      result => {
        this.billboards$ = this.billboardService.getBillboards();
      },
      error => {
        console.log('Error');
      }
    );
  }


}
