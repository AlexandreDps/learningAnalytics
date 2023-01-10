package user;

public class UtilisateurFactory {
    public static Utilisateur createUtilisateur(String type, String nom, String prenom, String email) {
        if ("prof".equalsIgnoreCase(type)) {
            return new Teacher(nom, prenom, email);
        } else if ("eleve".equalsIgnoreCase(type)) {
            return new Student(nom, prenom, email);
        }
        return null;
    }
}
