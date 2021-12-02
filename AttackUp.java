import java.util.Random;

public class AttackUp extends PokemonDecorator {
    /**
     * @param p the Pokemon to applied the attackUp buff to
     */
    public AttackUp(Pokemon p){
        super(p,"+ATK",0);
    }

    /**
     * @param type the type of the Pokemon
     * @return the attack bonus buff
     */
    public int getAttackBonus(int type) {
        Random rand = new Random();
        return rand.nextInt(2)+1;
    }
}
