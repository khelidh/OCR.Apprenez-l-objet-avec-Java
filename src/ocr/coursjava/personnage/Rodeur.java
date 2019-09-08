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
    /**
     * Attaque de base du Rodeur : les dommages infligés sont égaux à son agilité
     * @param personnageAdverse
     * @return 
     */
    @Override
     public int basiqueAttaque(Personnage personnageAdverse){
        int dommage = this.getAgilite();
        personnageAdverse.setVie(personnageAdverse.getVie() - dommage);   
        return dommage;
    }
     /**
     * Attaque spéciale du Rodeur : augmentation de l'agilité correspondant à la moitié de son niveau
     * Exemple : Niveau = 10 & Agilité = 5 ---devient---> Niveau = 10 & Agilité = 5 + 10/2 = 10
     */
    @Override
    public void specialeAttaque(){       
        this.setAgilite(this.getAgilite() + (this.getNiveau()/2));
        
        System.out.println(String.format("%s utilise %s qui lui permet d'être à %d d'agilité", 
                this.getNomJoueur(), this.getSpecialeAttaqueNom(), this.getAgilite()));
    }
}
