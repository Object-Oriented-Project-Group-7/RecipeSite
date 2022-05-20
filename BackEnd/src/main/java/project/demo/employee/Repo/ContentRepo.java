package project.demo.employee.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.demo.employee.Model.content;

public interface ContentRepo extends JpaRepository<content, String>
{

    @Query(value = "SELECT * FROM content ing where ing.recipeid = :recid", nativeQuery = true)
    List<content> findConById(@Param("recid")Long recid);
    
}


