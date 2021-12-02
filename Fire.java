/** 
* Subclass Fire extends from Superclass Pokemon
*/
public class Fire extends Pokemon{
    private String fireAttackMenu = 
        "1. Ember\n" 
      + "2. Fire Blast\n"
      + "3. Fire Punch";
    public int numSpecialMenuItems = 3;

    /**
    * constructor
    * @param pokemon's name
    * @param pokemon's hp 
    * @param pokemon's maxhp
    */    
    public Fire(String n, int h, int m){
      super(n, h, m);
    } 

    /**
    * @param attack type (1 corresponds to basic and 2 to special)
    * @return basic menu or special menu
    */ 
    public String getAttackMenu(int atkType){
      if (atkType == 1){
        return super.getAttackMenu(1);
      } else if (atkType == 2){
        return fireAttackMenu;
      }
      return "That is not a valid input.";
    }

    /**
    * @param attack type
    * @return total number of menu options
    */    
    public int getNumAttackMenuItems(int atkType){
      return 3;
    }


    /**
    * @param attack type
    * @param move
    * @return a string of the selected move 
    * slam, tackle, punch if basic and ember,blast,fire punch if special
    */ 
    @Override
    public String getAttackString(int atkType, int move){
      if (atkType == 1){
        return super.getAttackString(atkType, move);
      }
      else{
        switch (move){
            case 1:
                return "ROASTED with EMBER";
            case 2:
                return "BLASTED with FIRE";
            case 3:
                return "PUNCHED by FIRE";
        }
      }
      return "That is not a valid move.";
    }

    /**
    * @param attack type
    * @param move 
    * @return attack damage
    */    
    @Override
    public int getAttackDamage(int atkType, int move){
      if (atkType == 1){
        return super.getAttackDamage(atkType, move);
      } else{
        switch (move){
            case 1:
                final int MIN_EMBER_DAMAGE = 0;
                final int MAX_EMBER_DAMAGE = 4;
                return (int)(Math.random() * ((MAX_EMBER_DAMAGE-MIN_EMBER_DAMAGE)+1)) 
                        + MIN_EMBER_DAMAGE;
            case 2:
                final int MIN_FIREBLAST_DAMAGE = 1;
                final int MAX_FIREBLAST_DAMAGE = 5;
                return (int)(Math.random() * ((MAX_FIREBLAST_DAMAGE-MIN_FIREBLAST_DAMAGE)+1)) 
                        + MIN_FIREBLAST_DAMAGE;
            case 3:
                final int MIN_FIREPUNCH_DAMAGE = 1;
                final int MAX_FIREPUNCH_DAMAGE = 4;
                return (int)(Math.random() * ((MAX_FIREPUNCH_DAMAGE-MIN_FIREPUNCH_DAMAGE)+1)) 
                        + MIN_FIREPUNCH_DAMAGE;
        }
      }
      return -1;
    }

    /**
    * @param pokemon 
    * @param attack type
    * @return battleTable[0][p.getType()]
    */
    public double getAttackMultiplier(Pokemon p, int atkType){
      if (atkType == 1){
        return super.getAttackMultiplier(p, atkType);
      }
      return battleTable[0][p.getType()];
    }

}
