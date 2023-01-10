package user;
import component.*;

public class Teacher extends Utilisateur {
	
	private String statut;

	public Teacher(String nom,String prenom, String email) {
		super(nom,prenom,email);
		this.statut = "Professeur";
	}

	@Override
	public void get_notes() {
		// TODO Auto-generated method stub
		
	}
	
	public void give_note(double valeur, double coeff, Student eleve) {
		Note note = new Note(valeur,coeff,eleve);
		for (NoteListener St : super.getListenersNotes()) {
			if (note.getEleve() == St) {
				St.notifNote(note);
			}
		}
	}

	@Override
	public void get_travaux() {
		// TODO Auto-generated method stub
		
	}
}

