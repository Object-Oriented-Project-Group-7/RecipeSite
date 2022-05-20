package project.demo.employee.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class recipe implements Serializable
{
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String author;
    private String description;
    private String category;
    private long rating;
    private long viewed;

    public recipe(){}

    public recipe(String title, String author, String description,String category,long rating,long viewed)
    {
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.rating = rating;
        this.viewed = viewed;
    }

   public long getId()
   {
       return id;
   }

   public void setId(long id)
   {
       this.id = id;
   }
   

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
    public String getDesc()
    {
        return description;
    }

    public void setDesc(String description)
    {
        this.description = description;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public long getRating()
    {
        return rating;
    }

    public void setRating(long rating)
    {
        this.rating = rating;
    }

    public long getView()
    {
        return viewed;
    }

    public void setView(long view)
    {
        this.viewed = view;
    }


}
