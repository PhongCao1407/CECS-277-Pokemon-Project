import java.util.Random;

public class Squirtle extends Pokemon implements Water {

    Random rand = new Random();

    /**
    * Squirtle constructor
    */
    public Squirtle(){
        super("Squirtle");
        this.pokemonType = "Water";
    }

    /**
    * special menu accessor
    * @return special menu from water interface
    */
    public String getSpecialMenu(){
        return Water.specialMenu;
    }

    /**
    * number of special menu items accessor
    * @return the number of menu items
    */
    public int getNumSpecialMenuItems(){
        return 3;
    }

    /**
    * calls the chosen special attack
    * @param p Pokemon to attack
    * @param move the attack to use
    * @return the attacked Pokemon name and health
    */
    public String specialAttack(Pokemon p, int move){
        switch (move){
            case 1:
                System.out.println(waterGun(p));
                break;
            case 2:
                System.out.println(bubbleBeam(p));
                break;
            case 3:
                System.out.println(waterfall(p));
                break;
            default:
                return "That is not a valid move.";
        }
        return p.toString();
    }

    /**
    * water gun attack 
    * @param p Pokemon to attack
    * @return string describing attack
    */
    @Override
    public String waterGun(Pokemon p){
        int damage = rand.nextInt(4) + 2; //2-5 damage
        damage *= battleTable[1][p.getType()];
        p.takeDamage(damage);

        return "Squirtle squirted on " + p.getName() + ", dealing " + damage + " damage.";
    }

    /**
    * bubble beam attack 
    * @param p Pokemon to attack
    * @return string describing attack
    */
    @Override
    public String bubbleBeam(Pokemon p){
        int damage = rand.nextInt(3) + 1; // 1-2 damage
        damage *= battleTable[1][p.getType()];
        p.takeDamage(damage);

        return "Squirtle gave " + p.getName() + " a bubble bath, dealing " + damage + " damage.";
    }

    /**
    * waterfall attack 
    * @param p Pokemon to attack
    * @return string describing attack
    */
    @Override
    public String waterfall(Pokemon p){
        int damage = rand.nextInt(4) + 1; //1-4 damage
        damage *= battleTable[1][p.getType()];
        p.takeDamage(damage);

        return "Squirtle\'s water fell on " + p.getName() + ", dealing " + damage + " damage.";
    }
}
