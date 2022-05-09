import {Role} from "./role";
import {Etat} from "./enums/etat";
//import {Publication} from "./publication.model";

export class User {
    id: any;
    firstName: any;
   lastName : any;
   username: any;
   password : any;
   birthdate: any;
   address: any;
   email: any;
   // notifications: Notification[];
   //  subscriptions: Subscription;

     // @ts-ignore
  etat : Etat = new Etat();
roles : Role[]=[];
   phone: any ;

 //publications : Publication[] = [];
// certificats: Certificat[]=[];
//  formations;
//
// private List<Appointment> appointments ;
//
//  List<Reclamation> reclamations ;
//
// List<Events> events ;

  constructor() {
  }
}
