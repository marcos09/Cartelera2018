import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
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

  constructor(private billboardService: BillboardService,
    private formBuilder: FormBuilder, private appDataService: AppDataService) { }

  ngOnInit() {
    this.billboards$ = this.billboardService.getBillboards();
    this.createBillboardForm = this.formBuilder.group({
      nameBillboard: '',
    });
    this.profesors$ = this.appDataService.getProfesors();
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
