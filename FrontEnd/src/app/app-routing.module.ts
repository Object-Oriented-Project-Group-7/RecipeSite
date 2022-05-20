import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home';
import { LoginComponent } from './Login';
import { RegisterComponent } from './Register';
import { EmployeeManagerComponent } from './employeemanager';
import { RecipeComponent } from './Recipe/recipe.component';
import { RecipeSearchComponent } from './recipesearch/recipesearch.component';
import { AddRecipeComponent } from './addrecipe/addrecipe.component';

const routes: Routes = [
    { path: 'home', component: HomeComponent},
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'employeemanager', component: EmployeeManagerComponent },
    { path: 'recipesearch/:p1/:p2', component: RecipeSearchComponent },
    { path: 'recipe/:p1', component: RecipeComponent },
    { path: 'addrecipe', component: AddRecipeComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomeComponent, LoginComponent, RegisterComponent,EmployeeManagerComponent,RecipeComponent,RecipeSearchComponent,AddRecipeComponent]
