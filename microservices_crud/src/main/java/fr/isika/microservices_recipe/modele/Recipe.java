package fr.isika.microservices_recipe.modele;

import java.awt.Image;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {
	
	private Long Id;
	

	private List<String> ingredients;
	private List<String>  materiels;
	private List<String>  etapesPreparation;
	private String nomRecette;
	private String difficulte;
	private String budget;
	private Integer tempsTotal;
	private Integer tpsPreparation;
	private Integer tpsCuisson;
	private String portion;
	private Image imageRecette;
	private String conseil;
	private String typeRecette;
	private String site;
	private boolean vegieOUpa;
	
	
	////////////////////////Getters Setters//////////////////////////////////////
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public List<String> getMateriels() {
		return materiels;
	}
	public void setMateriels(List<String> materiels) {
		this.materiels = materiels;
	}
	public List<String> getEtapesPreparation() {
		return etapesPreparation;
	}
	public void setEtapesPreparation(List<String> etapesPreparation) {
		this.etapesPreparation = etapesPreparation;
	}
	public String getNomRecette() {
		return nomRecette;
	}
	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}
	public String getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public Integer getTempsTotal() {
		return tempsTotal;
	}
	public void setTempsTotal(Integer tempsTotal) {
		this.tempsTotal = tempsTotal;
	}
	public Integer getTpsPreparation() {
		return tpsPreparation;
	}
	public void setTpsPreparation(Integer tpsPreparation) {
		this.tpsPreparation = tpsPreparation;
	}
	public Integer getTpsCuisson() {
		return tpsCuisson;
	}
	public void setTpsCuisson(Integer tpsCuisson) {
		this.tpsCuisson = tpsCuisson;
	}
	public String getPortion() {
		return portion;
	}
	public void setPortion(String portion) {
		this.portion = portion;
	}
	public Image getImageRecette() {
		return imageRecette;
	}
	public void setImageRecette(Image imageRecette) {
		this.imageRecette = imageRecette;
	}
	public String getConseil() {
		return conseil;
	}
	public void setConseil(String conseil) {
		this.conseil = conseil;
	}
	public String getTypeRecette() {
		return typeRecette;
	}
	public void setTypeRecette(String typeRecette) {
		this.typeRecette = typeRecette;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public boolean isVegieOUpa() {
		return vegieOUpa;
	}
	public void setVegieOUpa(boolean vegieOUpa) {
		this.vegieOUpa = vegieOUpa;
	}
	
	
	@Override
	public String toString() {
		return "Recipe [Id=" + Id + ", ingredients=" + ingredients + ", materiels=" + materiels + ", etapesPreparation="
				+ etapesPreparation + ", nomRecette=" + nomRecette + ", difficulte=" + difficulte + ", budget=" + budget
				+ ", tempsTotal=" + tempsTotal + ", tpsPreparation=" + tpsPreparation + ", tpsCuisson=" + tpsCuisson
				+ ", portion=" + portion + ", imageRecette=" + imageRecette + ", conseil=" + conseil + ", typeRecette="
				+ typeRecette + ", site=" + site + ", vegieOUpa=" + vegieOUpa + "]";
	}
	
	
	
	
	

}
