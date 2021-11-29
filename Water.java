import java.util.Random;

public class Water extends Pokemon{
    public String specialMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";

    //TODO: JAVADOCS!!!
    
    public Water(String n, int h, int m){
        super(n, h, m);
    } 
  
    public String getAttackMenu(int atkType){
        if (atkType == 1){
          return super.getAttackMenu(1);
        } else if (atkType == 2){
          return specialMenu;
        }
        return "That is not a valid input.";
    }
  
    public int getNumAttackMenuItems(int atkType){
        return 3;
    }
  
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
  
    public double getAttackMultipier(Pokemon p, int atkType){
        return battleTable[1][p.getType()];
    }
}
