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
public class Rodeur extends Personnage{
    
    public Rodeur(String nomJoueur) {
        super(0, 0, 0, 0, nomJoueur, "Rôdeur", "Tir à l’Arc", "Concentration");
    }

    public Rodeur(int level, int force, int agility, int intelligence, String nomJoueur, String nomClasse, String basicAttackName, String specialAttackName) {
        super(level, force, agility, intelligence, nomJoueur, nomClasse, basicAttackName, specialAttackName);
    }
    
    @Override
     public int basisqueAttaque(Personnage enemy){
        int dommage = this.getAgilite();
        enemy.setVie(enemy.getVie() - dommage);   
        return dommage;
    }
    
    @Override
    public void specialeAttaque(){       
        this.setAgilite(this.getAgilite() + (this.getNiveau()/2));
        
        System.out.println(String.format("%s utilise %s qui lui permet d'être à %d d'agilité", 
                this.getNomJoueur(), this.getSpecialeAttaqueNom(), this.getAgilite()));
    }
}
