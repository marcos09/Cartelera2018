import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new-billboard',
  templateUrl: './new-billboard.component.html',
})
export class NewBillboardComponent implements OnInit {

  profesors$;
  createBillboardForm: FormGroup;
  users: FormArray;

  constructor() { }

  ngOnInit() {
  }

}
