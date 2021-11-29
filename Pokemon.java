import java.lang.Math;

public abstract class Pokemon extends Entity {
    /**
     * the table of damage multiplier for the different Pokemon types
     */
    static final double[][] battleTable = 
        {{1,.5,2},
         {2,1,.5},
         {.5,2,1}};
    
    /**
     * the type of the Pokemon, to be implemented later in the subclasses
     */

    public Pokemon(String n, int h, int m){
        super(n, h, m);
    }

    /**
     * @return the basic menu as a String
     */
    public String getAttackMenu(int atkType){
        return "1. Slam\n"
        + "2. Tackle\n"
        + "3. Punch";
    }

    /**
     * @return the number of choices in the basic menu (3)
     */
    public int getNumAttackMenuItems(int atkType){
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

    public double getAttackMultiplier(Pokemon p, int atkType){
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
            * this.getAttackMultiplier(p, atkType) 
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