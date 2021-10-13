import java.lang.Math;

public abstract class Pokemon extends Entity{
    /**
     * the table of damage multiplier for the different Pokemon types
     */
    static final double[][] battleTable = 
        {{1,.5,2},
         {2,1,.5},
         {.5,2,1}};

    private static final int MIN_HEALTH = 22;
    private static final int MAX_HEALTH = 25;
    private static final int RANDOM_HEALTH = 
        (int)(Math.random() * ((MAX_HEALTH-MIN_HEALTH)+1)) + MIN_HEALTH;
    
    /**
     * the type of the Pokemon, to be implemented later in the subclasses
     */
    public String pokemonType;

    public Pokemon(String n){
        super(n, RANDOM_HEALTH);
    }
    
    /**
     * @return the special menu as a String
     */
    public abstract String getSpecialMenu();

    /**
     * @return the number of choices in the special menu
     */
    public abstract int getNumSpecialMenuItems();

    /**
     * Carry out a special attack on the given Pokemon
     * @param p the Pokemon to be attacked
     * @param move the special attacking move 
     * @return a String message confirming the attack
     */
    public abstract String specialAttack(Pokemon p, int move);

    /**
     * @return the basic menu as a String
     */
    public String getBasicMenu(){
        return "1. Slam\n"
        + "2. Tackle\n"
        + "3. Punch";
    }

    /**
     * @return the number of choices in the basic menu (3)
     */
    public int getNumBasicMenuItems(){
        return 3;
    }

    /**
     * attack a Pokemon with a move given as an int 
     * 1: slam
     * 2: tackle
     * 3: punch
     * @param p the Pokemon to be attacked
     * @param move the move to attack the Pokemon
     * @return a String message confirming the attack
     */
    public String basicAttack(Pokemon p, int move){
        switch (move){
            case 1:
                slam(p);
                break;
            case 2:
                tackle(p);
                break;
            case 3:
                punch(p);
                break;
            default:
                return "That is not a valid move.";
        }
        return p.getName() + " is hurt.";

    }

    /**
     * @return the basic attack menu as a String
     */
    public String getAttackMenu(){
        return "1. Basic Attack\n"
        + "2. Special Attack";
    }

    /**
     * @return the number of choices in the basic attack menu (2)
     */
    public int getNumAttackMenuItems(){
        return 2;
    }

    /**
     * carry out a slam attack on the given Pokemon
     * the damage is randomized between 0 and 5
     * @param p the Pokemon to be slammed
     * @return a String message confirming the slam
     */
    public String slam(Pokemon p){
        final int MIN_DAMAGE = 0;
        final int MAX_DAMAGE = 5;
        int slamDamage = 
            (int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
            + MIN_DAMAGE;
        p.takeDamage(slamDamage);
        return super.getName() + "take " + slamDamage + " damages";
        
    }

    /**
     * carry out a tackle attack on the given Pokemon
     * the damage is randomized between 2 and 3
     * @param p the Pokemon to be tackled
     * @return a String message confirming the tackle
     */
    public String tackle(Pokemon p){
        final int MIN_DAMAGE = 2;
        final int MAX_DAMAGE = 3;
        int tackleDamage = 
            (int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
            + MIN_DAMAGE;
        p.takeDamage(tackleDamage);
        return super.getName() + "take " + tackleDamage + " damages";
    }

    /**
     * carry out a punch attack on the given Pokemon
     * the damage is randomized between 1 and 4
     * @param p the Pokemon to be punched
     * @return a String message confirming the slam
     */
    public String punch(Pokemon p){
        final int MIN_DAMAGE = 1;
        final int MAX_DAMAGE = 4;
        int punchDamage = 
            (int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
            + MIN_DAMAGE;
        p.takeDamage(punchDamage);
        return super.getName() + "take " + punchDamage + " damages";
    }

    /**
     * convert the Pokemon's type to an int and return it
     * fire: 0
     * water: 1
     * grass: 2
     * @return the Pokemon's type as an int
     */
    public int getType(){
        //Check type of pokemon using implicit paramenter
        switch (this.pokemonType.toLowerCase()){
            case "fire":
                return 0;
            case "water":
                return 1;
            case "grass":
                return 2;
        }
        return -1;
    }
}