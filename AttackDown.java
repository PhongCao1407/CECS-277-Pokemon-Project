public class AttackDown extends PokemonDecorator {
    /**
     * @param p the Pokemon to applied the attackDown debuff to
     */
    public AttackDown(Pokemon p){
        super(p,"-ATK",0);
    }

    /**
     * @param type the type of the Pokemon
     * @return the amount of damage being reduce from the debuff
     */
    public int getAttackBonus(int type) {
        return -1;
    }
}
