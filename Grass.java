public class Grass extends Pokemon{
    private String grassAttackMenu = 
        "1. Vine Whip\n" 
      + "2. Razor Leaf\n"
      + "3. Solar Beam";
    public int numSpecialMenuItems = 3;
  
    public Grass(String n, int h, int m){
      super(n, h, m);
    } 

    public String getAttackMenu(int atkType){
      if (atkType == 1){
        return super.getAttackMenu(1);
      } else if (atkType == 2){
        return grassAttackMenu;
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
                return "WHIPPED with VINE";
            case 2:
                return "SLASHED with RAZOR LEAF";
            case 3:
                return "DAZZLED BY SOLAR BEAM";
        }
      }
      return "That is not a valid move.";
    }

    @Override
    public int getAttackDamage(int atkType, int move){
      if (atkType == 1){
        return getAttackDamage(atkType, move);
      } else{
        switch (move){
            case 1:
                final int MIN_VINEWHIP_DAMAGE = 1;
                final int MAX_VINEWHIP_DAMAGE = 3;
                return (int)(Math.random() * ((MAX_VINEWHIP_DAMAGE-MIN_VINEWHIP_DAMAGE)+1)) 
                        + MIN_VINEWHIP_DAMAGE;
            case 2:
                final int MIN_RAZORLEAF_DAMAGE = 2;
                final int MAX_RAZORLEAF_DAMAGE = 4;
                return (int)(Math.random() * ((MAX_RAZORLEAF_DAMAGE-MIN_RAZORLEAF_DAMAGE)+1)) 
                        + MIN_RAZORLEAF_DAMAGE;
            case 3:
                final int MIN_SOLARBEAM_DAMAGE = 0;
                final int MAX_SOLARBEAM_DAMAGE = 5;
                return (int)(Math.random() * ((MAX_SOLARBEAM_DAMAGE-MIN_SOLARBEAM_DAMAGE)+1)) 
                        + MIN_SOLARBEAM_DAMAGE;
        }
      }
      return -1;
    }

    public double getAttackMultipier(Pokemon p, int atkType){
      return battleTable[2][p.getType()];
    }

  
}