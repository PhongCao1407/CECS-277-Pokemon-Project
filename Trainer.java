package Project1;
/*
1. Trainer class
2. Fire Interface
3. Charmander class
4. Ponyta class
5. mainMenu method
6. chooseRandPokemon
method
7. main method
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Trainer extends Entity {
	
	private int money = 25;
	private int potions = 1;
	private int pokeballs = 5;
	private Point loc = new Point(); 
	private Map map = new Map();
	public ArrayList<Pokemon>pokemon = new ArrayList<Pokemon>();
	
	private static final int mHp = 25;
	private int mapNum = 1;
	Random rand = new Random();

	/**
	 * @param n		trainer's name 
	 * @param p		initial pokemon selected 
	 * @param m		Copy of map 
	 */
	
	public Trainer(String n, Pokemon p, Map m) {
		super(n, mHp);
		map = m; 
		loc = map.findStart();
		pokemon.add(p); 
	}
	
	/**
	 * total amount of money is returned
	 * @return money	
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * allows user to spend money if they can afford and decrements spent amount from user's "wallet"
	 * @param amt
	 * @return true/false
	 */
	public boolean spendMoney(int amt) {
		if (amt > money) {
			return false;
		} 
		else {
			money -= amt;
			return true;
		}
	}
	
	/**
	 * increments user's "wallet" when they receive money
	 * 	@param amt
	 */	
	public void receiveMoney(int amt) {
		money += amt;
	}
	
	/**
	 * confirms user has 1 or more potions
	 * @return true/false	
	 */
	public boolean hasPotion() {
		if (potions > 0) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	/**
	 * increments potion amount when user receives a potion	
	 */
	public void receivePotion() {
		potions += 1;
	}
	
	/**
	 * heals a certain pokemon the user specifies and decrements potion amount IF user has potions
	 * @param pokeIndex	
	 */
	public void usePotion(int pokeIndex) {
		
		if (hasPotion()) {
			getPokemon(pokeIndex).heal(); //subtract index by 1 if player's range excludes 0
			potions -= 1;
		}
	}
	
	/**
	 * confirms user has 1 or more pokeballs
	 * @return true/false	
	 */
	public boolean hasPokeball() {
		if (pokeballs > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 	increments user's amount of pokeballs when they receive a pokeball	
	 */
	public void receivePokeball() {
		pokeballs += 1;
	}
	
	/**
	 * allows user to catch pokemon depending on the health percentage of pokemon and if they have pokeballs
	 * @param p
	 * @return true/false	
	 */
	public boolean catchPokemon(Pokemon p) {
		double percent = p.getHp() / p.getMaxHp();
		if (rand.nextInt(101) > percent && hasPokeball()){
			pokemon.add(p);
			pokeballs -= 1;
			return true;
		}
		
		else {
		return false;
		}
	}
	
	/**
	 * gets user's map location
	 * @return loc
	 */
	public Point getLocation() {
		return loc;
	}
	
	/**
	 * decrements y value of point, causing the user to move one space upward on the map IF they are located below row 0 of the map
	 * Switches to different map depending on location of user (if they land on f), reveals characters found at locations they have visited, and removes certain visited characters
	 * functionality of each character will be further defined in main
	 * @return character found at map when user goes north
	 */
	public char goNorth() {
		Point pastloc = getLocation();
		int y = getLocation().y;
		if (y > 0) {
			getLocation().translate(0, -1); //to go up, decrement value
			map.loadMap(mapNum);
			if (map.getCharAtLoc(getLocation()) == 'f') {
				if (mapNum<3) {
					 map.loadMap(mapNum++);
				}
				else {
					 mapNum = 1;
					 map.loadMap(mapNum);
				}
			}
			else if (map.getCharAtLoc(pastloc) == 'i' || map.getCharAtLoc(pastloc) == 'p' || map.getCharAtLoc(pastloc) == 'w' && map.getCharAtLoc(getLocation()) != 'n') {
				map.removeCharAtLoc(pastloc);
			}
			
			map.reveal(pastloc);
			return map.getCharAtLoc(getLocation());
			}
		
		else {
			return (char) 0;
		}
	}
	
	/**
	 * increments y value of point, causing the user to move one space downward on the map IF they are located below row 0 of the map
	 * Switches to a different map depending on location of user (if they land on f), reveals characters found at locations they have visited, and removes certain visited characters
	 * functionality of each character will be further defined in main
	 * @return character found at map when user goes south
	 */
	public char goSouth() {
		Point pastloc = getLocation();
		int y = getLocation().y;
		if (y < 4) {
			getLocation().translate(0, +1);
			map.loadMap(mapNum);
			if (map.getCharAtLoc(getLocation()) == 'f') {
				if (mapNum<3) {
					 map.loadMap(mapNum++);
				}
				else {
					 mapNum = 1;
					 map.loadMap(mapNum);
				}
			}
			else if (map.getCharAtLoc(pastloc) == 'i' || map.getCharAtLoc(pastloc) == 'p' || map.getCharAtLoc(pastloc) == 'w' && map.getCharAtLoc(getLocation()) != 'n') {
				map.removeCharAtLoc(pastloc);
			}
			map.reveal(pastloc);
			return map.getCharAtLoc(getLocation());
		}
		else {
			System.out.println("You cannot go that way.");
			return (char) 0;
		}
	}
	
	/**
	 * increments x value of point, causing the user to move one space rightward on the map IF they are not located at the rightmost column of the map
	 * Switches to a different map depending on location of user (if they land on f), reveals characters found at locations they have visited, and removes certain visited characters
	 * functionality of each character will be further defined in main
	 * @return character found at map when user goes east
	 */	
	public char goEast() {
		Point pastloc = getLocation();
		int x = getLocation().x;
		if (x < 4) {
			getLocation().translate(+1, 0);
			map.loadMap(mapNum);
			if (map.getCharAtLoc(getLocation()) == 'f') {
				if (mapNum<3) {
					 map.loadMap(mapNum++);
				}
				else {
					 mapNum = 1;
					 map.loadMap(mapNum);
				}
			}
			
			else if (map.getCharAtLoc(pastloc) == 'i' || map.getCharAtLoc(pastloc) == 'p' || map.getCharAtLoc(pastloc) == 'w' && map.getCharAtLoc(getLocation()) != 'n') {
				map.removeCharAtLoc(pastloc);
			}
			map.reveal(pastloc);
			return map.getCharAtLoc(getLocation());
		}
		else {
			System.out.println("You cannot go that way.");
			return (char) 0;
		}
	}
	
	/**
	 * decrements x value of point, causing the user to move one space leftward on the map IF they are not located at the leftmost column of the map
	 * Switches to a different map depending on location of user (if they land on f), reveals characters found at locations they have visited, and removes certain visited characters
	 * functionality of each character will be further defined in main
	 * @return character found at map when user goes west
	 */	
	public char goWest() {
		Point pastloc = getLocation();
		int x = getLocation().x;
		if (x > 0) {
			getLocation().translate(-1, 0);
			map.loadMap(mapNum);
			if (map.getCharAtLoc(getLocation()) == 'f') {
				if (mapNum<3) {
					 map.loadMap(mapNum++);
				}
				else {
					 mapNum = 1;
					 map.loadMap(mapNum);
				}
			}
			else if (map.getCharAtLoc(pastloc) == 'i' || map.getCharAtLoc(pastloc) == 'p' || map.getCharAtLoc(pastloc) == 'w' && map.getCharAtLoc(getLocation()) != 'n') {
				map.removeCharAtLoc(pastloc);
			}
			map.reveal(pastloc);
			return map.getCharAtLoc(getLocation());
		}
		else {
			System.out.println("You cannot go that way.");
			return (char) 0;
		}
	}
	
	/**
	 * gets the number of pokemons user has
	 * @return pokemon.size()
	 */
	public int getNumPokemon() {
		return pokemon.size();
	}
	
	/**
	 * heals all pokemons
	 */
	public void healAllPokemon() {
		for (Pokemon p : pokemon) {
			p.heal();
		}
	}
	
	/**
	 * gets pokemon found at index _ of the array list (range of index: 0 - size of list minus 1)
	 * @param index
	 * @return pokemon.get(index)
	 */
	public Pokemon getPokemon(int index) {
		return pokemon.get(index); 
	}
	
	/**
	 * gets list of pokemons the user has (with health points ratio for each pokemon)
	 * @return PokemonList
	 */
	public String getPokemonList() {
		int count = 1;
		String PokemonList = "";
		for (Pokemon p : pokemon) {
			PokemonList += count + ". " + p.toString() + "\n";
			count ++;
		}
		return PokemonList;
	}
	
	/**
	 * @return trainer's summary (name, hp, inventory, pokemon list, map)
	 * 
	 */
	@Override
	public String toString() {
		String mon = "\nMoney: " + money;
		String potn = "\nPotions: " + potions;
		String pokB = "\nPokeballs: " + pokeballs;
		String pokL = "\n" + getPokemonList();
		String Map = "\n" + map.mapToString(loc) + "\n";
		return super.toString() + mon + potn + pokB + pokL + Map;
	}
}
