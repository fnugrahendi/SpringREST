package restjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import restjpa.model.Category;
import restjpa.model.Chef;
import restjpa.model.Ingredient;
import restjpa.model.Recipe;
import restjpa.repo.CategoryRepository;
import restjpa.repo.ChefRepository;
import restjpa.repo.IngredientRepository;
import restjpa.repo.RecipeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SRIN on 10/12/2016.
 */

@SpringBootApplication
@EntityScan(basePackages = {"restjpa/model"})
@EnableJpaRepositories(basePackages = {
        "restjpa.repo"
})
public class Application implements CommandLineRunner{
    private final static Logger LOG = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private ChefRepository chefRepo;

    @Autowired
    private IngredientRepository ingredientRepo;

    @Autowired
    private RecipeRepository recipeRepo;

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
        LOG.info(" == APPLICATION RUNNING == ");
    }

    @Override
    public void run(String... args){
        LOG.info("-- running commandline runner --");

        Category beverages = new Category("Beverages");
        Category food = new Category("Food");
        catRepo.save(beverages);
        catRepo.save(food);

        Ingredient guava = new Ingredient("Guava");
        Ingredient oil = new Ingredient("Oil");
        Ingredient water = new Ingredient("Ice Cubes");
        Ingredient sugar = new Ingredient("Sugar");
//        ingredientRepo.save(guava);
//        ingredientRepo.save(oil);
//        ingredientRepo.save(water);
//        ingredientRepo.save(sugar);

        Chef chefJuno = new Chef("Juno");
        Chef chefJoko = new Chef("Pak Joko");
        chefRepo.save(chefJuno);
        chefRepo.save(chefJoko);

        Set<Ingredient> gjIngredient = new HashSet<Ingredient>();
        gjIngredient.add(water);
        gjIngredient.add(sugar);
        gjIngredient.add(guava);
//        LOG.info(gjIngredient.toString());
        Recipe guavaJuice = new Recipe("Guava Juice",
                                "Slice of guava mixed with sugar and blended with ice cubes",
                                beverages,
                                chefJuno,
                                gjIngredient);
        recipeRepo.save(guavaJuice);

        gjIngredient.clear();
        gjIngredient.add(guava);
        gjIngredient.add(oil);
        gjIngredient.add(sugar);
//        LOG.info(gjIngredient.toString());
        Recipe crispyGuava = new Recipe("Crispy Guava",
                "Slices of guava mixed with secret ingredients and fried using VCO",
                food,
                chefJoko,
                gjIngredient);
        recipeRepo.save(crispyGuava);
    }
}
