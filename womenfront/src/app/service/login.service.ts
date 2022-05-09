import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../womenfront/src/environments/environment';
import {Login} from '../model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl = environment.webservice.baseUrl;

  constructor(private http: HttpClient ) { }
  public authenticate(login: Login) {

    return  this.http.post(this.baseUrl + 'token', login);
  }
}
