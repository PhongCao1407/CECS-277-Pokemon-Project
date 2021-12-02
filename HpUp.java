import java.lang.Math;

public class HpUp extends PokemonDecorator{
    /**
     * @param p the Pokemon to applied the hpUp buff to
     */
    public HpUp(Pokemon p){
        super(p,"+HP",(int) (Math.random() + 1));
    }
}