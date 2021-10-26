public class Ponyta extends Pokemon implements Fire {
	
	public Ponyta() {
		super("Ponyta");
		this.pokemonType = "Fire";
	}
	
    public String getSpecialMenu(){
        return Fire.specialMenu;
    }

    public int getNumSpecialMenuItems(){
        return 3;
    }
    
    public String specialAttack(Pokemon p, int move){
        switch (move){
            case 1:
                System.out.println(ember(p));
                break;
            case 2:
                System.out.println(fireBlast(p));
                break;
            case 3:
                System.out.println(firePunch(p));
                break;
            default:
                return "That is not a valid move.";
        }
        return p.toString();
    }

	@Override
	public String ember(Pokemon p) {
		int min = 0;
		int max = 4;
		int damage = (int) ((Math.random() * (max - min)+1) + min);
        damage *= battleTable[0][p.getType()];
		p.takeDamage(damage);
		return "Ponyta made an EMBER ATTACK to " + p.getName() + " with damage " + damage + ".";
	}
	
	@Override
	public String fireBlast(Pokemon p) {
		int min = 2;
		int max = 5;
		int damage = (int) ((Math.random() * (max - min)+1) + min);
        damage *= battleTable[0][p.getType()];
		p.takeDamage(damage);
		return "Ponyta BLASTED FIRE to " + p.getName() + " with damage " + damage + ".";
	}
	
	@Override
	public String firePunch(Pokemon p) {
		int min = 1;
		int max = 4;
		int damage = (int) ((Math.random() * (max - min)+1) + min);
        damage *= battleTable[0][p.getType()];
		p.takeDamage(damage);
		return "With a FLAMING hoof, Ponyta KICKED " + p.getName() + " with damage " + damage + ".";
	}
}
