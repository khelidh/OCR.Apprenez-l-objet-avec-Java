/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr.coursjava.game;

import java.util.Scanner;
import ocr.coursjava.personnage.Mage;
import ocr.coursjava.personnage.Personnage;
import ocr.coursjava.personnage.Rodeur;
import ocr.coursjava.personnage.Guerrier;

/**
 *
 * @author MAMA
 */
public class Partie {

    private final String nomJoueur1 = "Joueur 1";
    private final String nomJoueur2 = "Joueur 2";
    private final PersonnageCreator personnageCreator = new PersonnageCreator();

    private Personnage personnageJoueur1;
    private Personnage personnageJoueur2;

    private boolean tour;

    /**
     * tour = true : tour du joueur 1
     */
    public Partie() {
        this.personnageJoueur1 = null;
        this.personnageJoueur2 = null;
        this.tour = true;
    }

    /**
     * Lance une partie : creation des 2 personnages avec PersonnageCreator & combat tour par tour avec choixActionJoueur
     */
    public void demarrerPartie(){
        Scanner scanner = new Scanner(System.in);

        personnageJoueur1 = this.personnageCreator.creationPersonnage(scanner, nomJoueur1);
        personnageJoueur2 = this.personnageCreator.creationPersonnage(scanner, nomJoueur2);

        while (true) {
            if (tour) {
                this.choixActionJoueur(scanner, personnageJoueur1, personnageJoueur2);
            } else {
                this.choixActionJoueur(scanner, personnageJoueur2, personnageJoueur1);
            }

            if (verificationFinDePartie()) {
                scanner.close();
                break;
            } else {
                tour = !tour;
            }
        }
    }

    /**
     * Demande l'entrée clavier de l'indice de l'action à l'utilisateur et appelle la méthode actionJoueur() pour l'exécuter
     * Traitement de l'exception NumberFormatException. Si elle est levée ou que l'indice n'est pas dans l'intervalle autorisée, on ne sort pas de la boucle.
     * @param scanner
     * @param personnageJoueur
     * @param personnageAdverse 
     */
    public void choixActionJoueur(Scanner scanner, Personnage personnageJoueur, Personnage personnageAdverse) {

        while (true) {

            String chaine = String.format("%s %s (%d vitalité) veuillez choisir votre action :\n    1. Attaque Basique : %s \n    2. Attaque Spéciale : %s",
                    personnageJoueur.getNomClasse(), personnageJoueur.getNomJoueur(), personnageJoueur.getVie(), personnageJoueur.getBasiqueAttaqueNom(), personnageJoueur.getSpecialeAttaqueNom());
            System.out.println(chaine);

            String input = scanner.nextLine();
            
            try {
                int action = Integer.parseInt(input);
                if (actionJoueur(personnageJoueur, personnageAdverse, action))
                    return;
            } catch (NumberFormatException e) {
                System.out.println("Vous n'avez pas saisi un indice correspondant à une action");
            }
        }
    }

    /**
     * Suivant l'action du joueur (1 pour attaque basique et 2 pour attaque spéciale), on excute la fonction surchargée des sous-classes
     * Retourne true si l'action est exécutée
     * @param personnageJoueur
     * @param personnageAdverse
     * @param action
     * @return 
     */
    public boolean actionJoueur(Personnage personnageJoueur, Personnage personnageAdverse, int action) {
        if (action == 1 || action == 2) {
            if (action == 1) {
                this.basiqueAttaque(personnageJoueur, personnageAdverse);
            } else {
                this.specialeAttaque(personnageJoueur, personnageAdverse);
            }

            return true;
        }
        return false;
    }

    /**
     * Retourne vrai si la partie est terminée (vitalité d'un des deux ou des deux personnages inférieure à 0
     * @return 
     */
    public boolean verificationFinDePartie() {

        int vieJoueur1 = personnageJoueur1.getVie();
        int vieJoueur2 = personnageJoueur2.getVie();

        if (vieJoueur1 <= 0 && vieJoueur2 > 0) {
            System.out.println(String.format("%s est mort ! %s gagne la partie !", personnageJoueur1.getNomJoueur(), personnageJoueur2.getNomJoueur()));
            return true;
        } else if (vieJoueur1 > 0 && vieJoueur2 <= 0) {
            System.out.println(String.format("%s est mort ! %s gagne la partie !", personnageJoueur2.getNomJoueur(), personnageJoueur1.getNomJoueur()));
            return true;
        } else if (vieJoueur1 <= 0 && vieJoueur2 <= 0) {
            System.out.println(String.format("Les joueurs se sont entretués ! Match nul !", personnageJoueur2.getNomJoueur()));
            return true;
        }
        return false;
    }

    /**
     * Exécute l'attaque de base des différentes classes sur le personnage adverse
     * @param personnageJoueur
     * @param personnageAdverse 
     */
    public void basiqueAttaque(Personnage personnageJoueur, Personnage personnageAdverse) {
        int dommage = personnageJoueur.basiqueAttaque(personnageAdverse);
        String output = String.format("%s utilise %s et inflige %d dommages\n%s perd %d points de vie",
                personnageJoueur.getNomJoueur(), personnageJoueur.getBasiqueAttaqueNom(), dommage, personnageAdverse.getNomJoueur(), dommage);
        System.out.println(output);
    }

    /**
     * Si le Personnage est un Guerrier, la fonction specialeAttaque() prend comme paramètre le personnage adverse
     * Sinon sans paramètre
     * @param personnageJoueur
     * @param personnageAdverse 
     */
    public void specialeAttaque(Personnage personnageJoueur, Personnage personnageAdverse) {
        if (personnageJoueur instanceof Guerrier) {
            personnageJoueur.specialeAttaque(personnageAdverse);
        } else {
            personnageJoueur.specialeAttaque();
        }
    }
    
    
    
    
    
    /*
    Get & Set ers
    */

    public Personnage getPersonnageJoueur1() {
        return personnageJoueur1;
    }

    public void setPersonnageJoueur1(Personnage personnageJoueur1) {
        this.personnageJoueur1 = personnageJoueur1;
    }

    public Personnage getPersonnageJoueur2() {
        return personnageJoueur2;
    }

    public void setPersonnageJoueur2(Personnage personnageJoueur2) {
        this.personnageJoueur2 = personnageJoueur2;
    }

    public boolean isTour() {
        return tour;
    }

    public void setTour(boolean tour) {
        this.tour = tour;
    }
    
    
}
