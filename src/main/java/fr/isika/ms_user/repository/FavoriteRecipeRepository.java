package fr.isika.ms_user.repository;

import org.springframework.data.repository.CrudRepository;

import fr.isika.ms_user.model.FavoriteRecipes;

public interface FavoriteRecipeRepository extends CrudRepository<FavoriteRecipes, Long> {

	
	FavoriteRecipes findByrecipeId(String recipeId);

	boolean existsByrecipeId(String recipeId);




	

	

}
