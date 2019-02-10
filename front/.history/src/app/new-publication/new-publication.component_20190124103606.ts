import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BillboardService } from 'app/services/billboard.service';

@Component({
  selector: 'app-new-publication',
  templateUrl: './new-publication.component.html',
})
export class NewPublicationComponent implements OnInit {

  publicationForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private billboardService: BillboardService) { }

  ngOnInit() {
    this.publicationForm = this.formBuilder.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      coments: ['', [Validators.required]],
  });
  }

}
