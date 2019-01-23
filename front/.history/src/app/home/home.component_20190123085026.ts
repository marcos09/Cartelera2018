import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { BillboardService } from 'app/services/billboard.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit {

  constructor(private billboardService: BillboardService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.billboards$ = this.billboardService.getBillboards();
    this.createBillboardForm = this.formBuilder.group({
      nameBillboard: '',
    });

  }

}
