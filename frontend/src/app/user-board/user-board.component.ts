import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { TokenStorageService } from '../services/token-strorage.service';

@Component({
  selector: 'app-user-board',
  templateUrl: './user-board.component.html',
  styleUrls: ['./user-board.component.css']
})
export class UserBoardComponent implements OnInit {
  @Input() formData!: any[];

  form: any = {};
  forms: any[] = [];
  inputFields: any[] = [];
  showDetails = false;
  inputValue: any = {
    inputValueId: {
      idInputValue: null,
      idUser: null
    },
    inputValue: null
  };

  constructor(private userService: UserService, private token: TokenStorageService) { }

  ngOnInit(): void {
    console.log('Initializing UserBoardComponent...');
    this.getAllForms();
  }

  getAllForms(): void {
    console.log('Fetching forms...');
    this.userService.getAllForms().subscribe({
        next: (data) => {
            console.log('Forms fetched successfully:', data);
            this.forms = data;
            if (this.forms.length > 0) {
                this.getFormDetails(this.forms[0].id);
            }
        },
        error: (e) => {
            console.error('Error fetching forms:', e);
        }
    });
}

  getFormById(id: string): void {
    this.userService.getFormById(id).subscribe(
      data => {
        this.form = data;
        this.fetchInputValue();
      },
      err => {
        this.form = JSON.parse(err.error).message;
      }
    );
  }

  showFormDetails(id: string): void {
    this.showDetails = true;
    this.getFormById(id);
  }

  createInputValue(inputValue: any): any {
    return this.userService.createInputValue(inputValue);
  }

  getInputValueById(idInputValue: string, idUser: string): void {
    this.userService.getInputValueById(idInputValue, idUser).subscribe({
      next: (data) => {
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

getFormDetails(id: string): void {
  console.log('Fetching form details for form with ID:', id);
  this.userService.getFormById(id).subscribe(
      (data) => {
          console.log('Form details fetched successfully:', data);
          this.form = data;
          this.fetchInputValue();
      },
      (error) => {
          console.error('Error fetching form details:', error);
      }
  );
}
fetchInputValue() {
  if (this.form && this.form.tabs && this.form.tabs[0] && this.form.tabs[0].blocs && this.form.tabs[0].blocs[0] && this.form.tabs[0].blocs[0].lines && this.form.tabs[0].blocs[0].lines[0] && this.form.tabs[0].blocs[0].lines[0].inputFields && this.form.tabs[0].blocs[0].lines[0].inputFields.length > 0) {
      console.log('Fetching input value...');
      var inputFieldId = this.form.tabs[0].blocs[0].lines[0].inputFields[0].id;
      var userId = this.token.getUser().id;

      this.userService.getInputValueById(inputFieldId, userId).subscribe(
          (response) => {
              console.log('Input value fetched successfully:', response);
              this.inputValue = response;
              this.updateFormInputValues();
          },
          (error) => {
              console.error('Error fetching input value:', error);
          }
      );
  } else {
      console.error('Form data is invalid or empty. Cannot fetch input value.');
  }
}

updateFormInputValues() {
  console.log('Updating form input values with fetched input value...');
  this.form.tabs[0].blocs[0].lines[0].inputFields.forEach((field: any) => {
      field.inputValues[0].inputValue = this.inputValue.inputValue;
  });
}



  handleChange(event: any, fieldName: string) {
    this.form[fieldName] = event.target.value;
    console.log(this.form);
    console.log(this.form[fieldName]);
    console.log(event.target.value);
  }

  handleSubmit() {
    var inputFields = this.forms[0].tabs[0].blocs[0].lines[0].inputFields;

    for (let i = 0; i < inputFields.length; i++) {
      var inputField = inputFields[i];
      var inputValue = inputField.inputValues[0].inputValue;
      var idInputValue = inputField.id;
      var idUser = this.token.getUser().id;
      var inputValueId = { idInputValue, idUser };
      var updatedInputValue = { inputValueId, inputValue };
      inputField.inputValues[0] = updatedInputValue;
      this.createInputValue(inputField.inputValues[0]).subscribe({
        next: (data: any) => {
          console.log(data);
        },
        error: (e: any) => console.error(e)
      });
    }

  }
  generateFlux(form: any): any {
    return this.userService.generateFlux(this.form).subscribe({
      next: (data) => {
        console.log('Flux generated successfully:', data);
      },
      error: (e) => {
        console.error('Error generating flux:', e);
      }
    });
  }
  
}
