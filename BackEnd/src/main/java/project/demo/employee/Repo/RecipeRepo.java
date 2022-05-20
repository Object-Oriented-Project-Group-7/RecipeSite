package project.demo.employee.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.demo.employee.Model.recipe;
//import project.demo.employee.Model.ingredient;

public interface RecipeRepo extends JpaRepository<recipe, String> 
{

    recipe findHeadById(Long recid);

    @Query(value = "SELECT * FROM recipe rec WHERE rec.author = :author", nativeQuery = true)
    List<recipe> findByAuthor(@Param("author") String author);

    @Query(value = "UPDATE recipe rec SET rec.description = :desc and rec.title = :title  where rec.id = :id", nativeQuery = true)
    recipe UpdateRecipe(@Param("id") Long id,@Param("title") String title,@Param("desc") String desc);

    void deleteRecipeById(Long recid);


    @Query(value = "SELECT * FROM recipe rec ORDER BY rec.viewed DESC LIMIT 3", nativeQuery = true)
    List<recipe> findTopView();


    @Query(value = "SELECT * FROM recipe rec WHERE INSTR(rec.title , :value ) > 0", nativeQuery = true)
    List<recipe> findTitle(@Param("value") String value);


    @Query(value = "SELECT * FROM recipe rec WHERE rec.category LIKE :category", nativeQuery = true)
    List<recipe> findCateg(@Param("category") String category);


    @Query(value = "SELECT * FROM recipe rec WHERE rec.author LIKE :author", nativeQuery = true)
    List<recipe> findAuthor(@Param("author") String author);
    
}



