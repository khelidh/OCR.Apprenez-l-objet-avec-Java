/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPersonnage;

import ocr.coursjava.game.Game;
import ocr.coursjava.personnage.Guerrier;
import ocr.coursjava.personnage.Mage;
import ocr.coursjava.personnage.Rodeur;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAMA
 */
public class GameTest {
    
    @Test
    public void testActionJoueur(){
        Game partie = new Game();
        Guerrier guerrier = new Guerrier(50, 35, 10, 5, "guerrier", "Guerrier", "basiqueAttaqueGuerrier", "specialeAttaqueGuerrier");
        Rodeur rodeur = new Rodeur(50, 10, 30, 10, "rodeur", "Rodeur", "basiqueAttaqueRodeur", "specialeAttaqueRodeur");
        
        partie.actionJoueur(guerrier, rodeur, 0);
        
        assertTrue("action indice non valable",partie.actionJoueur(guerrier, rodeur, 3) == false);
        assertTrue("action indice non valable",partie.actionJoueur(guerrier, rodeur, 1) == true);
        assertTrue("action indice non valable",partie.actionJoueur(guerrier, rodeur, 2) == true);
        assertTrue("action indice non valable",partie.actionJoueur(guerrier, rodeur, -1) == false);
    }
    
    @Test
    public void testAttaques(){
    
        Game partie = new Game();
        Guerrier guerrier = new Guerrier(50, 35, 10, 5, "guerrier", "Guerrier", "basiqueAttaqueGuerrier", "specialeAttaqueGuerrier");
        Mage mage = new Mage(10, 0, 0, 10, "mage", "Mage", "basiqueAttaqueMage", "specialeAttaqueMage");
        Rodeur rodeur = new Rodeur(50, 10, 30, 10, "rodeur", "Rodeur", "basiqueAttaqueRodeur", "specialeAttaqueRodeur");
        partie.setPersonnageJoueur1(guerrier);
        partie.setPersonnageJoueur2(mage);
        partie.basiqueAttaque(mage, guerrier);
        
        assertTrue("attaquebasique mage", guerrier.getVie() ==  250 -  10);
        
        partie.basiqueAttaque(guerrier, mage);
        assertTrue("attaquebasique guerrier", mage.getVie() ==  50 -  35);
        
        
        partie.specialeAttaque(mage, guerrier);
        assertTrue("specialeAttaque mage", mage.getVie() ==  15 + 2 * mage.getIntelligence());
        
        partie.specialeAttaque(guerrier, mage);
        assertTrue("specialeAttaque guerrier", mage.getVie() <  0);
        
        rodeur.specialeAttaque();
        assertTrue("specialeAttaque rodeur", rodeur.getAgilite() ==  30 + rodeur.getNiveau() / 2);
    
    }
    
    @Test
    public void testVerificationFinDePartie(){
        Game partie = new Game();
        Mage mage = new Mage(50, 0, 15, 35, "mage", "Mage", "basiqueAttaqueMage", "specialeAttaqueMage");
        Rodeur rodeur = new Rodeur(50, 10, 30, 10, "rodeur", "Rodeur", "basiqueAttaqueRodeur", "specialeAttaqueRodeur");
        
        partie.setPersonnageJoueur1(rodeur);
        partie.setPersonnageJoueur2(mage);
        assertTrue("fin de partie mageVie == 0", partie.verificationFinDePartie() == false);
        mage.setVie(0);
        assertTrue("fin de partie mageVie == 0", partie.verificationFinDePartie() == true);
        mage.setVie(10);
        rodeur.setVie(0);
        assertTrue("fin de partie mageVie == 0", partie.verificationFinDePartie() == true);
        
    }
    
    
}
