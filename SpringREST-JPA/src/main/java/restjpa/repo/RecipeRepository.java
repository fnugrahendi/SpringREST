package restjpa.repo;

import restjpa.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by SRIN on 10/12/2016.
 */
@RepositoryRestResource(collectionResourceRel = "recipe", path = "recipes")
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {
    /*
    * Method return lists of recipes by passed name parameter
    *
    * @param name
    * @return list of recipes
    */
    List<Recipe> findByName(@Param("name") String name);

    // Return lists of recipe's name by passed id parameter
    @Query("SELECT r.name FROM Recipe r WHERE r.id = :id")
    Recipe findNameById(@Param("id") Long id);

    // Return lists of recipes by its name sort ascending
    List<Recipe> findByNameOrderByNameAsc(@Param("name") String name);
}
