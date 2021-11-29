import java.util.Random;

public class AttackUp extends PokemonDecorator {
    public AttackUp(Pokemon p){
        super(p,"+ATK",0);
    }

    public int getAttackBonus(int type) {
        Random rand = new Random();
        return rand.nextInt(2)+1;
    }
}
