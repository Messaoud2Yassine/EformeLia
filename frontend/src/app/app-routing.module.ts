import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminBoardComponent } from './admin-board/admin-board.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ModBoardComponent } from './mod-board/mod-board.component';
 import { RegistrationComponent } from './registration/registration.component';
import { UserBoardComponent } from './user-board/user-board.component';
import { ProfileComponent } from './profile/profile.component';
const routes: Routes = [
{path:'home', component:HomeComponent},
{path:'admin', component:AdminBoardComponent},
{path:'mod', component:ModBoardComponent},
{path:'user', component:UserBoardComponent},
{path:'signin', component:LoginComponent},
{path:'profile', component:ProfileComponent},
{path:'signup', component:RegistrationComponent},
{ path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
