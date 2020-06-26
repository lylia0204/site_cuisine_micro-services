package fr.isika.microservices_recipe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecipeIntrouvableException extends RuntimeException {

	public RecipeIntrouvableException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public RecipeIntrouvableException() {
		// TODO Auto-generated constructor stub
	}
}
