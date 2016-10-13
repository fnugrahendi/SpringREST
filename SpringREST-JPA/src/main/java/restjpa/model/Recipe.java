package restjpa.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by SRIN on 10/12/2016.
 */
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    private Category categoryId;

    @JoinColumn(name = "chef_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Chef.class)
    private Chef chefId;

    @ManyToMany(mappedBy = "recipes", fetch = FetchType.LAZY)
    private Set<Ingredient> ingredients;

    public Recipe(){}

    public Recipe(String name,
                  String description,
                  Category categoryId,
                  Chef chefId,
                  Set<Ingredient> ingredients){
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.chefId = chefId;
        this.ingredients = ingredients;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Category getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(Category categoryId){
        this.categoryId = categoryId;
    }

    public Chef getChefId(){
        return chefId;
    }

    public void setChefId(Chef chefId){
        this.chefId = chefId;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
