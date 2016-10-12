package restjpa.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by SRIN on 10/12/2016.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "categoryId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Recipe> recipes;

    public Long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public List<Recipe> getRecipes(){
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes){
        this.recipes = recipes;
    }
}
