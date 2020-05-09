import { Component, OnInit } from '@angular/core';
import { UserlistService } from '../userlist.service';
import { FormBuilder, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userlistService : UserlistService, private fb : FormBuilder) { }

  signUpForm : FormGroup;

  ngOnInit() {
    this.signUpForm = this.fb.group({
      'email' : [null],
      'phone' : [null],
      'fname' : [null],
      'lname' : [null],
      'password' : [null]
  
    });
  }
  onSubmit(value){
    console.log(value);
    this.userlistService.postUserDetails(value).subscribe(
      data => console.log("Successs")
    );
  }

}
