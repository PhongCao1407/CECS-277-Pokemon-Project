import java.lang.Math;

public abstract class Pokemon extends Entity {
    /**
     * the table of damage multiplier for the different Pokemon types
     */
    static final double[][] battleTable = 
        {{1,.5,2},
         {2,1,.5},
         {.5,2,1}};

    private static final int MIN_HEALTH = 22;
    private static final int MAX_HEALTH = 25;
    // private static final int RANDOM_HEALTH = 
    //     (int)(Math.random() * ((MAX_HEALTH-MIN_HEALTH)+1)) + MIN_HEALTH;
    
    /**
     * the type of the Pokemon, to be implemented later in the subclasses
     */

    public Pokemon(String n, int h, int m){
        super(n, h, m);
    }

    /**
     * @return the basic menu as a String
     */
    public String getAttackMenu(){
        return "1. Slam\n"
        + "2. Tackle\n"
        + "3. Punch";
    }

    /**
     * @return the number of choices in the basic menu (3)
     */
    public int getNumAttackMenuItems(){
        return 3;
    }

    public String getAttackString(int atkType, int move){
        switch (move){
            case 1:
                return "SLAMMED";
            case 2:
                return "TACKLED";
            case 3:
                return "PUNCHED";
            default:
                return "That is not a valid move.";
        }
    }

    public int getAttackDamage(int atkType, int move){
        switch (move){
            case 1:
                final int MIN_SLAM_DAMAGE = 0;
                final int MAX_SLAM_DAMAGE = 5;
                return (int)(Math.random() * ((MAX_SLAM_DAMAGE-MIN_SLAM_DAMAGE)+1)) 
                        + MIN_SLAM_DAMAGE;
            case 2:
                final int MIN_TACKLE_DAMAGE = 2;
                final int MAX_TACKLE_DAMAGE = 3;
                return (int)(Math.random() * ((MAX_TACKLE_DAMAGE-MIN_TACKLE_DAMAGE)+1)) 
                        + MIN_TACKLE_DAMAGE;
            case 3:
                final int MIN_PUNCH_DAMAGE = 1;
                final int MAX_PUNCH_DAMAGE = 4;
                return (int)(Math.random() * ((MAX_PUNCH_DAMAGE-MIN_PUNCH_DAMAGE)+1)) 
                        + MIN_PUNCH_DAMAGE;
            default:
                return -1;
        }
    }

    public double getAttackMultipier(Pokemon p, int atkType){
        return 1;
    }

    public int getAttackBonus(int atkType){
        return 0;
    }


    /**
     * attack a Pokemon with a move given as an int 
     * 1: slam
     * 2: tackle
     * 3: punch
     * @param p the Pokemon to be attacked
     * @param atkType the attack type
     * @param move the move to attack the Pokemon
     * @return a String message confirming the attack
     */
    public String attack(Pokemon p, int atkType, int move){
        int damage = (int)
            (this.getAttackDamage(atkType, move) 
            * this.getAttackMultipier(p, atkType) 
            + getAttackBonus(atkType));

        p.takeDamage(damage);
        return p.getName() + "is " + getAttackString(atkType, move) + " by " 
            + this.getName() + " and takes " + damage + "damage";

    }

    /**
     * @return the basic attack menu as a String
     */
    public String getAttackTypeMenu(){
        return "1. Basic Attack\n"
        + "2. Special Attack";
    }

    /**
     * @return the number of choices in the basic attack menu (2)
     */
    public int getNumAttackTypeMenuItems(){
        return 2;
    }

    /**
     * carry out a slam attack on the given Pokemon
     * the damage is randomized between 0 and 5
     * @param p the Pokemon to be slammed
     * @return a String message confirming the slam
     */
    // public String slam(Pokemon p){
    //     final int MIN_DAMAGE = 0;
    //     final int MAX_DAMAGE = 5;
    //     int damage = 
    //         (int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
    //         + MIN_DAMAGE;
    //     p.takeDamage(damage);
    //     return p.getName() + " is SLAMMED by " + this.getName() + " and takes " +  damage + " damage.";
    // }

    /**
     * carry out a tackle attack on the given Pokemon
     * the damage is randomized between 2 and 3
     * @param p the Pokemon to be tackled
     * @return a String message confirming the tackle
     */
    // public String tackle(Pokemon p){
    //     final int MIN_DAMAGE = 2;
    //     final int MAX_DAMAGE = 3;
    //     int damage = 
    //         (int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
    //         + MIN_DAMAGE;
    //     p.takeDamage(damage);
    //     return p.getName() + " is TACKLED by " + this.getName() + " and takes " +  damage + " damage.";
    // }

    /**
     * carry out a punch attack on the given Pokemon
     * the damage is randomized between 1 and 4
     * @param p the Pokemon to be punched
     * @return a String message confirming the slam
     */
    // public String punch(Pokemon p){
    //     final int MIN_DAMAGE = 1;
    //     final int MAX_DAMAGE = 4;
    //     int damage = 
    //         (int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
    //         + MIN_DAMAGE;
    //     p.takeDamage(damage);
    //     return p.getName() + " is PUNCHED by " + this.getName() + " and takes " +  damage + " damage.";
    // }


    /**
     * convert the Pokemon's type to an int and return it
     * fire: 0
     * water: 1
     * grass: 2
     * @return the Pokemon's type as an int
     */
    public int getType(){
        //Check type of pokemon using implicit paramenter
        if (this instanceof Fire){
            return 0;
        } else if (this instanceof Water){
            return 1;
        } else if (this instanceof Grass){
            return 2;
        }
        return -1;
    }
}