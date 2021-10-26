import java.awt.Point;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Map {
    
    private char [][] map = new char[5][5];
    private boolean [][] revealed = new boolean[5][5];

    /**
    * Map constructor
    * initializes revealed array to false
    */
    public Map(){

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                this.revealed[j][i] = false; //initialize revealed to false
            }
        }
    }

    /**
    * Loads in the chosen map from a text file to map array
    * @param mapNum the number of the map to load
    */
    public void loadMap(int mapNum){

        String fileName = "Area" + Integer.toString(mapNum) + ".txt";
        File fileIn = new File(fileName);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                this.revealed[j][i] = false; //initialize revealed to false
            }
        }
        try{
            Scanner fileScan = new Scanner(fileIn);
            int lineNum = 0;
            while(fileScan.hasNextLine()){
                String currentLine = fileScan.nextLine();
                for (int i = 0; i <= 8; i += 2){
                    this.map[lineNum][i/2] = currentLine.charAt(i);
                }
                lineNum += 1;
            }
            fileScan.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }

    /**
    * get character at a location on the map
    * @param p Point coordinate to check
    * @return character at the location
    */
    public char getCharAtLoc(Point p){
        return map[p.y][p.x];
    }

    /**
    * Iterates through map and adds each char to a string
    * if the location is not revealed, an 'x' is shown
    * player location is shown with a '*'
    * @param p Point location of player
    * @return string with map
    */
    public String mapToString(Point p){
        String mapString = "";
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(j == p.x && i == p.y){
                    mapString += '*';
                }else if(this.revealed[i][j] == true){
                    mapString += this.map[i][j];
                }else if(this.revealed[i][j] == false){

                    mapString += 'x';
                    
                }
                mapString += ' ';
            }
            mapString += '\n';
        }
        for(int i = 0; i < 5; i++){                 //do not forget to remove this
            for(int j = 0; j < 5; j++){             //do not forget to remove this
                mapString += this.revealed[i][j];   //do not forget to remove this
            }
            mapString += '\n';                      //do not forget to remove this
        }
        for(int i = 0; i < 5; i++){                 //do not forget to remove this
            for(int j = 0; j < 5; j++){             //do not forget to remove this
                mapString += this.map[i][j];        //do not forget to remove this
            }
            mapString += '\n';                      //do not forget to remove this
        }
        return mapString;
    }

    /**
    * Finds 's' or start location on map
    * @return Point location of start
    */
    public Point findStart(){
        int x = 0;
        int y = 2;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(this.map[i][j] == 's'){
                    x = j;
                    y = i;
                }
            }
        }
        Point start = new Point(x,y);
        this.reveal(start);
        return start;
    }

    /**
    * Sets a location in revealed array to true
    * @param p Point location to reveal
    */
    public void reveal(Point p){
        this.revealed[p.y][p.x] = true;
    }

    /**
    * Replaces a location with 'n' for 'nothing'
    * @param p Point location to remove
    */
    public void removeCharAtLoc(Point p){
        this.map[p.y][p.x] = 'n';
    }
}
