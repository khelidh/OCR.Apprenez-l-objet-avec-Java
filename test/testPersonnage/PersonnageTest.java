package testPersonnage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ocr.coursjava.game.PersonnageCreator;
import ocr.coursjava.personnage.Personnage;
import ocr.coursjava.personnage.Guerrier;
import ocr.coursjava.personnage.Mage;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAMA
 */
public class PersonnageTest {

    PersonnageCreator personnageCreator = new PersonnageCreator();

    @Test
    public void testCreationGuerrier() {
        Personnage warrior = new Guerrier("warrior");
        assertTrue("Warrior force == Warrior", warrior.getForce() == 0);
        assertTrue("Warrior force == Warrior", warrior.getVie() == 0);
        assertTrue("Warrior force == Warrior", warrior.getAgilite() == 0);
        assertTrue("Warrior force == Warrior", warrior.getIntelligence() == 0);
        assertTrue("Warrior force == Warrior", "Guerrier".equals(warrior.getNomClasse()));
    }

    @Test
    public void testCreationPersonnages() {
        Personnage mage = new Mage("MageTEST");
        
        personnageCreator.setNiveauPersonnage(mage, 300);
        assertTrue("Mage force ", mage.getNiveau() == 0);
        personnageCreator.setNiveauPersonnage(mage, -5);
        assertTrue("Mage force ", mage.getNiveau() == 0);
        personnageCreator.setNiveauPersonnage(mage, 50);
        assertTrue("Mage force ", mage.getNiveau() == 50);
        
        personnageCreator.setForcePersonnage(mage, -5);
        assertTrue("Mage force ", mage.getForce() == 0);
        personnageCreator.setForcePersonnage(mage, 60);
        assertTrue("Mage force ", mage.getForce() == 0);
        personnageCreator.setForcePersonnage(mage, 10);
        assertTrue("Mage force ", mage.getForce() == 10);
        
        personnageCreator.setAgilitePersonnage(mage, -5);
        assertTrue("Mage force ", mage.getAgilite() == 0);
        personnageCreator.setAgilitePersonnage(mage, 45);
        assertTrue("Mage force ", mage.getAgilite() == 0);
        personnageCreator.setAgilitePersonnage(mage, 15);
        assertTrue("Mage force ", mage.getAgilite() == 15);
        
        personnageCreator.setIntelligencePersonnage(mage, 150);
        assertTrue("Mage force ", mage.getIntelligence() == 0);
        personnageCreator.setIntelligencePersonnage(mage, -5);
        assertTrue("Mage force ", mage.getIntelligence() == 0);
        personnageCreator.setIntelligencePersonnage(mage, 40);
        assertTrue("Mage force ", mage.getIntelligence() == 0);
        personnageCreator.setIntelligencePersonnage(mage, 50 - mage.getForce() - mage.getAgilite());
        assertTrue("Mage force ", mage.getIntelligence() == 25);
    }
    
    
}
