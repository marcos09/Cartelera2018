import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { BillboardService } from 'app/services/billboard.service';

@Component({
  selector: 'app-new-publication',
  templateUrl: './new-publication.component.html',
})
export class NewPublicationComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private billboardService: BillboardService) { }

  ngOnInit() {

  }

}
