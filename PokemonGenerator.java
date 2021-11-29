import java.io.*;
import java.util.*;

public class PokemonGenerator {
  HashMap <String, String> pokemon = new HashMap<String, String>();
  static PokemonGenerator instance = null;

   Random rand = new Random();
   private static final int MIN_HEALTH = 22;
   private static final int MAX_HEALTH = 25;
   private static int RANDOM_HEALTH = 
        (int)(Math.random() * ((MAX_HEALTH-MIN_HEALTH)+1)) + MIN_HEALTH;   
  
  private PokemonGenerator() {
    try {
      Scanner read = new Scanner(new File("PokemonList.txt"));
      while(read.hasNext()) {
        String line = read.nextLine();
        String[] divided = line.split(",");
        String key = divided[0];
        String value = divided[1];
        pokemon.put(key, value);
      } 
      read.close();
    }
    catch( FileNotFoundException fnf ) {
      System.out.println("File was not found");
    }
  }

  public static PokemonGenerator getInstance() {
    if (instance == null){
      instance = new PokemonGenerator();
    }
    return instance;
  }

  public Pokemon generatorRandomPokemon(int level) {
      int randIndex = rand.nextInt(23);  
      ArrayList<String> keys = new ArrayList<>(Arrays.asList("Bulbasaur", "Charmander", "Squirtle",
              "Vulpix", "Oddish", "Psyduck", "Growlithe",
              "Poliwag", "Bellsprout", "Tentacool", "Ponyta",
              "Slowpoke", "Seel", "Shellder", "Krabby","Exeggcute", "Tangela", "Horsea", "Goldeen",
              "Staryu", "Magikarp", "Lapras", "Moltres"));      
      
      String pok = keys.get(randIndex);
      String type = pokemon.get(pok);
      Pokemon p = new Water(pok, RANDOM_HEALTH,  RANDOM_HEALTH);
      
      switch(type) {
        case "Grass": 
          p = new Grass(pok, RANDOM_HEALTH,  RANDOM_HEALTH);
          break;
        case "Fire":
          p = new Fire(pok, RANDOM_HEALTH,  RANDOM_HEALTH);
          break;
        case "Water":
          p = new Water(pok, RANDOM_HEALTH,  RANDOM_HEALTH);
          break;
          
      }
      if (level > 1) {
        int count = 0;
        while (count != level){
          addRandomBuff(p); //the amount of buffs applied depends on pokemon level
          count += 1; 
        }
      }
      return p;    
  }

  public Pokemon getPokemon(String name){
    Pokemon p;
    if (name == "Bulbasaur" || name == "Oddish" || name == "Bellsprout" || name == "Exeggcute" || name == "Tangela") {
      p = new Grass(name, RANDOM_HEALTH,  RANDOM_HEALTH);
    }
    else if (name == "Charmander" || name == "Vulpix" || name == "Growlithe" || name == "Ponyta" || name == "Moltres") {
      p = new Fire(name, RANDOM_HEALTH,  RANDOM_HEALTH);
    }
    else if (name == "Squirtle" || name == "Pysduck" || name == "Poliwag" || name == "Tentacool" || name == "Slowpoke" || name == "Seel" || name == "Shellder" || name == "Krabby" || name == "Horsea" || name == "Goldeen" || name == "Staryu" || name == "Magikarp" || name == "Lapras") {
      p = new Water(name, RANDOM_HEALTH,  RANDOM_HEALTH);
    }
    else {
      return null;
    }
    return p;
  }
  public Pokemon addRandomBuff(Pokemon p) {
    int randBuff = rand.nextInt(2);
    
    switch(randBuff) {
      case 0: //AttackUp - increase damage by 1-2 points
        p = new AttackUp(p); //CAN THIS BE DONE?
        break;
      case 1: //HpUp - increase maxHp by 1-2 points
        p = new HpUp(p);
        break;
    }
    return p;
  }
  public Pokemon addRandomDeBuff(Pokemon p) {
    int randDebuff = rand.nextInt(2);
    switch(randDebuff) {
      case 0: //AttackUp - increase damage by 1-2 points
        p = new AttackUp(p); //CAN THIS BE DONE?
        break;
      case 1: //HpUp - increase maxHp by 1-2 points
        p = new HpUp(p);
        break;
    }
    return p;
  }
}
