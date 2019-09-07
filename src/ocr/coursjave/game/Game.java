/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr.coursjave.game;

import java.util.Scanner;
import ocr.coursjava.personnage.Mage;
import ocr.coursjava.personnage.Personnage;
import ocr.coursjava.personnage.Rogue;
import ocr.coursjava.personnage.Warrior;

/**
 *
 * @author MAMA
 */
public class Game {

    String nomJoueur1 = "Joueur 1";
    String nomJoueur2 = "Joueur 2";

    Personnage personnageJoueur1 = null;
    Personnage personnageJoueur2 = null;
    
    public void commencerPartie(){
        creationPersonnage(personnageJoueur1, nomJoueur1);
        creationPersonnage(personnageJoueur2, nomJoueur2);
    }

    public void creationPersonnage(Personnage personnageJoueur, String nomJoueur) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Création du personnage de " + nomJoueur);

        personnageJoueur = choixClassePersonnage(scanner);

        choixNiveauPersonnage(scanner, personnageJoueur);
        choixForcePersonnage(scanner, personnageJoueur);
        choixAgilitePersonnage(scanner, personnageJoueur);
        choixIntelligencePersonnage(scanner, personnageJoueur);

        personnageJoueur.toString(nomJoueur);
    }

    public Personnage choixClassePersonnage(Scanner scanner) {
        
        System.out.println("Veuillez choisir la classe de votre personnage : 1 pour Guerrier ; 2 pour Rôdeur ; 3 pour Mage");
        String input = scanner.nextLine();
        int choixClasse = Integer.parseInt(input);
        
        Personnage perso;
        switch (choixClasse) {
            case (1):
                perso = new Warrior();
                break;
            case (2):
                perso = new Rogue();
                break;
            default:
                perso = new Mage();
        }
        return perso;
    }

    public void choixIntelligencePersonnage(Scanner scanner, Personnage personnageJoueur) {

        while (true) {
            System.out.println("Intelligence du personnage ? Doit être inférieur ou égale au niveau de votre personnage, et compris entre 0 et 100");
            String input = scanner.nextLine();
            int intelligencePersonnage = Integer.parseInt(input);
            if (intelligencePersonnage >= 0 && (intelligencePersonnage + personnageJoueur.getForce() + personnageJoueur.getAgility()) == personnageJoueur.getLevel()) {
                personnageJoueur.setIntelligence(intelligencePersonnage);
                return;
            } else {
                System.out.println("Vous n'avez pas saisi une intelligence inférieure ou égale au niveau du personnage moins la force et l'agilité ou compris dans l'intervalle [0,100] ! "
                        + "Il faut respecter : Force + Agilité + Intelligence = Niveau de votre personnage (" + personnageJoueur.getLevel() + ")");
            }
        }
    }

    public void choixAgilitePersonnage(Scanner scanner, Personnage personnageJoueur) {

        while (true) {
            System.out.println("Agilité du personnage ? Doit être inférieur ou égale au niveau de votre personnage, et compris entre 0 et 100");
            String input = scanner.nextLine();
            int agilitePersonnage = Integer.parseInt(input);

            if (agilitePersonnage >= 0 && (agilitePersonnage + personnageJoueur.getForce()) <= personnageJoueur.getLevel()) {
                personnageJoueur.setAgility(agilitePersonnage);
                return;
            } else {
                System.out.println("Vous n'avez pas saisi une agilité inférieure ou égale au niveau du personnage moins la force ou compris dans l'intervalle [0,100] !"
                        + "Il faut respecter : Force + Agilité + Intelligence = Niveau de votre personnage (" + personnageJoueur.getLevel() + ")");
            }
        }
    }

    public void choixForcePersonnage(Scanner scanner, Personnage personnageJoueur) {

        while (true) {
            System.out.println("Force du personnage ? Doit être inférieur ou égale au niveau de votre personnage, et compris entre 0 et 100");
            String input = scanner.nextLine();
            int forcePersonnage = Integer.parseInt(input);

            if (forcePersonnage >= 0 && forcePersonnage <= personnageJoueur.getLevel()) {
                personnageJoueur.setForce(forcePersonnage);
                return;
            } else {
                System.out.println("Vous n'avez pas saisi une force inférieure ou égale au niveau du personnage ou compris dans l'intervalle [0,100] !");
            }
        }
    }

    public void choixNiveauPersonnage(Scanner scanner, Personnage personnageJoueur) {

        while (true) {
            System.out.println("Niveau du personnage ? Compris entre 1 et 100");
            String input = scanner.nextLine();
            int niveauPersonnage = Integer.parseInt(input);

            if (niveauPersonnage >= 1 && niveauPersonnage <= 100) {
                personnageJoueur.setLevel(niveauPersonnage);
                personnageJoueur.setHealth(niveauPersonnage * 5);
                return;
            } else {
                System.out.println("Vous n'avez pas saisi un niveau entre 1 et 100!");
            }
        }
    }

}
