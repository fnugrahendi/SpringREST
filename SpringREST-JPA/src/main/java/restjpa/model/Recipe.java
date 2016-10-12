package restjpa.model;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "recipeId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Ingredient> ingredients;

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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
