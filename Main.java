import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Point; 

public class Main{
    static final Scanner in = new Scanner(System.in);
	static final Random rand = new Random();
	static Pokemon selecPok;
    
    public static void main(String[] args){
        System.out.println("Prof. Oak: Hello there new trainer, what is your name?");
        String yourName = CheckInput.getString(); //get name

        System.out.println("Great to meet you, " + yourName);
        System.out.println("Choose your first pokemon:\n1. Charmander\n2. Bulbasaur\n3. Squirtle");
        int firstPokemon = CheckInput.getIntRange(1,3); //get first pokemon choice

        Pokemon starter = new Charmander(); //predeclare starter pokemon

        switch(firstPokemon){ //actually declare starter pokemon
            case 1: starter = new Charmander(); break;
            case 2: starter = new Bulbasaur(); break;
            case 3: starter = new Squirtle(); break;
        }
        Map m = new Map(); //create map
        int currMapNum = 1;
        m.loadMap(1); //load first map
        Trainer player = new Trainer(yourName, starter, m); //create trainer
        

        while(true){ 
            System.out.println(player.toString());
            int menuChoice = mainMenu();
            char loc = '0';
            Point curr_loc = player.getLocation();
            switch (menuChoice){
                case 1:
                    loc = player.goNorth();
                    break;
                case 2:
                    loc = player.goSouth();
                    break;
                case 3:
                    loc = player.goEast();
                    break;
                case 4:
                    loc = player.goWest();
                    break;
                case 5:
                    System.out.println("Game Over");
                    System.exit(0);
            }
            if (loc == 'n') { 
                System.out.println("There's nothing here...");
            }
            else if (loc == 'i') {
                int rand_item = rand.nextInt(2); //0-1
                switch (rand_item) {
                    case 0:
                        player.receivePokeball();
                        System.out.println("You found a poke ball");
                        break;
                    case 1:
                        player.receivePotion();
                        System.out.println("You found a potion");
                        break;
                }
            }
            else if (loc == 'w') {
                String WPOK_MENU = "\nWhat do you want to do?\n" 
                        + "1. Fight\n"
                        + "2. Use Potion\n"
                        + "3. Throw Poke Ball\n"
                        + "4. Run Away";
                
                Pokemon wild = chooseRandomPokemon();
                System.out.println("A wild " + wild.getName() + " has appeared.\n" + wild.toString() + WPOK_MENU);
                int opt_num = CheckInput.getIntRange(1,4);
                encounterLoop:
                    while (wild.getHp() != 0) {
                        switch (opt_num) {
                            case 1: //fight
                                trainerAttack(player, wild);
                                    
                                break;
                            case 2: //use potion	
                                if (player.hasPotion() == true) {
                                    System.out.println("Which pokemon would you like to heal?");
                                    int pokIndex = CheckInput.getIntRange(1, player.getNumPokemon());
                                    player.usePotion(pokIndex-1);
                                    System.out.println("Pokemon " + player.getPokemon(pokIndex-1) + " has healed from damage!");
                                }
                                else {
                                    System.out.println("You don't have any potions :(");
                                }
                                break;
                            case 3: //throw pokeball
                                if (player.hasPokeball()) {
                                    if (player.catchPokemon(wild) == true) {
                                        System.out.println("You caught " + wild.getName() + "!");			
                                        break encounterLoop;
                                    }	
                                }
                                else {
                                    System.out.println("You don't have any pokeballs :(");
                                }
                                break;
                            case 4: //run away
                                char unchanged = m.getCharAtLoc(player.getLocation());
                                unchanged = 'w';
                                int random_loc = rand.nextInt(4);
                                Loop: //loops while the move is invalid
                                while (true) {
                                    switch (random_loc) {
                                        
                                        case 0:
                                            if (player.goNorth() != (char) 0) {
                                                break Loop;
                                            }
                                            break;
                                        case 1:
                                            if (player.goSouth() != (char) 0) {
                                                break Loop;
                                            }
                                            break;
                                        case 2:
                                            if (player.goEast() != (char) 0) {
                                                break Loop;
                                            }
                                            break;
                                        case 3:
                                            if (player.goWest() != (char) 0) {
                                                break Loop;
                                            }
                                            break;
                                    }
                                    random_loc = rand.nextInt(4);
                                }
                                break encounterLoop;
                        }
                        System.out.println(WPOK_MENU);
                        opt_num = CheckInput.getIntRange(1,4);
                    }
                //if wild pokemon is at 0 hp, then player must decide to catch that pokemon or not
                if (wild.getHp() == 0) {
                    System.out.println("The Pokemon fainted, please move on.");

                }
            }
            else if (loc == 'p') {
                int person = rand.nextInt(4); //0-3
                switch (person) {
                    case 0:
                        System.out.println("You encountered Prof. Oak  testing a potion he created. "
                                + "\nProf. Oak: Hello there, this experiment was a success! Here's the resulting potion, it's great for healing!");
                        player.receivePotion();
                        break;
                    case 1:
                        System.out.println("You ran into Brock attending a hurt pokemon "
                                + "\nBrock:Hi " + player.getName() + "! Would you like to be of assistence in helping this poor creature?"
                                + "\n1. Yes \n2. No"); 
                        int opt_num = CheckInput.getIntRange(1,4);
                        switch (opt_num) {
                            case 1: System.out.println("Brock:Thanks for helping, here's $5"); 
                                player.receiveMoney(5);
                                break;
                            case 2: System.out.println("Brock: Ok, maybe next time?");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("You found Cilan."
                                + "\nCilan: Great to see you! I have an extra poke ball and was searching for someone to give it to, here you go!");
                        player.receivePokeball(); 
                        break;
                    case 3:
                        System.out.println("You bumped into Misty."
                                + "\nMisty: Where's my bike, twerp! \nMisty SMACKS you for 3 damage");
                        player.takeDamage(3);
                        break;
                }
            }
            else if (loc == 'c') {
                store(player);
            }
            else if (loc == 'f') {
				if (currMapNum<3) {
                    currMapNum += 1;
					m.loadMap(currMapNum);
                    m.reveal(m.findStart());
				}
				else {
					 currMapNum = 1;
					 m.loadMap(currMapNum);
                     m.reveal(m.findStart());
				}
			}
            if (loc == 'i' || loc == 'p' || loc == 'w') {
				m.removeCharAtLoc(curr_loc);
			}
        }



    }
	
   /**
    * displays main menu options (list of directions the user may travel)
    * @return user's selected option number
    */
    public static int mainMenu() {
        String MAIN_MENU = "Main Menu:\n"
				+ "1. Go North\n"
				+ "2. Go South\n"
				+ "3. Go East\n"
				+ "4. Go West\n"
				+ "5. Quit";
        System.out.println(MAIN_MENU);
        return CheckInput.getIntRange(1, 5);
    }
	
   /**
    * from an arraylist, a random pokemon is selected (used for generating a wild pokemon)
    * @return randPok
    */		
    public static Pokemon chooseRandomPokemon() {
		ArrayList<Pokemon>wildPok = new ArrayList<Pokemon> (Arrays.asList(new Charmander(), new Squirtle(), new Ponyta(), new Squirtle(), new Staryu(), new Bulbasaur(), new Oddish()));
		int index = rand.nextInt(7);
		Pokemon randPok = wildPok.get(index); 
		return randPok;
    }

    /**
     * attack the given wild Pokemon with a Pokemon from the trainer 
     * @param t the trainer attacking
     * @param wild the wild Pokemon to be attacked
     */
    public static void trainerAttack(Trainer t, Pokemon wild){
        //Let the player choose a Pokemon from the trainer
        System.out.println("Choose a Pokemon\n");
        System.out.println(t.getPokemonList());
        Pokemon userPokemon = t.getPokemon(CheckInput.getIntRange(1, t.getNumPokemon()) - 1); //Get chosen Pokemon
        if (userPokemon.getHp() == 0){ //Check if the chosen Pokemon is fainted. If it is, deal damage to the trainer
            System.out.println(userPokemon.getName() + " is fainted. Please choose another option.");
            int damage = (int)(Math.random() * ((10-5)+1)) + 5;
            t.takeDamage(damage);
            System.out.println(wild.getName() + " attacked " + t.getName() + " for " + damage + " damage!");
            return;
        }

        System.out.println(userPokemon.getName() + ", I choose you!");
        System.out.println(userPokemon.getAttackMenu());

        //Attack the wild Pokemon
        int attackMenu = CheckInput.getIntRange(1,userPokemon.getNumAttackMenuItems());
        switch(attackMenu){
            case 1:
                System.out.println(userPokemon.getBasicMenu());
                int basicAttackChoice = CheckInput.getIntRange(1, userPokemon.getNumBasicMenuItems());
                System.out.println(userPokemon.basicAttack(wild, basicAttackChoice));
                break;
            case 2:
                System.out.println(userPokemon.getSpecialMenu());
                int specialAttackChoice = CheckInput.getIntRange(1, userPokemon.getNumSpecialMenuItems());
                System.out.println(userPokemon.specialAttack(wild, specialAttackChoice));
                break;
        }
        
        //The wild Pokemon attack back
        int randAttackType = rand.nextInt(2); 
        switch (randAttackType){
            case 0:
                int randBasicAttack = rand.nextInt(wild.getNumBasicMenuItems()) + 1;
                wild.basicAttack(userPokemon, randBasicAttack);
                break;
            case 1:
                int randSpecialAttack = rand.nextInt(wild.getNumSpecialMenuItems()) + 1;
                wild.specialAttack(userPokemon, randSpecialAttack);
                break;
        }


    }

    /** This function implements the whole city
     * anytime trainer hits a c on the map, this should be called
     * @param t the trainer
     */
    public static void store(Trainer t){
        String welcomeToCity = "You\'ve entered the city.\nWhere would you like to go?\n1. Store\n2. Pokemon Hospital";
        String storeClerk = "Hello! What can I help you with?\n1. Buy Potions - $5\n2. Buy Poke Balls - $3\n3. Exit";
        String hospitalNurse = "Hello! Welcome to the Pokemon Hospital.\nI\'ll fix your poor pokemon up in a jiffy!\nThere you go! See you again soon.";
        int in;
        boolean moneySpent;


        System.out.println(welcomeToCity); //city entrance message
        in = CheckInput.getIntRange(1,2); //get input
        if(in == 1){ //gone shoppin
            do{
                System.out.println(storeClerk);
                in = CheckInput.getIntRange(1,3);
                if(in == 1){ //so you want a potion...
                    moneySpent = t.spendMoney(5); //try to spend some money
                    if(moneySpent){
                        System.out.println("Here\'s your potion."); //successful acquisition of products
                    } else {
                        System.out.println("Sorry, you\'re too broke for that."); //you need a stimmy bro
                    }
                } else if(in == 2){ //so you want a poke ball...
                    moneySpent = t.spendMoney(3); //try to spend some money
                    if(moneySpent){
                        System.out.println("Here\'s your poke ball."); //successful acquisition of products
                    } else {
                        System.out.println("Sorry, you\'re too broke for that."); //you need a stimmy bro
                    }
                }
            } while(in != 3);
            System.out.println("Thank you, come again soon!");
        } else if(in == 2){ //hospital tiiiiimeeee
            t.healAllPokemon();
            System.out.println(hospitalNurse);
        }
    }
}
