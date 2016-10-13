package restjpa.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by SRIN on 10/12/2016.
 */
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JoinTable(name = "recipe_ingredients",
                joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"))
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Recipe.class)
    private Set<Recipe> recipeId;

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

    public Set<Recipe> getRecipeId(){
        return recipeId;
    }

    public void setRecipeId(Set<Recipe> recipeId) {
        this.recipeId = recipeId;
    }
}
