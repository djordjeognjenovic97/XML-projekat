export class Resenje{
  brP:string;
  id:string;
  datum:string;
  email:string;
  constructor(id:string,datum:string,email:string, brP:string){
      this.id=id;
      this.datum=datum;
      this.email=email;
      this.brP=brP;
  }
}
