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
 * Gère la création des personnages lors de la première phase du programme
 * Les méthodes choix* utilise le scanner permettant les entrées clavier et appelle leur méthode set*
 * Choix* : Classe et les différentes valeurs des attributs (niveau, force, agilité et intelligence) par l'utilisateur
 * Les méthodes set* sont indépendantes et pourraient être utilisées avec entrées via IHM
 * Set* : lie la valeur aux différents attributs ( niveau, force, agilité et intelligence) de l'objet Personnage spécifié
 * La méthode choixClassePersonnage est différente et n'appelle pas de fonction set* : elle crée et renvoie l'objet Personnage choisi par l'utilisateur
 */
public class PersonnageCreator {
    /**
     * Renvoie un Personnage avec les attributs choisis par l'utilisateur grâce à l'entrée clavier
     * A la fin de toutes les actions de création du personnage, la méthode toString est appelée pour donner la description globale du perso
     * @param scanner
     * @param nomJoueur
     * @return 
     */
    public Personnage creationPersonnage(Scanner scanner, String nomJoueur) {

        Personnage personnageJoueur = choixClassePersonnage(scanner, nomJoueur);

        choixNiveauPersonnage(scanner, personnageJoueur);
        choixForcePersonnage(scanner, personnageJoueur);
        choixAgilitePersonnage(scanner, personnageJoueur);
        choixIntelligencePersonnage(scanner, personnageJoueur);

        String descriptionPersonnage = personnageJoueur.toString();
        System.out.println(descriptionPersonnage);

        return personnageJoueur;
    }

    public Personnage choixClassePersonnage(Scanner scanner, String nomJoueur) {
        while (true) {
            System.out.println("Veuillez choisir la classe de votre personnage : 1 pour Guerrier ; 2 pour Rôdeur ; 3 pour Mage");
            String input = scanner.nextLine();

            int choixClasse = inputToInteger(input);

            switch (choixClasse) {
                case (1):
                    return new Guerrier(nomJoueur);
                case (2):
                    return new Rodeur(nomJoueur);
                case (3):
                    return new Mage(nomJoueur);
                default:
                    System.out.println("Vous n'avez donné un indice correct ! ");

            }
        }
    }
    
    public void choixIntelligencePersonnage(Scanner scanner, Personnage personnageJoueur) {
        while (true) {
            System.out.println("Intelligence du personnage ? Doit être inférieur ou égale au niveau de votre personnage, et compris entre 0 et 100");
            String input = scanner.nextLine();
            int intelligencePersonnage = inputToInteger(input);

            if (setIntelligencePersonnage(personnageJoueur, intelligencePersonnage)) {
                return;
            } else {
                System.out.println("Vous n'avez pas saisi une intelligence inférieure ou égale au niveau du personnage moins la force et l'agilité ou compris dans l'intervalle [0,100] ! "
                        + "Il faut respecter : Force + Agilité + Intelligence = Niveau de votre personnage (" + personnageJoueur.getNiveau() + ")");
            }
        }
    }

    public boolean setIntelligencePersonnage(Personnage personnageJoueur, int intelligencePersonnage) {
        if (intelligencePersonnage >= 0 && (intelligencePersonnage + personnageJoueur.getForce() + personnageJoueur.getAgilite()) == personnageJoueur.getNiveau()) {
            personnageJoueur.setIntelligence(intelligencePersonnage);
            return true;
        }
        return false;
    }

    public void choixAgilitePersonnage(Scanner scanner, Personnage personnageJoueur) {

        while (true) {
            System.out.println("Agilité du personnage ? Doit être inférieur ou égale au niveau de votre personnage, et compris entre 0 et 100");
            String input = scanner.nextLine();
            int agilitePersonnage = inputToInteger(input);

            if (this.setAgilitePersonnage(personnageJoueur, agilitePersonnage)) {
                return;
            } else {
                System.out.println("Vous n'avez pas saisi une agilité inférieure ou égale au niveau du personnage moins la force ou compris dans l'intervalle [0,100] !"
                        + "Il faut respecter : Force + Agilité + Intelligence = Niveau de votre personnage (" + personnageJoueur.getNiveau() + ")");
            }
        }
    }

    public boolean setAgilitePersonnage(Personnage personnageJoueur, int agilitePersonnage) {
        if (agilitePersonnage >= 0 && (agilitePersonnage + personnageJoueur.getForce()) <= personnageJoueur.getNiveau()) {
            personnageJoueur.setAgilite(agilitePersonnage);
            return true;
        }
        return false;
    }

    public void choixForcePersonnage(Scanner scanner, Personnage personnageJoueur) {

        while (true) {
            System.out.println("Force du personnage ? Doit être inférieur ou égale au niveau de votre personnage, et compris entre 0 et 100");
            String input = scanner.nextLine();
            int forcePersonnage = inputToInteger(input);

            if (setForcePersonnage(personnageJoueur, forcePersonnage)) {
                return;
            } else {
                System.out.println("Vous n'avez pas saisi une force inférieure ou égale au niveau du personnage ou compris dans l'intervalle [0,100] !");
            }
        }
    }

    public boolean setForcePersonnage(Personnage personnageJoueur, int forcePersonnage) {
        if (forcePersonnage >= 0 && forcePersonnage <= personnageJoueur.getNiveau()) {
            personnageJoueur.setForce(forcePersonnage);
            return true;
        }
        return false;
    }

    public void choixNiveauPersonnage(Scanner scanner, Personnage personnageJoueur) {

        while (true) {
            System.out.println("Niveau du personnage ? Compris entre 1 et 100");
            String input = scanner.nextLine();
            int niveauPersonnage = inputToInteger(input);

            if (setNiveauPersonnage(personnageJoueur, niveauPersonnage)) {
                return;
            } else {
                System.out.println("Vous n'avez pas saisi un niveau entre 1 et 100!");
            }
        }
    }

    public boolean setNiveauPersonnage(Personnage personnageJoueur, int niveauPersonnage) {

        if (niveauPersonnage >= 1 && niveauPersonnage <= 100) {
            personnageJoueur.setNiveau(niveauPersonnage);
            personnageJoueur.setVie(niveauPersonnage * 5);
            return true;
        }
        return false;
    }

    /**
     * Gère l'exception NumberFormatException lors de l'entrée clavier des actions Joueur
     * Si l'exception est attrapée, on donne -1 à l'input
     * @param input
     * @return 
     */
    public int inputToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    
    
}
