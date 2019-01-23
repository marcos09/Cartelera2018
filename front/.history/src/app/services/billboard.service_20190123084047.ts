import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'environments/environment';
import { Billboard } from 'app/model/billboard';

@Injectable()
export class BillboardService {

  httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
    })
  };

  constructor(private http: HttpClient) { }

  getBillboards(){
    return this.http.get(environment.url + 'carteleras/list').map(res => res.json());
  }

  createBillboars(billboard: Billboard) {
    const url = environment.url + 'carteleras/create';
    this.httpOptions.headers.set('Content-Type', 'application/json');
    return this.http.post(url, billboard, this.httpOptions).map(res => res.json());
  }

}
