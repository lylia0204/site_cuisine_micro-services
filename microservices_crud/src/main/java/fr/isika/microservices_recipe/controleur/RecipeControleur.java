package fr.isika.microservices_recipe.controleur;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import fr.isika.microservices_recipe.dao.RecipeRepository;
import fr.isika.microservices_recipe.modele.Recipe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;

@Api(description = "API pour les opérations CRUD des recettes") 
@RestController
@RequestMapping(path="/ ")
public class RecipeControleur {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired  
	private RecipeRepository recipeRepository;
	
	private WebClient client = WebClient.create("http://localhost:9999");

	@GetMapping(path = "/articles")
	private Flux<Recipe> getAllRecipes() {
	 
	 return client.get()
				.uri("/recipe-api/public/recipes")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Recipe.class)
				.log();
	}
	

	@ApiOperation(value = "find recipe by name ")
	public @ResponseBody List<Recipe> findArticleTitleLike(@PathVariable String nomRecette) {
		return recipeRepository.findByNomLike("%" + nomRecette + "%");
	}


	
//	@Autowired
//	ApplicationPropertiesConfiguration appProperties;
//	
//	
//	@GetMapping(path="/listerLesRecettes")  
//	public @ResponseBody Iterable<Recipe> getAllRecipes() {
//		//return assureRepository.findAll();
//		
//		Iterable<Recipe> recipesIterable = recipeRepository.findAll();
//        List<Recipe> recipesList = StreamSupport 
//                .stream(recipesIterable.spliterator(), false) 
//                .collect(Collectors.toList()); 
//        List<Recipe> listeLimitee = recipesList.subList(0, appProperties.getLimiteNombreAssure());
//        return listeLimitee;
//	}
//	
//	@ApiOperation(value = "Recherche une recette grâce à son ID à condition que celui-ci existe.")
//	@GetMapping(path="/Recipe/{id}")  
//	public @ResponseBody Optional<Recipe> rechercherAssureId(@PathVariable Integer id) {
//		
//		Optional<Recipe> oa = recipeRepository.findById(id);
//		if (!oa.isPresent()) throw new RecipeIntrouvableException("La recette id = "+ id +" n'existe pas !");
//		
//		return oa;
//	}
//	
//	
//	@GetMapping(path="/rechercherRecetteNom/{nom}")  
//	public List<Recipe> recherchernomRecette(@PathVariable String nom) {
//		
//		return recipeRepository.findBynomRecette(nom);
//
//	}
//	
//	@GetMapping(path="/rechercherAssureContientChaine/{chaine}")  
//	public List<Recipe> rechercherAssureContientChaine(@PathVariable String chaine) {
//		
//		return recipeRepository.findByNomLike("%"+chaine+"%");
//
//	}


	

}
