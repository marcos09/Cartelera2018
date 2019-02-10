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
    return this.http.get(environment.url + 'billboards/list').map(res => res);
  }

  create(billboard: Billboard) {
    console.log(billboard);
    const url = environment.url + 'billboards/create';
    this.httpOptions.headers.set('Content-Type', 'application/json');
    return this.http.put(url, billboard, this.httpOptions);
  }

  addPublication() {

  }

  removePublication() {

  }

  addWriteUser() {

  }

  removeWriteUser() {

  }
}
