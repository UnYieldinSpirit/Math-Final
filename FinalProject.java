import java.util.*;
import java.lang.*;

public class FinalProject extends Matrix {
    public int row;
    public int column;
    //maybe create a method to strictly update the value of the placeholder

    //may need to convert the passage into an array and then read from the array in order to push into the matrix
    public static void main(String []args){
        String input = "Bingo Bongo!!";
        int array[] = new int[input.length()];
    }

    public static void addToMatrix(int rowSize, int colSize, int pos){
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                //matrix[i][j] = readPassage
            }
        }
    }

    public static void readPassage(String input){
        for (int i = 0; i < input.length(); i++){
            System.out.println("Char " + i + " is " + input.charAt(i));

        }
    }

    public int[] arrayContruction(String passage, int boom){
        int passagePosition = 0;
        int[] newArray = new int[100];
        for(int i = 0; i < newArray.length; i++){
            if(i >= passage.length())
                newArray[i] = -1000;
                else
            newArray[i] = charTester(passagePosition, passage);
            passagePosition++;
        }
        
        return newArray;
    }

    public int charTester(int position, String passage){
        //method primarily to separate the different methods for conversion. Don't want them all in one place.
        int convertedNum = 0;
        char character = passage.charAt(position); //current char in passage position is now held
        if(Character.isLowerCase(character)) {
            convertedNum = convertToNumberLower(position, passage);
         } else if(Character.isUpperCase(character)) {
            convertedNum = convertToNumberUpper(position, passage);
         } else
            convertedNum = convertToNumberPunctuation(position, passage);
            
            return convertedNum;
    }

    public int convertToNumberLower(int position, String passage){
        int converted = 0; 
        char mini = passage.charAt(position);

        //very long if statement testing which lowercase it is and converting it into a number
        if (mini == 'a'){
            converted = 26;
        } else if (mini == 'b'){
            converted = 13;
        } else if (mini == 'c'){
            converted = 25;
        } else if (mini == 'd'){
            converted = 12;
        } else if (mini == 'e'){
            converted = 24;
        } else if (mini == 'f'){
            converted = 11;
        } else if (mini == 'g'){
            converted = 23;
        } else if (mini == 'h'){
            converted = 10;
        } else if (mini == 'i'){
            converted = 22;
        } else if (mini == 'j'){
            converted = 9;
        } else if (mini == 'k'){
            converted = 21;
        } else if (mini == 'l'){
            converted = 8;
        } else if (mini == 'm'){
            converted = 20;
        } else if (mini == 'n'){
            converted = 7;
        } else if (mini == 'o'){
            converted = 19;
        } else if (mini == 'p'){
            converted = 6;
        } else if (mini == 'q'){
            converted = 18;
        } else if (mini == 'r'){
            converted = 5;
        } else if (mini == 's'){
            converted = 17;
        } else if (mini == 't'){
            converted = 4;
        } else if (mini == 'u'){
            converted = 16;
        } else if (mini == 'v'){
            converted = 3;
        } else if (mini == 'w'){
            converted = 15;
        } else if (mini == 'x'){
            converted = 2;
        } else if (mini == 'y'){
            converted = 14;
        } else if (mini == 'z'){
            converted = 1;
        }
        return converted;
    }

    public int convertToNumberUpper(int position, String passage){
        int converted = 0;
        char mini = passage.charAt(position);

        //~INCOMPLETE~
        if (mini == 'A'){
            converted = 26;
        } else if (mini == 'B'){
            converted = 13;
        } else if (mini == 'C'){
            converted = 25;
        } else if (mini == 'D'){
            converted = 12;
        } else if (mini == 'E'){
            converted = 24;
        } else if (mini == 'F'){
            converted = 11;
        } else if (mini == 'G'){
            converted = 23;
        } else if (mini == 'H'){
            converted = 10;
        } else if (mini == 'I'){
            converted = 22;
        } else if (mini == 'J'){
            converted = 9;
        } else if (mini == 'K'){
            converted = 21;
        } else if (mini == 'L'){
            converted = 8;
        } else if (mini == 'M'){
            converted = 20;
        } else if (mini == 'N'){
            converted = 7;
        } else if (mini == 'O'){
            converted = 19;
        } else if (mini == 'P'){
            converted = 6;
        } else if (mini == 'Q'){
            converted = 18;
        } else if (mini == 'R'){
            converted = 5;
        } else if (mini == 'S'){
            converted = 17;
        } else if (mini == 'T'){
            converted = 4;
        } else if (mini == 'U'){
            converted = 16;
        } else if (mini == 'V'){
            converted = 3;
        } else if (mini == 'W'){
            converted = 15;
        } else if (mini == 'X'){
            converted = 2;
        } else if (mini == 'Y'){
            converted = 14;
        } else if (mini == 'Z'){
            converted = 27;
        }

        return converted;
    }

    public int convertToNumberPunctuation(int position, String passage){
        int converted = 0;
        char mini = passage.charAt(position);

        if (mini == ' '){
            converted = 0;
        } else if (mini == '.'){
            converted = 57;
        } else if (mini == '!'){
            converted = 56;
        } else if (mini == '?'){
            converted = 53;
        } else if (mini == ';'){
            converted = 55;
        } else if (mini == ':'){
            converted = 52;
        } else if (mini == '"'){
            converted = 58;
        } else if (mini == ','){
            converted = 54;
        }
        return converted;
    }


}