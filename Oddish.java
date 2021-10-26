public class Oddish extends Pokemon implements Grass {
    
    /**
     * Inherit from Pokemon superclass
     * Declare pokemon type as Grass
     */
    public Oddish(){
        super("Oddish");
        this.pokemonType = "Grass";
    }

    /**
     * @return the Special Menu for Grass type
     */
    public String getSpecialMenu(){
        return Grass.specialMenu;
    }

    /**
     * @return the number of items in the Special Menu (3)
     */
    public int getNumSpecialMenuItems(){
        return 3;
    }

    /**
     * Special Attack a Pokemon with a move given as an int 
     * 1: vireWhip
     * 2: razorLeaf
     * 3: solarBeam
     * @return the Special Attack message as a String
     */
    public String specialAttack(Pokemon p, int move){
        switch (move){
            case 1:
                System.out.println(vineWhip(p));
                break;
            case 2:
                System.out.println(razorLeaf(p));
                break;
            case 3:
                System.out.println(solarBeam(p));
                break;
            default:
                return "That is not a valid move.";
        }
        return p.toString();
    }

    /**
     * @return the attack damage message of Vine Whip
     */
    public String vineWhip(Pokemon p){
        final int MIN_DAMAGE = 1;
        final int MAX_DAMAGE = 3;
        int damage = (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
        + MIN_DAMAGE) * battleTable[2][p.getType()]);

        p.takeDamage(damage);
        return p.getName() + " is WHIPPED with VINE and takes " +  damage + " damage";
    }

    /**
     * @return the attack damage message of Razor Leaf
     */
    public String razorLeaf(Pokemon p){
        final int MIN_DAMAGE = 2;
        final int MAX_DAMAGE = 4;
        int damage = (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
        + MIN_DAMAGE) * battleTable[2][p.getType()]);

        p.takeDamage(damage);
        return p.getName() + "is SLASHED with RAZOR LEAF and takes " + damage + " damages";
    }

    /**
     * @return the attack damage message of Solar Beam
     */
    public String solarBeam(Pokemon p){
        final int MIN_DAMAGE = 0;
        final int MAX_DAMAGE = 3;
        int damage = (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
        + MIN_DAMAGE) * battleTable[2][p.getType()]);

        p.takeDamage(damage);
        return p.getName() + " is DAZZLED by SOLAR BEAM and takes " +  damage + " damage";
    }
}