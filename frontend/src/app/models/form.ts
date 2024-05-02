export interface Form {
    name: string;
    tabs: Tab[];
}

export interface Tab {
    name: string;
    blocs: Bloc[];
}
export interface Bloc {
    name: string;
    lines: Line[];
}
export interface Line {
    name: string;
    inputFields: InputField[];
}
export interface InputField {
    name: string;
    label: string;
    placeholder: string;
    type: string;
    inputValues: InputValue[];
}
export class InputValue {
   public inputValueId: InputValueId;
   public inputValue: String;
    constructor(inputValueId: InputValueId, inputValue: String) {
         this.inputValueId = inputValueId;
         this.inputValue = inputValue;
    }
}
export class InputValueId {
    public idInputValue: String;
    public idUser: String;
    constructor(idInputValue: String, idUser: String) {
        this.idInputValue = idInputValue;
        this.idUser = idUser;
    }
}