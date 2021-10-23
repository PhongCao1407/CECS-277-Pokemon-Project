public class Oddish extends Pokemon implements Grass {
    
    public Oddish(){
        super("Oddish");
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
        return p.toString();
    }

    public String vineWhip(Pokemon p){
        final int MIN_DAMAGE = 1;
        final int MAX_DAMAGE = 3;
        int damage = (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
        + MIN_DAMAGE) * battleTable[2][p.getType()]);

        p.takeDamage(damage);
        return p.getName() + " is WHIPPED with VINE and takes " +  damage + " damage";
    }

    public String razorLeaf(Pokemon p){
        final int MIN_DAMAGE = 2;
        final int MAX_DAMAGE = 4;
        int damage = (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
        + MIN_DAMAGE) * battleTable[2][p.getType()]);

        p.takeDamage(damage);
        return p.getName() + "is SLASHED with RAZOR LEAF and takes " + damage + " damages";
    }

    public String solarBeam(Pokemon p){
        final int MIN_DAMAGE = 0;
        final int MAX_DAMAGE = 3;
        int damage = (int)(((int)(Math.random() * ((MAX_DAMAGE-MIN_DAMAGE)+1)) 
        + MIN_DAMAGE) * battleTable[2][p.getType()]);

        p.takeDamage(damage);
        return p.getName() + " is DAZZLED by SOLAR BEAM and takes " +  damage + " damage";
    }
}