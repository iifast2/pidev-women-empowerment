import { Component, OnInit } from '@angular/core';
import {Login} from '../model/login';
import {LoginService} from '../service/login.service';
import {Router} from '@angular/router';
import {UserService} from '../service/user.service';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  login: Login = new Login();
  constructor(private loginService: LoginService, private router: Router,private userService: UserService  ) { }

  ngOnInit(): void {
this.login = new Login() ;
  }

  register() {
    this.loginService.authenticate(this.login).subscribe(res => {
      // @ts-ignore
      console.log(res);
      // @ts-ignore
      console.log(res.token);

      // @ts-ignore
      // localStorage.token = res.jwt;
      localStorage.setItem('token', JSON.stringify(res.token));
      this.router.navigateByUrl('/main');
      this.userService.findUserWithToken().subscribe(result => {
        // @ts-ignore
        this.user = result;
        console.log(result);
        // @ts-ignore
        localStorage.nom = result.nom;
        // @ts-ignore
        localStorage.roles = result.roles;
      });
    });

  }
}









/*
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  focus;
  focus1;
  constructor() { }

  ngOnInit() {
  }

}
*/
