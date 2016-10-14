package restjpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by SRIN on 10/12/2016.
 */
@Entity
public class Recipe implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    private Category category;

    @JoinColumn(name = "chef_id", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Chef.class)
    @ManyToOne
    private Chef chef;

    @ManyToMany(mappedBy = "recipes")
    private Set<Ingredient> ingredients;

    public Recipe(){}

    public Recipe(String name,
                  String description,
                  Category category,
                  Chef chef,
                  Set<Ingredient> ingredients){
        this.name = name;
        this.description = description;
        this.category = category;
        this.chef = chef;
        this.ingredients = ingredients;
    }

    public Recipe(String name, String description, Category category, Chef chef) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.chef = chef;
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

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public Chef getChef(){
        return chef;
    }

    public void setChef(Chef chef){
        this.chef = chef;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
