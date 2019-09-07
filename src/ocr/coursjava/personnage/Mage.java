/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr.coursjava.personnage;

/**
 *
 * @author MAMA
 */
public class Mage extends Personnage{

    public Mage() {
        super(0, 0, 0, 0, "Mage","Boule de Feu", "Soin ");
    }

    
    @Override
    protected void basicAttack(Personnage enemy){
        enemy.setHealth(enemy.getHealth() - this.getIntelligence());   
    };
    
    @Override
    protected void specialAttack(){     
        int newHealth = this.getHealth() + this.getIntelligence()*2;
        int maxHealth = this.getLevel() * 5;
        
        if (newHealth > maxHealth)
            this.setHealth(maxHealth);
        else         
            this.setHealth(newHealth);      
    };
    
    
    
}
