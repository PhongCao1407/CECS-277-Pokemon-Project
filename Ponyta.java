public class Ponyta extends Pokemon implements Fire {
   /**
    * class constructor 
    */		
	public Ponyta() {
		super("Ponyta");
	}
	
   /**
    * fire type special menu 
    * @return Fire.specialMenu
    */	
    public String getSpecialMenu(){
        return Fire.specialMenu;
    }
	
   /**
    * amount of options in special menu 
    * @return 3
    */
    public int getNumSpecialMenuItems(){
        return 3;
    }
    
   /**
    * a special attack move is selected by user
    * @return pokemon info and attack message or invalid message
    */	
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

   	/**
	 * attack type ember causes damage between the range 0-3
	 * @return attack message
	 */ 	
	@Override
	public String ember(Pokemon p) {
		int min = 0;
		int max = 4;
		int damage = (int) ((Math.random() * (max - min)+1) + min);
        damage *= battleTable[0][p.getType()];
		p.takeDamage(damage);
		return "Ponyta made an EMBER ATTACK to " + p.getName() + " with damage " + damage + ".";
	}

   	/**
	 * attack type fireBlast causes damage between the range 1-4
	 * @return attack message
	 */		
	@Override
	public String fireBlast(Pokemon p) {
		int min = 2;
		int max = 5;
		int damage = (int) ((Math.random() * (max - min)+1) + min);
        damage *= battleTable[0][p.getType()];
		p.takeDamage(damage);
		return "Ponyta BLASTED FIRE to " + p.getName() + " with damage " + damage + ".";
	}

   	/**
	 * attack type firePunch causes damage between the range 1-3
	 * @return attack message
	 */	
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
