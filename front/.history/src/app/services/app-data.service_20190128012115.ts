import {Injectable} from '@angular/core';
import {AuthHttp} from 'angular2-jwt';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs/Observable';
import { User } from 'app/model/user';

@Injectable()
export class AppDataService {
  constructor(private http: AuthHttp) {
  }

  getCities$() {
    return this.http.get(environment.url + 'springjwt/cities').map(res => res.json());
  }

  getUsers$() {
    return this.http.get(environment.url + 'springjwt/users').map(res => res.json());
  }

  getProfesors$() {
    return this.http.get(environment.url + 'users/usersProfesor').map(res => res.json());
  }

  getProfesors2$(): Observable<User[]> {
    return this.http.get<User[]>(environment.url + 'users/usersProfesor');
  }



}