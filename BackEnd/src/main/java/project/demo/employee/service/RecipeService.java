package project.demo.employee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import project.demo.employee.Repo.ContentRepo;
import project.demo.employee.Repo.IngredientRepo;
import project.demo.employee.Repo.RecipeRepo;
import project.demo.employee.Repo.UserentryRepo;
import project.demo.employee.Model.recipe;
import project.demo.employee.Model.userentry;
import project.demo.employee.Model.ingredient;
import project.demo.employee.Model.content;

@Service
public class RecipeService 
{
    private  RecipeRepo reciperepo;
    private  IngredientRepo ingredientrepo;
    private  ContentRepo contentrepo;
    private  UserentryRepo userentryrepo;
    public   recipe recipe;
    public   ingredient ingredient;
    public   content content;

    @Autowired
    public RecipeService(ContentRepo contentrepo,IngredientRepo ingredientrepo,RecipeRepo reciperepo,UserentryRepo userentryrepo)
    {
        this.contentrepo = contentrepo;
        this.ingredientrepo = ingredientrepo;
        this.reciperepo = reciperepo;
        this.userentryrepo = userentryrepo;
    }

//Get All Recipe Details
public List<recipe> getAllRecipe(Long filter,String value)
{
// Filter value -> 1(top6 viewed),2(by title),3(by author),4(category)
if      (filter == 1) { return reciperepo.findTopView();      }
else if (filter == 2) { return reciperepo.findTitle(value);   }
else if (filter == 3) { return reciperepo.findAuthor(value);  }
else if (filter == 4) { return reciperepo.findCateg(value);   }
else if (filter == 5) { return reciperepo.findAll();          }
else                  { return null;                          }
}

//Get For Individial 
public recipe getRecipeHead(Long recid)
{
     return reciperepo.findHeadById(recid);
}


public List<ingredient> getRecipeIng(Long recid)
{
     return ingredientrepo.findIngById(recid);
}
public List<content> getRecipeCon(Long recid)
{
     return contentrepo.findConById(recid);
}
public List<userentry> getRecipeUserEntry(Long recid) {
    return userentryrepo.findUserentryById(recid);
}
//Get by Author Name
public List<recipe> getRecipeByAuthor(String author)
{
    return reciperepo.findByAuthor(author);
}


//======Post Recipe Details=======////
//RecipeHeader
public recipe addRecipe(recipe recipe)
//public recipe addRecipe(recipe recipe)
{
   return reciperepo.save(recipe);
}


//RecipeIngredient
public List<ingredient> addIng(List<ingredient> ingredients)
{
    List<ingredient> ingreds = new ArrayList<ingredient>();
    for( int i = 0; i < ingredients.size(); i++ )
    {
        ingreds.add(ingredientrepo.save(ingredients.get(i)));
    }
    return ingreds;
}

//RecipeContention
public List<content> addContent(List<content> contents)
{
    List<content> content = new ArrayList<content>();
    for( int i = 0; i < contents.size(); i++ )
    {
       
        content.add(contentrepo.save(contents.get(i)));
    }
    return content;
}

public userentry addUserEntry(userentry userentry)
{
    return userentryrepo.save(userentry);
}

public recipe UpdateRecipe(recipe newRecipe)
{
    recipe curRecipe =  new recipe(); //Existing Recipe in System
    recipe updRecipe =  new recipe();
    boolean updFlag = false;
    //if(recipe.getTitle() != null){Newrecipe.setTitle(recipe.getTitle()); updflag = true;}
    curRecipe = reciperepo.findHeadById(newRecipe.getId());
    if(!curRecipe.getTitle().equals(newRecipe.getTitle())){
          updRecipe.setTitle(newRecipe.getTitle()); //Update the Title
          updFlag = true;                          //Flag to Indicate update
    }
    if(!curRecipe.getDesc().equals(newRecipe.getDesc())){
        updRecipe.setDesc(newRecipe.getDesc());     //Update the Description
         updFlag = true;                            //Flag to indicate update
    }
//Check if Update Taken Place
   if( updFlag == true ){ 
       updRecipe.setId(newRecipe.getId());
       updRecipe.setAuthor(newRecipe.getAuthor());
       return reciperepo.save(updRecipe);
       //return reciperepo.UpdateRecipe(updRecipe.getId(),updRecipe.getDesc(),updRecipe.getTitle());
    }
    else{
        return null;
    }
    
}

//RecipeIngredient
public List<ingredient> updateIng(List<ingredient> ingredients)
{
    List<ingredient> ingreds = new ArrayList<ingredient>();
    for( int i = 0; i < ingredients.size(); i++ )
    {
        ingreds.add(ingredientrepo.save(ingredients.get(i)));
    }
    return ingreds;
}

//RecipeContent
public List<content> updateContent(List<content> contents)
{
    List<content> content = new ArrayList<content>();
    for( int i = 0; i < contents.size(); i++ )
    {
        content.add(contentrepo.save(contents.get(i)));
    }
    return content;
}


//Delete Recipe Details
public void deleteRecipeDetails(Long id)
{
    reciperepo.deleteRecipeById(id);
}



}