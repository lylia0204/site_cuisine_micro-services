package fr.isika.ms_user.repository;

import org.springframework.data.repository.CrudRepository;

import fr.isika.ms_user.model.FavoriteRecipes;
import fr.isika.ms_user.model.ProfilUserRecipes;

public interface ProfilUserRecipesRepository extends CrudRepository<ProfilUserRecipes, Long> {
	

}
