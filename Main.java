public class Main{
    public static void main(String[] args){
    }

    public static int mainMenu(){
        //TODO
        return 0;
    }

    public static Pokemon chooseRandomPokemon(){
        //TODO
    }

    public static void trainerAttack(Trainer t, Pokemon wild){
        //TODO
        
    }

    /** This function implements the whole city
     * anytime trainer hits a c on the map, this should be called
     * @param t the trainer
     */
    public static void store(Trainer t){
        String welcomeToCity = "You\'ve entered the city.\nWhere would you like to go?\n1. Store\n2. Pokemon Hospital";
        String storeClerk = "Hello! What can I help you with?\n1. Buy Potions - $5\n2. Buy Poke Balls - $3\n3.Exit";
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
