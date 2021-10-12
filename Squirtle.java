import java.util.Random;

public class Squirtle extends Pokemon implements Water {

    Random rand = new Random();

    @Override
    public String waterGun(Pokemon p){
        int damage = rand.nextInt(4) + 2; //2-5 damage
        p.takeDamage(damage);

        return "Squirtle squirted on " + p.getName() + ", dealing " + damage + " damage.";
    }

    @Override
    public String bubbleBeam(Pokemon p){
        int damage = rand.nextInt(3) + 1; // 1-2 damage
        p.takeDamage(damage);

        return "Squirtle gave " + p.getName() + " a bubble bath, dealing " + damage + " damage.";
    }

    @Override
    public String waterfall(Pokemon p){
        int damage = rand.nextInt(4) + 1; //1-4 damage
        p.takeDamage(damage);

        return "Squirtle\'s water fell on " + p.getName() + ", dealing " + damage + " damage.";
    }
}
