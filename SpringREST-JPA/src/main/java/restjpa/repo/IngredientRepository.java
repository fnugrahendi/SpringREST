package restjpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restjpa.model.Ingredient;
import restjpa.model.Recipe;

import java.util.List;

/**
 * Created by SRIN on 10/12/2016.
 */
@RepositoryRestResource(collectionResourceRel = "ingredient", path = "ingredients")
public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long> {
    /*
    * Method return lists of chef by passed name parameter
    *
    * @param name
    * @return list of recipes
    */
    List<Recipe> findByName(@Param("name") String name);

    // Return lists of chef's name by passed id parameter
    @Query("SELECT f.name FROM Chef f WHERE f.id = :id")
    Recipe findNameById(@Param("id") Long id);

    // Return lists of recipes by its name sort ascending
    List<Recipe> findByNameOrderByNameAsc(@Param("name") String name);
}
