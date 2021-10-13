public class Bulbasaur extends Pokemon implements Grass {
    
    public Bulbasaur(String n){
        super(n);
        this.pokemonType = "Grass";
    }

    public String getSpecialMenu(){
        return Grass.specialMenu;
    }

    public int getNumSpecialMenuItems(){
        return 3;
    }

    public String specialAttack(Pokemon p, int move){
        switch (move){
            case 1:
                vineWhip(p);
                break;
            case 2:
                razorLeaf(p);
                break;
            case 3:
                solarBeam(p);
                break;
            default:
                return "That is not a valid move.";
        }
        return p.getName() + " is hurt.";
    }

    public String vineWhip(Pokemon p){
        final int MIN_DAMAGE = 1;
        final int MAX_DAMAGE = 3;
        int damage = calcDamage(p, MIN_DAMAGE, MAX_DAMAGE);

        p.takeDamage(damage);
        return super.getName() + "take " + damage + " damages";
    }

    public String razorLeaf(Pokemon p){
        final int MIN_DAMAGE = 2;
        final int MAX_DAMAGE = 4;
        int damage = calcDamage(p, MIN_DAMAGE, MAX_DAMAGE);

        p.takeDamage(damage);
        return super.getName() + "take " + damage + " damages";
    }

    public String solarBeam(Pokemon p){
        final int MIN_DAMAGE = 0;
        final int MAX_DAMAGE = 5;
        int damage = calcDamage(p, MIN_DAMAGE, MAX_DAMAGE);

        p.takeDamage(damage);
        return super.getName() + "take " + damage + " damages";
    }

    //Ask prof about this
    public int calcDamage(Pokemon p,int minDamage, int maxDamage){
        switch (p.getType()){
            case 0:
                return 
                    (int)(((int)(Math.random() * ((maxDamage-minDamage)+1)) 
                    + minDamage) * battleTable[2][0]);
            case 1:
                return
                    (int)(((int)(Math.random() * ((maxDamage-minDamage)+1)) 
                    + minDamage) * battleTable[2][1]);
            case 2:
                return 
                    (int)(((int)(Math.random() * ((maxDamage-minDamage)+1)) 
                    + minDamage) * battleTable[2][2]);
            default:
                return -1;
        }
    }


    
}