package PokemonProject;
import java.util.Random;

public class Staryu extends Pokemon implements Water {
    Random rand = new Random();
    
    @Override
    public String waterGun(Pokemon p){
        int damage = rand.nextInt(5) + 1; //1-5 damage
        p.takeDamage(damage);

        return "Staryu shot " + p.getName() + " with a Super Soaker (trademark reserved, copyrighted by Nerf LLC), dealing " + damage + " damage.";
    }

    @Override
    public String bubbleBeam(Pokemon p){
        int damage = rand.nextInt(2) + 1; // 1-2 damage
        p.takeDamage(damage);

        return "Staryu beamed " + p.getName() + " with bubbles, dealing " + damage + " damage.";
    }

    @Override
    public String waterfall(Pokemon p){
        int damage = rand.nextInt(4) + 1; //1-4 damage
        p.takeDamage(damage);

        return "Staryu made it rain on " + p.getName() + ", dealing " + damage + " damage.";
    }
}
