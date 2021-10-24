import java.util.Random;

public class Squirtle extends Pokemon implements Water {

    Random rand = new Random();

    public Squirtle(){
        super("Squirtle");
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
        return p.getName() + " is hurt.";
    }

    @Override
    public String waterGun(Pokemon p){
        int damage = rand.nextInt(4) + 2; //2-5 damage
        damage *= battleTable[1][p.getType()];
        p.takeDamage(damage);

        return "Squirtle squirted on " + p.getName() + ", dealing " + damage + " damage.";
    }

    @Override
    public String bubbleBeam(Pokemon p){
        int damage = rand.nextInt(3) + 1; // 1-2 damage
        damage *= battleTable[1][p.getType()];
        p.takeDamage(damage);

        return "Squirtle gave " + p.getName() + " a bubble bath, dealing " + damage + " damage.";
    }

    @Override
    public String waterfall(Pokemon p){
        int damage = rand.nextInt(4) + 1; //1-4 damage
        damage *= battleTable[1][p.getType()];
        p.takeDamage(damage);

        return "Squirtle\'s water fell on " + p.getName() + ", dealing " + damage + " damage.";
    }
}
