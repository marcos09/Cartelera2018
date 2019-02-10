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

  profesors$;
  createBillboardForm: FormGroup;
  users: FormArray;

  constructor(private billboardService: BillboardService,
    private formBuilder: FormBuilder, private appDataService: AppDataService) { }

  ngOnInit() {
    this.createBillboardForm = this.formBuilder.group({
      nameBillboard: '',
      writeUsers: this.formBuilder.array([ this.createUser() ])
    });
    this.profesors$ = this.appDataService.getProfesors();

  }

  createUser(): FormGroup {
    return this.formBuilder.group({
      new User:,
    });
  }

  addItem(): void {
    this.users = this.createBillboardForm.get('writeUsers') as FormArray;
    this.users.push(this.createUser());
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


}
