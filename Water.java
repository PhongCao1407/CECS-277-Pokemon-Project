import java.util.Random;
/** 
* Subclass Water extends from Superclass Pokemon
*/
public class Water extends Pokemon{
    public String specialMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";

    /**
    * constructor
    * @param n name
    * @param h hp 
    * @param m maxhp
    */    
    public Water(String n, int h, int m){
        super(n, h, m);
    } 
  
    /**
    * @param atkType type (1 corresponds to basic and 2 to special)
    * @return basic menu or special menu
    */ 
    public String getAttackMenu(int atkType){
        if (atkType == 1){
          return super.getAttackMenu(1);
        } else if (atkType == 2){
          return specialMenu;
        }
        return "That is not a valid input.";
    }
    
    /**
    * @param atkType type
    * @return total number of menu options
    */ 
    public int getNumAttackMenuItems(int atkType){
        return 3;
    }

    /**
    * @param atkType type
    * @param move the attacking move
    * @return a string of the selected move 
    * slam,tackle,punch if basic and water gun,bubble beam,waterfall if special
    */
    @Override
    public String getAttackString(int atkType, int move){
        if (atkType == 1){
            return super.getAttackString(atkType, move);
        }
        else{
          switch (move){
              case 1:
                  return "SQUIRTED with WATER GUN";
              case 2:
                  return "BLASTED with BUBBLE BEAM";
              case 3:
                  return "SPLASHED with WATERFALL";
          }
        }
        return "That is not a valid move.";
    }
    
    /**
    * @param atkType type
    * @param move the attacking move
    * @return attack damage
    */  
    @Override
    public int getAttackDamage(int atkType, int move){
        Random rand = new Random();
        if (atkType == 1){
          return super.getAttackDamage(atkType, move);
        } else{
          switch (move){
              case 1:
                  return rand.nextInt(4) + 2;
              case 2:
                  return rand.nextInt(3) + 1;
              case 3:
                  return rand.nextInt(4) + 1;
          }
        }
        return -1;
    }

    /**
    * @param p the pokemon to be attacked
    * @param atkType type
    * @return the attack multiplier for water versus the given type
    */  
    public double getAttackMultiplier(Pokemon p, int atkType){
        if (atkType == 1){
            return super.getAttackMultiplier(p, atkType);
          }
        return battleTable[1][p.getType()];
    }
}
