package restjpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restjpa.model.Category;
import restjpa.model.Recipe;

import java.util.List;

/**
 * Created by SRIN on 10/12/2016.
 */
@RepositoryRestResource(collectionResourceRel = "category", path = "categories")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    /*
    * Method return lists of categories by passed name parameter
    *
    * @param name
    * @return list of recipes
    */
    List<Recipe> findByName(@Param("name") String name);

    // Return lists of category's name by passed id parameter
    @Query("SELECT c.name FROM Category c WHERE c.id = :id")
    Recipe findNameById(@Param("id") Long id);

    // Return lists of recipes by its name sort ascending
    List<Recipe> findByNameOrderByNameAsc(@Param("name") String name);
}
