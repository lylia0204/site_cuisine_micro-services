package fr.isika.microservices_recipe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.isika.microservices_recipe.modele.Recipe;

public interface RecipeRepository  extends CrudRepository<Recipe, Integer> {
	
	
	List<Recipe> findByNomLike(String chaine);

	List<Recipe> findBynomRecette(String nom); 

}
