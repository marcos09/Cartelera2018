import { Injectable } from '@angular/core';

@Injectable()
export class BillboardService {

  constructor(private http: Http) { }

  getBillboards(){
    return this.http.get(environment.url + '/carteleras/list').map(res => res.json());
  }

}
