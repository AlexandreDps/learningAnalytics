
package bdd;

import java.sql.*;
import user.*;
//Singleton
public class ConnectMySql {
	
	public Connection conn;

	private ConnectMySql() {
		try {
	    	//Classe de driver
	    	Class.forName("com.mysql.jdbc.Driver");
	    	//Objet de connexion
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
	    	//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/id20129299_projjava", "id20129299_root", "lVEw/HPW[1=#L$Jz");
	    	this.conn = conn;
	    	System.out.println("Connexion à la bdd réussie");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
	}
		
	private static ConnectMySql INSTANCE = new ConnectMySql();
	
	public static ConnectMySql getInstance() {   
		return INSTANCE;
    }
	
	public void sendData(String requete) throws SQLException {
		Connection myConn = this.conn;
		Statement stmt = myConn.createStatement();
    	stmt.executeUpdate(requete);
	}
	public ResultSet readData(String requete) throws SQLException {
		Connection myConn = this.conn;
		Statement stmt = myConn.createStatement();
		ResultSet res = stmt.executeQuery(requete);
		return res;
	}
	
	public void inscription(String email,String nom,String prenom, String mdp,String codeInscription) {
		Boolean is_prof = false;
		if (codeInscription == "1234") {
			is_prof = true;
		}
		String reqq = "SELECT * FROM utilisateur WHERE email = '" + email + "'";
		try {
			ResultSet verif = readData(reqq);
			if (!verif.next()) {
				String req = "INSERT INTO `utilisateur` (`nom`,`prenom`,`email`,`mdp`,`admin`,`codeInscr`) VALUES ('" + nom + "','" + prenom + "','" + email + "','" + mdp + "'," + is_prof + ",'" + codeInscription + "')";
				try {
					sendData(req);
					System.out.println("Inscription valide. Amuse toi bien " + prenom);
				} catch (SQLException e) {
					System.out.println("Erreur, inscription impossible, veuillez vérifier les données");
				}
			}
			else {
				System.out.println("Vous avez déjà un compte avec cet email");
			}
		} catch (SQLException e1) {
			System.out.println("Erreur lors de la lecture de la requete de verification mail");
		}
		
		
	}
	public void connexion(String email, String mdp) {
		String req = "SELECT * FROM utilisateur WHERE email='" + email +"'";
		try {
			ResultSet verif = readData(req);
			if (!verif.next()) {
				System.out.println("Mdp ou email incorrect");
			}
			else {
				if (verif.getString("mdp").equals(mdp)) {
					System.out.println("Connexion réussie, bienvenue ");
					if (verif.getString("admin").equals(String.valueOf(1))) {
						UtilisateurFactory.createUtilisateur("prof", verif.getString("nom"), verif.getString("prenom"), email);
					}
					else { 
						UtilisateurFactory.createUtilisateur("eleve", verif.getString("nom"), verif.getString("prenom"), email);
					}
				}
				else {
					System.out.println("Mdp ou email incorrect");
				}
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la verification du mdp");
		}
	}
		
}

