import {Component, OnInit} from '@angular/core';

import {AppDataService} from '../services/app-data.service';
import { BillboardService } from 'app/services/billboard.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
})
export class AdminComponent implements OnInit {
  users$;
  billboards$;

  constructor(private appDataService: AppDataService,
    private billboardService: BillboardService) {
  }

  ngOnInit() {
    this.users$ = this.appDataService.getUsers();
    this.billboards$ = this.billboardService.getBillboards();
  }
}
