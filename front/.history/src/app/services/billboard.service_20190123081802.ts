import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from 'environments/environment';

@Injectable()
export class BillboardService {

  constructor(private http: Http) { }

  getBillboards(){
    return this.http.get(environment.url + 'carteleras/list').map(res => res.json());
  }

}
