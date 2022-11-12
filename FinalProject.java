import java.util.*;
public class FinalProject extends Matrix {
    public static void main(String []args){
        String input = "Bingo Bongo!!";
        int row = 5;
        int column = 5; 

        addToMatrix(row, column);
        readPassage(input);
    }

    public static void addToMatrix(int rowSize, int colSize){
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                
            }
        }
    }

    public static void readPassage(String input){
        for (int i = 0; i < input.length(); i++){
            System.out.println("Char " + i + " is " + input.charAt(i));

        }
    }

    public static int convertToNumber(String input){
        
    }
}