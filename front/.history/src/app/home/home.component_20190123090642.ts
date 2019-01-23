import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BillboardService } from 'app/services/billboard.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit {
  billboards$;
  createBillboardForm: FormGroup;

  constructor(private billboardService: BillboardService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.billboards$ = this.billboardService.getBillboards();
    this.createBillboardForm = this.formBuilder.group({
      nameBillboard: '',
      otherData: 'Datos'
    });

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
