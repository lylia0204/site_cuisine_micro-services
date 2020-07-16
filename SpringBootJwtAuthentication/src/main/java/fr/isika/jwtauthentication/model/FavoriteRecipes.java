package fr.isika.jwtauthentication.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FavoriteRecipes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String recipeId;
	
//	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//    @JoinColumn(name = "ProfilUserRecipeId")
//	ProfilUserRecipes profilUserRecipes = new ProfilUserRecipes();
	@ManyToMany(mappedBy = "favoriteRecipes",fetch = FetchType.EAGER)
	@JsonIgnore
    Set<ProfilUserRecipes> profilUserRecipes;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Set<ProfilUserRecipes> getProfilUserRecipes() {
		return profilUserRecipes;
	}

	public void setProfilUserRecipes(Set<ProfilUserRecipes> profilUserRecipes) {
		this.profilUserRecipes = profilUserRecipes;
	}

	public FavoriteRecipes() {
		
		// TODO Auto-generated constructor stub
	}

	public FavoriteRecipes( String recipeId) {
		
		this.recipeId = recipeId;
	
	}

	public String getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

	
	
	
	
	
	

		
		
		


}
