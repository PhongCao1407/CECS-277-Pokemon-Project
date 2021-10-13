import java.util.Random;

public class Staryu extends Pokemon implements Water {

    Random rand = new Random();
    
    public Staryu(){
        super("Staryu");
        this.pokemonType = "Water";
    }

    public String getSpecialMenu(){
        return Water.specialMenu;
    }

    public int getNumSpecialMenuItems(){
        return 3;
    }

    public String specialAttack(Pokemon p, int move){
        switch (move){
            case 1:
                waterGun(p);
                break;
            case 2:
                bubbleBeam(p);
                break;
            case 3:
                waterfall(p);
                break;
            default:
                return "That is not a valid move.";
        }
        return p.getName() + " is hurt.";
    }

    @Override
    public String waterGun(Pokemon p){
        int damage = rand.nextInt(5) + 1; //1-5 damage
        damage *= battleTable[1][p.getType()]; //multiply damage
        p.takeDamage(damage);

        return "Staryu shot " + p.getName() + " with a Super Soaker (trademark reserved, copyrighted by Nerf LLC), dealing " + damage + " damage.";
    }

    @Override
    public String bubbleBeam(Pokemon p){
        int damage = rand.nextInt(2) + 1; // 1-2 damage
        damage *= battleTable[1][p.getType()];
        p.takeDamage(damage);

        return "Staryu beamed " + p.getName() + " with bubbles, dealing " + damage + " damage.";
    }

    @Override
    public String waterfall(Pokemon p){
        int damage = rand.nextInt(4) + 1; //1-4 damage
        damage *= battleTable[1][p.getType()];
        p.takeDamage(damage);

        return "Staryu made it rain on " + p.getName() + ", dealing " + damage + " damage.";
    }
}