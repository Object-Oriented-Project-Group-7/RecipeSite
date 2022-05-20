import {Component} from '@angular/core';
import { RecipeComponent } from '../recipe.component'


@Component({
  selector: 'ngbd-recipe-rating-decimal',
  templateUrl: './reciperating-decimal.html',
  styles: [`
    .star {
      position: relative;
      display: inline-block;
      font-size: 3rem;
      color: #d3d3d3;
    }
    .full {
      color: red;
    }
    .half {
      position: absolute;
      display: inline-block;
      overflow: hidden;
      color: red;
    }
  `]
})
export class NgbdRecipeRatingDecimal  {
  constructor(private recipe: RecipeComponent){}
  
 currentRate = this.recipe.getRating();
 currentViews = this.recipe.getView();

}
