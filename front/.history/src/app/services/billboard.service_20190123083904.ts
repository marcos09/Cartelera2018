import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'environments/environment';

@Injectable()
export class BillboardService {

  httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
    })
  };

  constructor(private http: Http) { }

  getBillboards(){
    return this.http.get(environment.url + 'carteleras/list').map(res => res.json());
  }

  createBillboars() {
    return this.http.post(environment.url + 'carteleras/create').map(res => res.json());
  }

}
