import { Component } from '@angular/core';

@Component(
           { 
               selector: 'employeemanager',
               templateUrl: 'register.component.html' ,
                styleUrls: ['./register.component.css']
           }
)
export class RegisterComponent {

    ngonInit()   {}


    public onMessage()
    {
        alert("hi");
    }
}



