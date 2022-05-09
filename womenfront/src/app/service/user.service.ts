import { Injectable } from '@angular/core';
// @ts-ignore
import {Observable} from "rxjs/dist/types";
import {User} from "../model/user";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../../../womenfront1/src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl = environment.webservice.baseUrl;
  private headers: HttpHeaders = new HttpHeaders();


  constructor(private http: HttpClient) {
  }

  public findUserWithToken() {
    this.headers = new HttpHeaders({Authorization: 'Bearer ' + JSON.parse(<string>localStorage.getItem('token'))});
    return this.http.get(this.baseUrl + 'auth', {headers: this.headers});
  }

  add(user: User) {
    this.headers = new HttpHeaders({Authorization: 'Bearer ' + JSON.parse(<string>localStorage.getItem('token'))});
    return this.http.post(this.baseUrl + 'users', user, {
      headers: this.headers
    });
  }

  list(): Observable<any> {
    this.headers = new HttpHeaders({Authorization: 'Bearer ' + JSON.parse(<string>localStorage.getItem('token'))});
    return this.http.get(this.baseUrl + 'users', {
      headers: this.headers
    });
  }

  remove(id: any) {
    this.headers = new HttpHeaders({Authorization: 'Bearer ' + JSON.parse(<string>localStorage.getItem('token'))});
    return this.http.delete(this.baseUrl + 'users/' + id, {
      headers: this.headers
    });
  }

  modify(user: User) {
    this.headers = new HttpHeaders({Authorization: 'Bearer ' + JSON.parse(<string>localStorage.getItem('token'))});
    return this.http.put(this.baseUrl + 'users', user, {
      headers: this.headers
    });
  }

  findById(id: any): Observable<User> {
    this.headers = new HttpHeaders({Authorization: 'Bearer ' + JSON.parse(<string>localStorage.getItem('token'))});
    // @ts-ignore
    return this.http.get(this.baseUrl + 'utilisateur/' + id , {
      headers: this.headers
    });
  }
}
