import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable()
export class UserlistService {

  userData:any = {};
  constructor(private http : HttpClient) { }

  getUserData(){
    return this.userData;
  }

  setUserData(data){
    this.userData = data;

  }

  postUserDetails(data){
    return this.http.post("http://localhost:8080/registerUser",data);
  }

  authenticateUser(data){
    return this.http.post("http://localhost:8080/authenticateUser",data,  {
      responseType : 'text'
    }
    );
  }


}
