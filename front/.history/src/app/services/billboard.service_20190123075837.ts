import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Billboard } from 'app/model/billboard';
import { environment } from 'environments/environment';

@Injectable()
export class BillboardService {

  constructor(private http: Http) { }

  getBillboards(): Observable<Billboard> {
    return this.http.get(environment.url + '/carteleras/list')
  }
}
