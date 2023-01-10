package app;

import java.sql.SQLException;

import bdd.*;
import user.Student;
import user.Teacher;
import user.Utilisateur;
import user.UtilisateurFactory;

public class Main {

	public static void main(String[] args) {
		
		//On instancie le singleton
		//ConnectMySql myBdd = bdd.ConnectMySql.getInstance();
		//myBdd.inscription("testtsss", "FASKA", "Rachid", "bgdu74", "1234");
		//myBdd.connexion("testtss", "bgdu74");
		Student e1 = new Student("faska", "rachid", "email@mail.fr");
		Teacher t1 = new Teacher("nomP", "prenomP", "emailP@mail.fr");
		t1.give_note(14.00,3.50,e1);
	}

}
