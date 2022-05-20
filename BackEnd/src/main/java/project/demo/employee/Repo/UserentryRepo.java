package project.demo.employee.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.demo.employee.Model.userentry;

public interface UserentryRepo extends JpaRepository<userentry, String>{


    @Query(value = "SELECT * FROM userentry user where user.recipeid = :recid", nativeQuery = true)
    List<userentry> findUserentryById(@Param("recid")Long recid);
    
}
