import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserlistService } from '../userlist.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm : FormGroup;
  userName : any;
  submitted:boolean = false;

  constructor(private fb : FormBuilder, private userlistService : UserlistService, private router : Router) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      'email' : [null, Validators.required],
      'password' : [null, Validators.required]
    })

  }

  onSubmit(value){
    console.log("In");
    console.log(value);
    this.userlistService.authenticateUser(value).subscribe(
      response => {
        this.submitted = true;
        this.userName = response;
        sessionStorage.setItem("userName",this.userName);
        sessionStorage.setItem("email",value.email);
        sessionStorage.setItem("password",value.password);
        if(response){
            this.router.navigateByUrl("/home");
        }
        console.log("Successs", this.userName)
      }
    );
    this.loginForm.reset();
  }

}
