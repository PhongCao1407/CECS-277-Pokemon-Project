import java.util.Random;

public class Staryu extends Pokemon implements Water {

    Random rand = new Random();
    
    /**
    * Staryu constructor
    */
    public Staryu(){
        super("Staryu");
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
        int damage = rand.nextInt(5) + 1; //1-5 damage
        damage *= battleTable[1][p.getType()]; //multiply damage
        p.takeDamage(damage);

        return "Staryu shot " + p.getName() + " with a Super Soaker (trademark reserved, copyrighted by Nerf LLC), dealing " + damage + " damage.";
    }

    /**
    * bubble beam attack 
    * @param p Pokemon to attack
    * @return string describing attack
    */
    @Override
    public String bubbleBeam(Pokemon p){
        int damage = rand.nextInt(2) + 1; // 1-2 damage
        damage *= battleTable[1][p.getType()];
        p.takeDamage(damage);

        return "Staryu beamed " + p.getName() + " with bubbles, dealing " + damage + " damage.";
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

        return "Staryu made it rain on " + p.getName() + ", dealing " + damage + " damage.";
    }
}
