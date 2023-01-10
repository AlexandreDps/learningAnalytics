package component;

import java.util.ArrayList;

import user.Student;

public class Note {
	private double valeur;
	private double coeff;
	private Student eleve;
	
	public Note(double valeur, double coeff, Student eleve) {
		this.setValeur(valeur);
		this.setCoeff(coeff);
		this.setEleve(eleve);
	}
	
	
	
	
	//Getters et setters ..
	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public Student getEleve() {
		return eleve;
	}

	public void setEleve(Student eleve) {
		this.eleve = eleve;
	}

	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}
}