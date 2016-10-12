package restjpa.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by SRIN on 10/12/2016.
 */
@Entity
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "chefId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Recipe> recipes;

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

    public List<Recipe> getRecipes(){
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes){
        this.recipes = recipes;
    }
}
