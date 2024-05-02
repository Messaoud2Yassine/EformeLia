import { Component, OnInit } from '@angular/core';
import { authService} from '../services/auth.service';
import {NgForm} from '@angular/forms';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null,
    roles : null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: authService) { }

  ngOnInit(): void {

  }
  
  onSubmit(f :NgForm): void {
    const { username, email, password ,roles} = this.form;

    this.authService.register(username, email, password,roles).subscribe({
      next:data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      error:err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
  });
  }
}