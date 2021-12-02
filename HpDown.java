public class HpDown extends PokemonDecorator{
    /**
     * @param p the Pokemon to applied the hpDown debuff to
     */
    public HpDown(Pokemon p){
        super(p,"-HP",-1);
    }
}