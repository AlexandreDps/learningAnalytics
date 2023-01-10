package user;
import java.util.ArrayList;

import component.NoteListener;

public abstract class Utilisateur {
	private String nom;
	private String prenom;
	private String email;
	static ArrayList<Utilisateur> instances = new ArrayList<>();
	static ArrayList<NoteListener> listenersNotes = new ArrayList<NoteListener>();
	
	public Utilisateur(String nom,String prenom, String email) {
		instances.add(this);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
	}
	public abstract void get_notes(); //car cela affiche les notes recues pour un eleve et note données pour un prof
	public abstract void get_travaux();//car cela affiche les travaux recus pour un eleve et travaux donnés pour un prof
	public void get_edt() {
		
	}
	protected ArrayList<NoteListener> getListenersNotes() {
		return listenersNotes;
	}
	
	protected String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
