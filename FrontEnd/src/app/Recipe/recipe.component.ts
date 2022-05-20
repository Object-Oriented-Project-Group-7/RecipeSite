import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {ActivatedRoute} from '@angular/router';
import { RecipeService } from '../home/recipeservice';
import { Ingredient } from './ingredient';
import { Recipe} from '../home/recipe';

@Component(
           { selector: 'app-root',
             templateUrl: 'recipe.component.html',
             styleUrls: ['./recipe.component.css'] 
           }
          )
          
export class RecipeComponent implements OnInit {
    recipeid : any;
    contents : any[];
    rating : number;
    view : number;
    ingredient: Ingredient[]
    userentry : any[]
    ratingflag : number = 0;
    viewflag   : number = 0;
    commentcounter : number = -1; 
    userentrysize : number;  
    
    public recipe  : Recipe;
    constructor( private router: ActivatedRoute,
                 private recipeservice: RecipeService) {}
        
    ngOnInit() : void 
    {
        this.recipeid = this.router.snapshot.paramMap.get('p1');
        this.getRecipeid(this.recipeid);
    }  

    public getRecipeid(id: number,): void
    {
      this.recipeservice.GetRecipeid(id).subscribe(
      (response: any) =>{ console.log(response);
        this.setvalue(response); 
    },(error: HttpErrorResponse) =>{alert(error.message)});
    }

    //Dynamic valus from each form fetched and updated here
    public setvalue(value: any): void
    {
       this.recipe = value.recipe;

       this.rating = value.recipe.rating/value.recipe.view;
       this.view = value.recipe.view;
       this.ingredient = value.ingredient 
       this.contents = value.content;
       this.userentry = value.userentry;
       this.userentrysize = this.userentry.length;
    }

    public getRating(): any
    {
        if (this.ratingflag == 0){
          this.ratingflag = 1;
          return this.recipe.rating/this.recipe.view
        }
        else
        {
           this.commentcounter = this.commentcounter + 1;
           return this.userentry[this.commentcounter].rating;
        }
    }
    public getView() : any
    {
        if (this.viewflag == 0){
          this.viewflag = 1;
          return this.recipe.view
        }
        else
        {
           return null;
        }
    }
   
}





