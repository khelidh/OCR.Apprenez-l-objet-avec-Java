/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr.coursjava.personnage;

/**
 * Super classe des différents personnages accessibles dans le jeu (Guerrier, Rodeur & Mage)
 * @author MAMA
 */
public class Personnage {
    
   
    protected String nomJoueur;
    protected String nomClasse;
     /**
        Niveau = Force + Agilité + Intelligence
    **/
    protected int niveau; 
    /**
     * vie = niveau multiplié par 5
     */
    protected int vie; // 
    protected int force; 
    protected int agilite; 
    protected int intelligence; 
    /**
     * nom de l'attaque de base différent selon les classes filles de Personnage
     */
    protected String basiqueAttaqueNom;
    /**
     * nom de l'attaque spécial différent selon les classes filles de Personnage
     */
    protected String specialeAttaqueNom;

    
    public Personnage(int level, int force, int agility, int intelligence, String nomJoueur, String nomClasse, String basicAttackName, String specialAttackName ) {
        this.niveau = level;
        this.force = force;
        this.agilite = agility;
        this.intelligence = intelligence;
        this.vie = 5 * level;
        this.basiqueAttaqueNom = basicAttackName;
        this.specialeAttaqueNom = specialAttackName;
        this.nomClasse = nomClasse;
        this.nomJoueur = nomJoueur;
    }
    
    
    
    /*
    
    Méthodes d'attaque à surcharger dans les classes filles
    
    */
    public int basiqueAttaque(Personnage p){return 0;};
    public void specialeAttaque(){};
    public void specialeAttaque(Personnage p){};

    /**
     * Override de la méthode toString qui permet de donner une description détaillé des attributs du personnage
     * @return String
     */
    @Override
    public String toString(){
        String introductionPhrase = "";
        
        if (this instanceof Guerrier)
            introductionPhrase = "Woarg";
        else if (this instanceof Mage)
            introductionPhrase = "Abracadabra";
        else if (this instanceof Rodeur)
            introductionPhrase = "Halte";
        
        String resumePersonnage = String.format("%s ! Je suis le %s %s de niveau %d je possède %d de vitalité, %d de force, %d d'agilité, %d d'intelligence !",
                introductionPhrase, this.getNomClasse(), this.getNomJoueur(), this.getNiveau(), this.getVie(), this.getForce(), this.getAgilite(), this.getIntelligence());   
    
        return resumePersonnage;
    }
    
    
    //// {Get & Set}ers

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getBasiqueAttaqueNom() {
        return basiqueAttaqueNom;
    }

    public void setBasiqueAttaqueNom(String basiqueAttaqueNom) {
        this.basiqueAttaqueNom = basiqueAttaqueNom;
    }

    public String getSpecialeAttaqueNom() {
        return specialeAttaqueNom;
    }

    public void setSpecialeAttaqueNom(String specialeAttaqueNom) {
        this.specialeAttaqueNom = specialeAttaqueNom;
    }
    
    
    
    
    
    
    
    
    
}
