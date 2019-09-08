/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr.coursjava;

import ocr.coursjava.game.Partie;

/**
 *
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
