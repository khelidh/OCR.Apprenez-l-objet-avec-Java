/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr.coursjava;

import ocr.coursjava.game.Partie;

/**
 * Activité OpenClassRooms : Apprenez l’objet avec Java
 * https://openclassrooms.com/fr/courses/4989236-apprenez-l-objet-avec-java
 * @author MAMA
 */
public class OCRCoursJava {

    /**
     * Point d'entrée : On initialise la partie puis on appelle demarrerPartie() pour lancer
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Partie partie = new Partie();
        partie.demarrerPartie();
        
    }
    
}
