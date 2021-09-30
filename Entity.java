package PokemonProject;

public class Entity{
    
    private String name;
    private int hp;
    private int maxHp;
    
    /**
     * Entity constructor
     * @param n new Entity name
     * @param mHp new Entity maxHp / starting hp
     */
    public Entity(String n, int mHp){
        this.name = n;
        this.maxHp = mHp;
        this.hp = mHp;
    }

    /**
     * @return Entity hp
     */
    public int getHp(){
        return this.hp;
    }

    /**
     * @return Entity maxHp
     */
    public int getMaxHp(){
        return this.maxHp;
    }

    /** Subtracts d from hp
     * Hp cannot go below 0
     * @param d amount of damage taken
     */
    public void takeDamage(int d){
        if(this.hp - d >= 0){
            this.hp -= d;
        } else {
            this.hp = 0;
        }
    }

    /**
     * heals entity to hp = maxHp
     */
    public void heal(){
        this.hp = this.maxHp;
    }

    /**
     * @return entity name
     */
    public String getName(){
        return this.name;
    }

    /** Returns entity name and hp
     * @return string in form 'Name HP: hp/maxHp'
     */
    public String toString(){
        String s = this.name + " HP: " + this.hp + "/" + this.maxHp;
        return s;
    }

}