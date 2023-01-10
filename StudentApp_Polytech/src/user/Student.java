package user;

import java.util.ArrayList;

import component.Note;
import component.NoteListener;

public class Student extends Utilisateur implements NoteListener{
	private String statut;
	
	
	public Student(String nom,String prenom, String email) {
		super(nom,prenom,email);
		//Par défaut, les eleves sont listener des new notes pour recevoir des notifs
		listenersNotes.add(this); 
		this.statut = "Eleve";
	}

	@Override
	public void get_notes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get_travaux() {
		// TODO Auto-generated method stub
		
	}
	public void notif_note(Note note) {
		
	}

	@Override
	public void notifNote(Note note) {
		System.out.println("un email à été envoyé à " + super.getNom());
	}
	
}