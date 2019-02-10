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

  constructor(private billboardService: BillboardService,
     private appDataService: AppDataService) { }

  ngOnInit() {
    this.billboards$ = this.billboardService.getBillboards();
    this.profesors$ = this.appDataService.getProfesors();

  }



}
