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
public class Personnage {
    
    /*
    
    Level = Force + Agility + Intelligence
    Health = Level * 5
    
    */
    protected String nomClasse;
    protected int level; 
    protected int health; 
    protected int force; 
    protected int agility; 
    protected int intelligence; 
    protected String basicAttackName;
    protected String specialAttackName;

    public Personnage() {
    }
    public Personnage(int level, int force, int agility, int intelligence, String nomClasse, String basicAttackName, String specialAttackName ) {
        this.level = level;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 5 * level;
        this.basicAttackName = basicAttackName;
        this.specialAttackName = specialAttackName;
        this.nomClasse = nomClasse;
    }
    
    
    
    
    protected void basicAttack(Personnage p){};
    protected void specialAttack(){};
    protected void specialAttack(Personnage p){};

    public void toString(String nomJoueur){
        String introductionPhrase = "";
        
        if (this instanceof Warrior)
            introductionPhrase = "Woarg";
        else if (this instanceof Mage)
            introductionPhrase = "Abracadabra";
        else if (this instanceof Rogue)
            introductionPhrase = "Halte";
        
        String resumePersonnage = String.format("%s ! Je suis le %s %s de niveau %d je possède %d de vitalité, %d de force, %d d'agilité, %d d'intelligence !",
                introductionPhrase, this.getNomClasse(), nomJoueur, this.getLevel(), this.getHealth(), this.getForce(), this.getAgility(), this.getIntelligence());   
    
        System.out.println(resumePersonnage);
    }
    
    
    //// {Get & Set}ers
    
    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getBasicAttackName() {
        return basicAttackName;
    }

    public void setBasicAttackName(String basicAttackName) {
        this.basicAttackName = basicAttackName;
    }

    public String getSpecialAttackName() {
        return specialAttackName;
    }

    public void setSpecialAttackName(String specialAttackName) {
        this.specialAttackName = specialAttackName;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    
    
    
    
    
    
}
