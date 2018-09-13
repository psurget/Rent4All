package ca.qc.cgodin.model;

import java.sql.Timestamp;
import java.util.Calendar;


public class Annonce {
	private int AnnonceID;
	private int UserID;
	private String Titre;
	private String Description;
	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}

	private String Statut;
	private double Amount;
	private String Category;
	private Timestamp CreationTS;
	private Timestamp ModifTS;


	public Annonce(int userID, String titre, String descr, Double amount, String category) {
		UserID = userID;
		Titre = titre;
		Description = descr;
		Amount = amount;
		Category = category; 
		Statut = "actif";
	}
	

	public Annonce(int userID, String titre, String descr, Double amount) {
		UserID = userID;
		Titre = titre;
		Description = descr;
		Amount = amount;
		Statut = "actif";
	}
	
	public Annonce(){
		Statut = "actif";
	}
	
	
//==== GETTERS & SETTERS ================	
	public int getAnnonceID() {
		return AnnonceID;
	}
	public void setAnnonceID(int annonceID) {
		AnnonceID = annonceID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
	public Timestamp getCreationTS() {
		return CreationTS;
	}
	public void setCreationTS(Timestamp creationTS) {
		CreationTS = creationTS;
	}
	public Timestamp getModifTS() {
		return ModifTS;
	}
	public void setModifTS(Timestamp modifTS) {
		ModifTS = modifTS;
	}
	
	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		this.Amount = amount;
	}
	
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}
	
}
