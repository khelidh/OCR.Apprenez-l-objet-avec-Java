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
public class Mage extends Personnage {

    public Mage(String nomJoueur) {
        super(0, 0, 0, 0, nomJoueur, "Mage", "Boule de Feu", "Soin ");
    }

    public Mage(int level, int force, int agility, int intelligence, String nomJoueur, String nomClasse, String basicAttackName, String specialAttackName) {
        super(level, force, agility, intelligence, nomJoueur, nomClasse, basicAttackName, specialAttackName);
    }

    @Override
    public int basisqueAttaque(Personnage enemy) {
        int dommage = this.getIntelligence();
        enemy.setVie(enemy.getVie() - dommage);
        return dommage;
    }

    @Override
    public void specialeAttaque() {
        int newVie = this.getVie() + this.getIntelligence() * 2;
        int maxVie = this.getNiveau() * 5;

        if (newVie > maxVie) {
            this.setVie(maxVie);
        } else {
            this.setVie(newVie);
        }

        System.out.println(String.format("%s utilise %s et se soigne jusqu'à %d de vitalité",
                this.getNomJoueur(), this.getSpecialeAttaqueNom(), this.getVie()));

    }
}
