import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray } from '@angular/forms';
import { BillboardService } from 'app/services/billboard.service';
import { AppDataService } from 'app/services/app-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit {
  billboards$;
  profesors$;
  createBillboardForm: FormGroup;
  users: FormArray;
  constructor(private billboardService: BillboardService,
    private formBuilder: FormBuilder, private appDataService: AppDataService) { }

  ngOnInit() {
    this.billboards$ = this.billboardService.getBillboards();
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
