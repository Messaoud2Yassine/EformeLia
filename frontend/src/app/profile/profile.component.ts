import { Component , OnInit } from '@angular/core';
import { TokenStorageService } from '../services/token-strorage.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  isLoggedIn = false;
  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.isLoggedIn = !!this.token.getToken();
    console.log(this.currentUser);
    console.log(this.token.getUser().id);
  }
}