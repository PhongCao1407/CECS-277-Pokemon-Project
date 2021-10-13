public class Bulbasaur extends Pokemon implements Grass {
    
    public Bulbasaur(){
        super("Bulbasaur");
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
        int damage = 0;
        switch (p.getType()){
            case 0:
                damage = 
                    (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
                    + MIN_DAMAGE) * battleTable[2][0]);
                break;
            case 1:
                damage = 
                    (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
                    + MIN_DAMAGE) * battleTable[2][1]);
                break;
            case 2:
                damage = 
                    (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
                    + MIN_DAMAGE) * battleTable[2][2]);
                break;
        }

        p.takeDamage(damage);
        return super.getName() + "take " + damage + " damages";
    }

    public String razorLeaf(Pokemon p){
        final int MIN_DAMAGE = 2;
        final int MAX_DAMAGE = 4;
        int damage = 0;
        switch (p.getType()){
            case 0:
                damage = 
                    (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
                    + MIN_DAMAGE) * battleTable[2][0]);
                break;
            case 1:
                damage = 
                    (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
                    + MIN_DAMAGE) * battleTable[2][1]);
                break;
            case 2:
                damage = 
                    (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
                    + MIN_DAMAGE) * battleTable[2][2]);
                break;
        }

        p.takeDamage(damage);
        return super.getName() + "take " + damage + " damages";
    }

    public String solarBeam(Pokemon p){
        final int MIN_DAMAGE = 0;
        final int MAX_DAMAGE = 5;
        int damage = 0;
        switch (p.getType()){
            case 0:
                damage = 
                    (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
                    + MIN_DAMAGE) * battleTable[2][0]);
                break;
            case 1:
                damage = 
                    (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
                    + MIN_DAMAGE) * battleTable[2][1]);
                break;
            case 2:
                damage = 
                    (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
                    + MIN_DAMAGE) * battleTable[2][2]);
                break;
        }

        p.takeDamage(damage);
        return super.getName() + "take " + damage + " damages";
    }

}