import java.util.Scanner;

/**
 * Created by Scott on 27/08/2015.
 */
public class connectFour {

    private String[][] playingField =new String[6][7];//7 wide 6 down

    public connectFour(){
        for(int i =0;i<6;i++){
            for(int j = 0;j<7;j++){
                playingField[i][j] = "N";
                System.out.print(playingField[i][j] + " ");
            }
            System.out.print("\n");
        }
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String input = in.nextLine();
            char pos = input.toCharArray()[0];
            int ascii = (int)pos;
            if(ascii>=65 && ascii<= 71){//its X
                int column = ascii -65;
                System.out.println("X , Column: " + column);
                putPlayerOnGrid(column, "X");
            }
            if(ascii>=97 && ascii<= 103){//its O
                int column = ascii-97;
                System.out.println("Y , Column: "+ column);
                putPlayerOnGrid(column,"O");
            }
            printGrid();


        }


    }

    private void printGrid(){
        for(int i =0;i<6;i++){
            for(int j = 0;j<7;j++){
                System.out.print(playingField[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private void putPlayerOnGrid(int position, String playerXorO){
        //check if row is occupied at all
        for(int i=0;i<6;i++){
            String pos = playingField[i][position];
            if(!pos.equals("N")) {
                System.out.println("Placing: " + playerXorO + " above another slot");
                if (i - 1 >= 0) {
                    playingField[i - 1][position] = playerXorO;
                } else {
                    System.out.println("Invalid Move!");
                }
            }
            if(i==5 && pos.equals("N")){
                playingField[i][position] = playerXorO;
            }
        }
        checkWin();
    }

    private void checkWin(){
        String vertLine = "";
        String horizontalLine = "";
        for(int j =0;j<7;j++) {

            if(horizontalLine.contains("OOOO")){
                System.out.println("O WINS!");
            }
            if(horizontalLine.contains("XXXX")){
                System.out.println("X WINS!");
            }
            for(int i =0;i<6;i++) {
                //check for vert win in each column
                vertLine += playingField[i][j];
                if(vertLine.contains("OOOO")){
                    System.out.println("O WINS!");

                }
                if(vertLine.contains("XXXX")){
                    System.out.println("X WINS!");

                }

            }
        }
        //check horizontally for for in a row
        for(int j =0;j<6;j++) {

            if(horizontalLine.contains("OOOO")){
                System.out.println("O WINS!");
            }
            if(horizontalLine.contains("XXXX")){
                System.out.println("X WINS!");
            }
            for(int i =0;i<7;i++) {
                //check for vert win in each column
                horizontalLine += playingField[j][i];
                if(horizontalLine.contains("OOOO")){
                    System.out.println("O WINS!");

                }
                if(horizontalLine.contains("XXXX")){
                    System.out.println("X WINS!");

                }

            }
        }
    }
}
