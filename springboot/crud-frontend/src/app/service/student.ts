import {StudentService} from "./student-service.service";

export class Student {

  constructor(public id:number | null,
              public name:string,
              public age:number
               ) {
  }
}
