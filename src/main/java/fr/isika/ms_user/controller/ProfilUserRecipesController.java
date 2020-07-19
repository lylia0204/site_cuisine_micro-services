package fr.isika.ms_user.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.ms_user.model.FavoriteRecipes;
import fr.isika.ms_user.model.ProfilUserRecipes;
import fr.isika.ms_user.model.User;
import fr.isika.ms_user.repository.FavoriteRecipeRepository;
import fr.isika.ms_user.repository.ProfilUserRecipesRepository;
import fr.isika.ms_user.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user/favoriterecipe")
public class ProfilUserRecipesController {
	
	@Autowired
	private ProfilUserRecipesRepository PurRepo;
	
	@Autowired
	private UserRepository userRepos;
	
	@Autowired
	private FavoriteRecipeRepository favRepo;
	
	
	
	@PostMapping("/ajouter")
    void addFavoriteRecipe(@RequestBody FavoriteRecipes favRec) {
		favRepo.save(favRec);
    }
	
	@GetMapping(value = "/{Recipeid}")
	public FavoriteRecipes getByidRecipe(@PathVariable("Recipeid") String recipeId) {
	  return favRepo.findByrecipeId(recipeId);
	}
	
	@GetMapping(value = "/exists/{Recipeid}")
	public boolean isRecipeIdAlreadyHere(@PathVariable("Recipeid") String recipeId) {
	  return favRepo.existsByrecipeId(recipeId);
	}
	
	 @GetMapping("/{id}")
	 public ProfilUserRecipes getProfilById(@PathVariable("id") Long id) {
		 return null;
		  		}
	
	 @PostMapping("/add/{username}/{recipeId}")
    void addRecipe(@PathVariable("username") String username, @PathVariable("recipeId") String recipeId ) {
	
		
	User user = userRepos.findByUsername(username);
	boolean recipeExistsOrNot = favRepo.existsByrecipeId(recipeId);
	FavoriteRecipes favrec = new FavoriteRecipes();
	if(recipeExistsOrNot) {
		favrec = favRepo.findByrecipeId(recipeId);	
	} else {
		favrec = new FavoriteRecipes(recipeId);
		favRepo.save(favrec);
	}
	
	user.getProfilUserRecipes().getFavoriteRecipes().add(favrec);
	PurRepo.save(user.getProfilUserRecipes());
		
    }
	
	@GetMapping(value = "/findall/{username}")
	public Set<FavoriteRecipes> getAllFavoriteRecipes(@PathVariable("username") String username) {
		User user = userRepos.findByUsername(username);
		
		Set<FavoriteRecipes> recipes = user.getProfilUserRecipes().getFavoriteRecipes();
		
		
		return recipes;
	}
	
	@DeleteMapping("/delete/{username}/{recipeId}")
    void deleterecipe(@PathVariable("username") String username, @PathVariable("recipeId") String recipeId) {
	User user = userRepos.findByUsername(username);
	FavoriteRecipes favrec = favRepo.findByrecipeId(recipeId);	
	user.getProfilUserRecipes().getFavoriteRecipes().remove(favrec);
	PurRepo.save(user.getProfilUserRecipes());
		
    }


}
