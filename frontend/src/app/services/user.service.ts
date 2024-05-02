import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL = 'http://localhost:8080/api/test/';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', {                                                                                                                  });
  }
  getAllForms(): Observable<any> {
    return this.http.get("http://localhost:8080/api/forms/all", { responseType: 'json' });
  }
  getFormById(id: string): Observable<any> {
    return this.http.get("http://localhost:8080/api/forms/"+id, { responseType: 'json' });
  }
  createInputValue(inputValue: any): Observable<any> {
    return this.http.post("http://localhost:8080/api/inputValues/create", inputValue, { responseType: 'json' });
  }
  getInputValueById(idInputValue: string,idUser: String): Observable<any> {
    return this.http.get("http://localhost:8080/api/inputValues/"+idInputValue+"/"+idUser, { responseType: 'text' });
  }
  generateFlux(form : any): Observable<any> {
    return this.http.post("http://localhost:8080/api/flux/update-xml", form, { responseType: 'text' });
  }
}
