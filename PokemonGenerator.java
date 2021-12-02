import java.io.*;
import java.util.*;

/**
* Applies factory design pattern
* Scans text file and stores key, value pairs into hashmap
* Generates pokemons given their level or string name (2 different methods)
* Generates random buff/debuff
*/
public class PokemonGenerator {
  HashMap <String, String> pokemon = new HashMap<String, String>();
  static PokemonGenerator instance = null;

   Random rand = new Random();
   private static final int MIN_HEALTH = 22;
   private static final int MAX_HEALTH = 25;
   private static int RANDOM_HEALTH = 
        (int)(Math.random() * ((MAX_HEALTH-MIN_HEALTH)+1)) + MIN_HEALTH;   

    /**
    * Scans and stores
    */  
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
  
  /**
  * creates PokemonGenerator object
  * @return instance (when instance != null)
  */
  public static PokemonGenerator getInstance() {
    if (instance == null){
      instance = new PokemonGenerator();
    }
    return instance;
  }
  
  /**
  * @param level pokemon level
  * @return randomly constructed pokemon with a random buff (if level is > 1)
  */
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
          p = addRandomBuff(p); //the amount of buffs applied depends on pokemon level
          count += 1; 
        }
      }
      return p;    
  }

  /**
  * @param name name
  * @return contructed pokemon
  */
  public Pokemon getPokemon(String name){
    Pokemon p = new Grass(name, RANDOM_HEALTH,  RANDOM_HEALTH); //Predeclare Pokemon so that the compiler will shut up
    String type = pokemon.get(name);
    switch(type) {
      case "Grass": 
        p = new Grass(name, RANDOM_HEALTH,  RANDOM_HEALTH);
        break;
      case "Fire":
        p = new Fire(name, RANDOM_HEALTH,  RANDOM_HEALTH);
        break;
      case "Water":
        p = new Water(name, RANDOM_HEALTH,  RANDOM_HEALTH);
        break;
        
    }

    return p;
  }
  
  /**
  * @param p pokemon
  * @return pokemon with a random buff
  */
  public Pokemon addRandomBuff(Pokemon p) {
    int pokemonType = p.getType();
    int randBuff = rand.nextInt(2);
    switch(randBuff) {
      case 0: //AttackUp - increase damage by 1-2 points
        p = new AttackUp(p); //CAN THIS BE DONE?
        break;
      case 1: //HpUp - increase maxHp by 1-2 points
        p = new HpUp(p);
        break;
    } 
    switch (pokemonType){
      case 0:
        p = new Fire(p.getName(), p.getHp(), p.getMaxHp());
        break;
      case 1:
        p = new Water(p.getName(), p.getHp(), p.getMaxHp());
        break;
      case 2:
        p = new Grass(p.getName(), p.getHp(), p.getMaxHp());
        break;
    }
    
    return p;
  }
  
  /**
  * @param p pokemon
  * @return pokemon with a random debuff
  */   
  public Pokemon addRandomDeBuff(Pokemon p) {
    int pokemonType = p.getType();
    int randDebuff = rand.nextInt(2);
    switch(randDebuff) {
      case 0: //AttackUp - increase damage by 1-2 points
        p = new AttackDown(p); 
        break;
      case 1: //HpUp - increase maxHp by 1-2 points
        p = new HpDown(p);
        break;
    }
    
    switch (pokemonType){
      case 0:
        p = new Fire(p.getName(), p.getHp(), p.getMaxHp());
        break;
      case 1:
        p = new Water(p.getName(), p.getHp(), p.getMaxHp());
        break;
      case 2:
        p = new Grass(p.getName(), p.getHp(), p.getMaxHp());
        break;
    }

    return p;
  }
}
