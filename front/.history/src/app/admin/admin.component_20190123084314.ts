import {Component, OnInit} from '@angular/core';

import {AppDataService} from '../services/app-data.service';
import { BillboardService } from 'app/services/billboard.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
})
export class AdminComponent implements OnInit {
  users$;
  billboards$;

  createBillboardForm: FormGroup;

  constructor(private appDataService: AppDataService,
    private billboardService: BillboardService,
    private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.users$ = this.appDataService.getUsers();
    this.billboards$ = this.billboardService.getBillboards();

    this.createBillboardForm = this.formBuilder.group({
      nameBillboard: '',
    });
  }

  onSubmit() {

    this.billboardService.create().subscribe(
      result => {
        this.billboards$ = this.billboardService.getBillboards();

      },
      error => {
        console.log("Error");
      }
    );
  }

}
