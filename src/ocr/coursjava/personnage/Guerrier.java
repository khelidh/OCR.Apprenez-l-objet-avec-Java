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
public class Guerrier extends Personnage {
    public Guerrier(String nomJoueur) {
        super(0, 0, 0, 0, nomJoueur, "Guerrier", "Coup d’Épée", "Coup de Rage");
    }

    public Guerrier(int level, int force, int agility, int intelligence, String nomJoueur, String nomClasse, String basicAttackName, String specialAttackName) {
        super(level, force, agility, intelligence, nomJoueur, nomClasse, basicAttackName, specialAttackName);
    }
    /**
     * Attaque de base du Guerrier : les dommages infligés sont égaux à sa force
     * @param personnageAdverse
     * @return 
     */
    @Override
    public int basiqueAttaque(Personnage personnageAdverse){
        int dommage = this.getForce();
        personnageAdverse.setVie(personnageAdverse.getVie() - dommage);   
        return dommage;
    }
    
    /**
     * Attaque spéciale du Guerrier : 
     *      - Inflige des dommages à l'adversaire équivalants à 2 fois sa force
     *      - S'inflige des dommages équivalants à sa force divisée par 2
     * @param personnageAdverse
     */
    @Override
    public void specialeAttaque(Personnage personnageAdverse){
        int force = this.getForce();
        
        personnageAdverse.setVie(personnageAdverse.getVie() - force * 2);  
        this.setVie(this.getVie() - force / 2); 
        
        String chaine = String.format("%s utilise %s et inflige %d dommages\n%s perd %d points de vie\n%s perd %d points de vie",
                    this.getNomJoueur(), this.getSpecialeAttaqueNom(), force * 2, personnageAdverse.getNomJoueur(),
                    force * 2, this.getNomJoueur(), force / 2);
        System.out.println(chaine);
    }
}
