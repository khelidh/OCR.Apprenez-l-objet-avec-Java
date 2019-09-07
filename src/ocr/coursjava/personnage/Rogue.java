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
public class Rogue extends Personnage{
    
    public Rogue() {
        super(0, 0, 0, 0, "Rôdeur", "Tir à l’Arc", "Concentration");
    }
  
    @Override
     protected void basicAttack(Personnage enemy){
        enemy.setHealth(enemy.getHealth() - this.getAgility());   
    };
    
    @Override
    protected void specialAttack(){       
        this.setAgility(this.getAgility() * (3/2));    
    };
    
    
    
}
