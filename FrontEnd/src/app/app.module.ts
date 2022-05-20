import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeService } from './employee.service';
import { loginservice } from './Login/login.service';
import { NgModule } from '@angular/core';
import {NgbdRatingDecimalModule} from './rating-module'
import {NgbdRecipeRatingDecimalModule} from './Recipe/Reciperating/reciperating-module'



@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbdRatingDecimalModule,
    NgbdRecipeRatingDecimalModule
  ], 
  declarations: [
    AppComponent,
    routingComponents
  ],
  providers: [EmployeeService,loginservice,],
  bootstrap: [AppComponent,NgbdRatingDecimalModule,NgbdRecipeRatingDecimalModule]
})
export class AppModule { }
