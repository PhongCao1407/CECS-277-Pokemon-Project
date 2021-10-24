import java.awt.Point;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Map {
    
    private char [][] map = new char[5][5];
    private boolean [][] revealed = new boolean[5][5];

    public Map(){

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                this.revealed[j][i] = false; //initialize revealed to false
            }
        }
    }

    public void loadMap(int mapNum){

        String fileName = "Area" + Integer.toString(mapNum) + ".txt";
        File fileIn = new File(fileName);

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

    public char getCharAtLoc(Point p){
        return map[p.y][p.x];
    }

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
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                mapString += this.revealed[i][j];
            }
            mapString += '\n';
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                mapString += this.map[i][j];
            }
            mapString += '\n';
        }
        return mapString;
    }

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

    public void reveal(Point p){
        this.revealed[p.y][p.x] = true;
    }

    public void removeCharAtLoc(Point p){
        this.map[p.y][p.x] = 'n';
    }
}
