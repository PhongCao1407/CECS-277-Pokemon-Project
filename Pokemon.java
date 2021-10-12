import java.lang.Math;

public abstract class Pokemon extends Entity{
    static final double[][] battleTable = {{1,.5,2},
                                           {2,1,.5},
                                           {.5,2,1}};
    private static int RANDOM_HEALTH = (int)(Math.random() * ((25-22)+1)) + 22;
    private String pokemonType;

    public Pokemon(String n){
        super(n, RANDOM_HEALTH);
    }
    
    public abstract String getSpecialMenu();
    public abstract int getNumSpecialMenuItems();
    public abstract String specialAttack(Pokemon p, int move);

    public String getBasicMenu(){
        return "1. Slam\n"
        + "2. Tackle\n"
        + "3. Punch";
    }

    public int getNumBasicMenuItems(){
        return 3;
    }

    public String basicAttack(Pokemon p, int move){
        switch (move){
            case 1:
                slam(p);
                break;
            case 2:
                tackle(p);
                break;
            case 3:
                punch(p);
                break;
        }
        return p.getName() + " is attacked";

    }

    public String getAttackMenu(){
        return "1. Basic Attack\n"
        + "2. Special Attack";
    }

    public int getNumAttackMenuItems(){
        return 2;
    }

    public String slam(Pokemon p){
        int slamDamage =  (int)(Math.random() * ((5-0)+1));
        p.takeDamage(slamDamage);
        return super.getName() + "take " + slamDamage + " damages";
        
    }

    public String tackle(Pokemon p){
        int tackleDamage =  (int)(Math.random() * ((3-2)+1)) + 2;
        p.takeDamage(tackleDamage);
        return super.getName() + "take " + tackleDamage + " damages";
    }

    public String punch(Pokemon p){
        int punchDamage =  (int)(Math.random() * ((4-1)+1)) + 2;
        p.takeDamage(punchDamage);
        return super.getName() + "take " + punchDamage + " damages";
    }

    public int getType(){
        //Check type of pokemon using implicit paramenter
        switch (this.pokemonType.toLowerCase()){
            case "fire":
                return 0;
            case "water":
                return 1;
            case "grass":
                return 2;
        }
        return -1;
    }
}