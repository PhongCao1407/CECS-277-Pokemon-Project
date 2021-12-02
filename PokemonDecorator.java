public abstract class PokemonDecorator extends Pokemon{
    private Pokemon pokemon;

    /**
     * @param p the Pokemon to be decorated
     * @param extraName the prefix of the buffs and debuffs to be added to the name
     * @param extraHp the amount of extra hp to be added or subtracted
     */
    public PokemonDecorator(Pokemon p, String extraName, int extraHp){
        super(p.getName() + extraName, p.getHp() + extraHp, p.getMaxHp() + extraHp);
        pokemon = p;
    }

    /**
     * @param atkType the type of attack, basic or special
     * @return the attack menu, chosen from the correct type
     */
    public String getAttackMenu(int atkType){
        if (atkType == 1){
            return super.getAttackMenu(atkType);
        }
        return pokemon.getAttackMenu(atkType);
    }

    /**
     * @param atkType the type of the attack (Basic and Special)
     * @return the number of choices in the attack menu
     */
    public int getNumAttackMenuItems(int atkType){
        return pokemon.getNumAttackMenuItems(atkType);
    }

    /**
     * @param atkType the type of the attack (Basic and Special)
     * @param move the move to attack
     * @return the attack message
     */
    public String getAttackString(int atkType, int move){
        return pokemon.getAttackString(atkType, move);
    }

    /**
     * @param atkType the type of the attack (Basic and Special)
     * @param move the move to attack
     * @return the attack damage
     */
    public int getAttackDamage(int atkType, int move){
        return pokemon.getAttackDamage(atkType, move);
    }

    /**
     * @param p the Pokemon being attacked
     * @param type the type of the attack (Basic and Special)
     * @return the attack multiplier
     */
    public double getAttackMultiplier(Pokemon p, int type){
        if (type == 1){
            return super.getAttackMultiplier(p, type);
        }
        return pokemon.getAttackMultiplier(p, type);
    }

    /**
     * @param atkType the type of the attack (Basic and Special)
     * @return the attack bonus from buffs
     */
    public int getAttackBonus(int type){
        return pokemon.getAttackBonus(type);
    }

    /**
     * @return the Pokemon type
     */
    public int getType(){
        return pokemon.getType();
    }
}
