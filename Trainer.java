import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Trainer extends Entity {
	
	private int money = 25;
	private int potions = 1;
	private int pokeballs = 5;
	private Point loc = new Point(); 
	private ArrayList<Pokemon>pokemon = new ArrayList<Pokemon>();
	
	Random rand = new Random();

	/**
	 * class constructor
	 * @param n		trainer's name 
	 * @param p		initial pokemon selected 
	 * @param m		Copy of map 
	 */
	public Trainer(String n, Pokemon p) {
		super(n, 25, 25);
		loc = Map.getInstance().findStart();
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
	 * @param amt
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
			getPokemon(pokeIndex).heal();
			PokemonGenerator pokemonGenerator = new PokemonGenerator();
			pokemonGenerator.addRandomBuff(getPokemon(pokeIndex));
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
	 * increments user's amount of pokeballs when they receive a pokeball	
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
		double percent = ((double)(p.getMaxHp() - p.getHp()) / (double)p.getMaxHp()) * (double)100;
		int randNum = rand.nextInt(100) + 1;
		if ((randNum < percent) && hasPokeball()){
			pokemon.add(p);
			pokeballs -= 1;
			if (this.getNumPokemon() > 6){ //This maybe implement in main, im not sure where it is suppose to be implemented
				System.out.println("Please choose a pokemon to discard.\n" + this.getPokemonList());
				int input = CheckInput.getIntRange(0,6);
				pokemon.remove(input);
			}
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
	 * reveals characters found at locations they have visited
	 * @return character found at map when user goes north
	 */
	public char goNorth() {
		int y = getLocation().y;
		if (y > 0) {
			this.loc.translate(0, -1); //to go up, decrement value
			
			return Map.getInstance().getCharAtLoc(getLocation());
			}
		
		else {
			System.out.println("You cannot go that way.");
			return (char) 0;
		}
	}
	
	/**
	 * increments y value of point, causing the user to move one space downward on the map IF they are located above row 4 of the map
	 * reveals characters found at locations they have visited
	 * @return character found at map when user goes south
	 */
	public char goSouth() {
		int y = getLocation().y;
		if (y < 4) {
			this.loc.translate(0, +1);
			
			return Map.getInstance().getCharAtLoc(getLocation());
		}
		else {
			System.out.println("You cannot go that way.");
			return (char) 0;
		}
	}
	
	/**
	 * increments x value of point, causing the user to move one space rightward on the map IF they are not located at the rightmost column of the map
	 * reveals characters found at locations they have visited
	 * @return character found at map when user goes east
	 */	
	public char goEast() {
		int x = getLocation().x;
		if (x < 4) {
			this.loc.translate(+1, 0);

			return Map.getInstance().getCharAtLoc(getLocation());
		}
		else {
			System.out.println("You cannot go that way.");
			return (char) 0;
		}
	}
	
	/**
	 * decrements x value of point, causing the user to move one space leftward on the map IF they are not located at the leftmost column of the map
	 * reveals characters found at locations they have visited
	 * @return character found at map when user goes west
	 */	
	public char goWest() {
		int x = getLocation().x;
		if (x > 0) {
			this.loc.translate(-1, 0);

			return Map.getInstance().getCharAtLoc(getLocation());
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

	public void buffAllPokemon() {
		PokemonGenerator pokemonGenerator = new PokemonGenerator();
		for (Pokemon p : pokemon) {
			pokemonGenerator.addRandomBuff(p);
		}
	}

	public void debuffPokemon(int index) {
		PokemonGenerator pokemonGenerator = new PokemonGenerator();
		pokemonGenerator.addRandomDeBuff(getPokemon(index));	
	}
	
	/**
	 * gets pokemon found at index _ of the array list 
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

	public Pokemon removePokemon(int index) {
		return pokemon.remove(index); 
	}
	
	/**
	 * @return trainer's summary (name, hp, inventory, pokemon list, map) 
	 */
	@Override
	public String toString() {
		String mon = "\nMoney: " + money;
		String potn = "\nPotions: " + potions;
		String pokB = "\nPokeballs: " + pokeballs;
		String pokL = "\n" + getPokemonList();
		String map = "\n" + Map.getInstance().mapToString(loc) + "\n";
		return super.toString() + mon + potn + pokB + pokL + map;
	}
}
