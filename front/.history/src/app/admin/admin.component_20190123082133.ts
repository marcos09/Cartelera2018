import {Component, OnInit} from '@angular/core';

import {AppDataService} from '../services/app-data.service';
import { BillboardService } from 'app/services/billboard.service';
import { FormBuilder, FormGroup, FormArray } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
})
export class AdminComponent implements OnInit {
  users$;
  billboards$;

  orderForm: FormGroup;
  items: FormArray;

  constructor(private appDataService: AppDataService,
    private billboardService: BillboardService,
    private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.users$ = this.appDataService.getUsers();
    this.billboards$ = this.billboardService.getBillboards();

    this.orderForm = this.formBuilder.group({
      nameBillboard: '',
    });

  }
}
