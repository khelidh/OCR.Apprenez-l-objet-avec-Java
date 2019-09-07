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
public class Warrior extends Personnage {
    
    

    public Warrior() {
        super(0, 0, 0, 0, "Guerrier", "Coup d’Épée", "Coup de Rage");
    }
    
    @Override
    protected void basicAttack(Personnage enemy){
        enemy.setHealth(enemy.getHealth() - this.getForce());   
    };
    
    @Override
    protected void specialAttack(Personnage enemy){
        enemy.setHealth(enemy.getHealth() - this.getForce()*2);  
        this.setHealth(this.getHealth() - this.getForce()/2);    
    }
    
    
    
    
}
