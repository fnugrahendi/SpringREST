package restjpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by SRIN on 10/12/2016.
 */
@Entity
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JoinTable(name = "ingredient_recipe",
                joinColumns = {@JoinColumn(name = "ingredient_id", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Recipe> recipes;

    public Ingredient(){
    }

    public Ingredient(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<Recipe> getRecipes(){
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
