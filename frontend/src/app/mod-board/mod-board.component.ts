import { Component , OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
@Component({
  selector: 'app-mod-board',
  templateUrl: './mod-board.component.html',
  styleUrls: ['./mod-board.component.css']
})
export class ModBoardComponent implements OnInit {
  content?: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getModeratorBoard().subscribe({
     next: data => {
        this.content = data;
      },
      error:err => {
        this.content = JSON.parse(err.error).message;
      }
  });
  }
}