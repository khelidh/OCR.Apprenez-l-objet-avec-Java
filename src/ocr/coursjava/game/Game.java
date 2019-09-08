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
public class Game {

    private final String nomJoueur1 = "Joueur 1";
    private final String nomJoueur2 = "Joueur 2";
    private final PersonnageCreator personnageCreator = new PersonnageCreator();

    private Personnage personnageJoueur1;
    private Personnage personnageJoueur2;

    private boolean tour;

    public Game() {
        this.personnageJoueur1 = null;
        this.personnageJoueur2 = null;
        this.tour = true;
    }

    public void commencerPartie() throws NumberFormatException {
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
                break;
            } else {
                tour = !tour;
            }
        }
    }

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

    public void basiqueAttaque(Personnage personnageJoueur, Personnage personnageAdverse) {
        int dommage = personnageJoueur.basisqueAttaque(personnageAdverse);
        String output = String.format("%s utilise %s et inflige %d dommages\n%s perd %d points de vie",
                personnageJoueur.getNomJoueur(), personnageJoueur.getBasiqueAttaqueNom(), dommage, personnageAdverse.getNomJoueur(), dommage);
        System.out.println(output);
    }

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
