package fr.isika.jwtauthentication.repository;

import org.springframework.data.repository.CrudRepository;

import fr.isika.jwtauthentication.model.FavoriteRecipes;

public interface FavoriteRecipeRepository extends CrudRepository<FavoriteRecipes, Long> {

	
	FavoriteRecipes findByrecipeId(String recipeId);

	boolean existsByrecipeId(String recipeId);




	

	

}
