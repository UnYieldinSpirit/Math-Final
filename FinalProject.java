public class FinalProject extends Matrix {
    public int row;
    public int column;
    //may need to convert the passage into an array and then read from the array in order to push into the matrix
    public static void main(String []args){
        //String tester = "Juice Wrld 999!";
        String input = "When a child first catches adults out - when it first walks into his grave little head that adults do not always have divine intelligence, that their judgments are not always wise, their thinking true, their sentences just - his world falls into panic desolation. The gods are fallen and all safety gone. And there is one sure thing about the fall of gods: they do not fall a little; they crash and shatter or sink deeply into green muck. It is a tedious job to build them up again; they never quite shine. And the child's world is never quite whole again. It is an aching kind of growing.";
        String encodedString = "";
        String decodedString = "";
        //row size is 198
        //column size is 3
        //ending number is 80
        double[] passageArray = new double[600];
        double[] encodedArray = new double[600];
        double[] decodedArray = new double[600];
        double[] modifiedEncodedArray = new double[600];

        double[][] passageMatrix = new double[198][3];

        double[][] encoder = new double[3][3];
        double[][] decoder = new double[3][3];

        double[][] encoded = new double[198][3];
        double[][] decoded = new double[198][3];

        setEncodingMatrix(encoder);
        setDecodingMatrix(decoder);
        System.out.println("The original passage is as follows:");
        System.out.println(input);
        System.out.println();

        passageArray = arrayConstruction(input);
        passageMatrix = addToMatrix(passageArray, passageMatrix);
        encoded = encode(encoder, passageMatrix, encoded);
        encodedArray = arrayFromMatrix(encoded, encodedArray); //all values are over 100 and therefore showing up as !'s when converted... try subtracting by 150 and then see if that changes things...'
        modifiedEncodedArray = validateEntries(encodedArray);
        encodedString = passageFromArray(modifiedEncodedArray, encodedString);
        //readArray(modifiedEncodedArray);
        System.out.println("The encoded String is as follows:");
        System.out.println(encodedString);
        System.out.println();

        decoded = decode(decoder, encoded, decoded);
        decodedArray = arrayFromMatrix(decoded, decodedArray);
        decodedString = passageFromArray(decodedArray, decodedString);
        System.out.println("The decoded String is as follows:");
        System.out.println(decodedString);
        
                
    }

    public static void setEncodingMatrix(double[][] matrix){
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 2;
        matrix[1][0] = 1;
        matrix[1][1] = 2;
        matrix[1][2] = 3;
        matrix[2][0] = 3;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
    }

    public static void setDecodingMatrix(double[][] matrix){
        matrix[0][0] = 0.5;
        matrix[0][1] = -0.5;
        matrix[0][2] = 0.5;
        matrix[1][0] = -4;
        matrix[1][1] = 3;
        matrix[1][2] = -1;
        matrix[2][0] = 2.5;
        matrix[2][1] = -1.5;
        matrix[2][2] = 0.5;
    }

    public static double[] validateEntries(double[] array){
        int arrayLength = array.length;
        for(int i = 0; i < arrayLength; i++){
            if(array[i] >= 300){
                array[i] -= 299;
            } else if(array[i] > 250){
                array[i] -= 250;
            } else if(array[i] > 200){
                array[i] = array[i] - 200;
            } else if(array[i] > 150){
                array[i] = array[i] - 150;
            } else if(array[i] > 100){
                array[i] = array[i] - 100;
            } else if(array[i] >= 60){
                array[i] -= 25;
            }
        }
        return array;
    }

    public static void readArray(double[] array){
        int arrayLength = array.length;
        System.out.print("The encoded values are as followed: ");
        for(int i = 0; i < arrayLength; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static double[][] encode(double[][] encoder, double[][] passageMatrix, double[][] finale){
        //matrix multiplication
        for(int i = 0; i < 198; i++){
            for(int j = 0; j < 3; j++){
                finale[i][j] = 0;
                for(int k = 0; k < 3; k++){
                    finale[i][j] += passageMatrix[i][k] * encoder[k][j];
                }
            }
        }
        return finale;        
    }

    public static double[][] decode(double[][] decoder, double[][] needsToBeDecoded, double[][] finale){
        for(int i = 0; i < 198; i++){
            for(int j = 0; j < 3; j++){
                finale[i][j] = 0;
                for(int k = 0; k < 3; k++){
                    finale[i][j] += needsToBeDecoded[i][k] * decoder[k][j];
                }
            }
        }
        return finale;
    }

    public static double[][] addToMatrix(double[] array, double[][] matrix){
        int arraySize = 600;
        int position = 0; //holds position while navigating the array
        for(int i = 0; i < 198; i++){
            for(int j = 0; j < 3; j++){
                matrix[i][j] = array[position];
                if(position < arraySize){
                    position++;                       
                    }
                }                               
            }
            return matrix;
        }

    public static double[] arrayFromMatrix(double[][] matrix, double[] array){
        int arrayPlaceholder = 0;
        for(int i = 0; i < 198; i++){
            for(int j = 0; j < 3; j++){
                array[arrayPlaceholder] = matrix[i][j];
                arrayPlaceholder++;
            }
        }
        return array;
    }

    public static String passageFromArray(double[] array, String finishedPassage){
        for(int i = 0; i < 589; i++){
            if(array[i] == 80){
                break;
            } else
            finishedPassage += convertToChar(array[i]);
        }
        return finishedPassage;
    }

    //reads the passage and separates each character to be read
    public static void readPassage(String input){
        for (int i = 0; i < input.length(); i++){
            System.out.println("Char " + i + " is " + input.charAt(i));
        }
    }
    
    //main array construction method
    public static double[] arrayConstruction(String passage){
        int passagePosition = 0; //holds the position of the passage.
        double[] newArray = new double[600]; //array length is the same as the passage's length
        for(int i = 0; i < newArray.length; i++){
            if(i >= passage.length())
                newArray[i] = 80; //Made a specific value so when it is read the reading stops
                else
            newArray[i] = charTester(passagePosition, passage); //returns the allotted character as a converted number
            passagePosition++; //increase position in the passage
        }
        return newArray; //completed array
    }

    public static double charTester(int position, String passage){
        //method primarily to separate the different methods for conversion. Don't want them all in one place.
        double convertedNum = 0;
        char character = passage.charAt(position); //current char in passage position is now held
        if(Character.isLowerCase(character)) {
            convertedNum = convertToNumberLower(position, passage);
         } else if(Character.isUpperCase(character)) {
            convertedNum = convertToNumberUpper(position, passage);
         } else
            convertedNum = convertToNumberPunctuation(position, passage);
            
            return convertedNum;
    }

    public static int convertToNumberLower(int position, String passage){
        int converted = 0; 
        char mini = passage.charAt(position);

        //very long if statement testing which lowercase it is and converting it into a number
        if (mini == 'a'){
            converted = 48;
        } else if (mini == 'b'){
            converted = 52;
        } else if (mini == 'c'){
            converted = 51;
        } else if (mini == 'd'){
            converted = 50;
        } else if (mini == 'e'){
            converted = 44;
        } else if (mini == 'f'){
            converted = 49;
        } else if (mini == 'g'){
            converted = 45;
        } else if (mini == 'h'){
            converted = 47;
        } else if (mini == 'i'){
            converted = 34;
        } else if (mini == 'j'){
            converted = 43;
        } else if (mini == 'k'){
            converted = 46;
        } else if (mini == 'l'){
            converted = 35;
        } else if (mini == 'm'){
            converted = 36;
        } else if (mini == 'n'){
            converted = 42;
        } else if (mini == 'o'){
            converted = 37;
        } else if (mini == 'p'){
            converted = 39;
        } else if (mini == 'q'){
            converted = 38;
        } else if (mini == 'r'){
            converted = 40;
        } else if (mini == 's'){
            converted = 41;
        } else if (mini == 't'){
            converted = 27;
        } else if (mini == 'u'){
            converted = 29;
        } else if (mini == 'v'){
            converted = 33;
        } else if (mini == 'w'){
            converted = 28;
        } else if (mini == 'x'){
            converted = 32;
        } else if (mini == 'y'){
            converted = 30;
        } else if (mini == 'z'){
            converted = 31;
        }
        return converted;
    }

    public static int convertToNumberUpper(int position, String passage){
        int converted = 0;
        char mini = passage.charAt(position);

        //~INCOMPLETE~
        if (mini == 'A'){
            converted = 1;
        } else if (mini == 'B'){
            converted = 3;
        } else if (mini == 'C'){
            converted = 5;
        } else if (mini == 'D'){
            converted = 2;
        } else if (mini == 'E'){
            converted = 4;
        } else if (mini == 'F'){
            converted = 6;
        } else if (mini == 'G'){
            converted = 8;
        } else if (mini == 'H'){
            converted = 10;
        } else if (mini == 'I'){
            converted = 12;
        } else if (mini == 'J'){
            converted = 14;
        } else if (mini == 'K'){
            converted = 7;
        } else if (mini == 'L'){
            converted = 9;
        } else if (mini == 'M'){
            converted = 11;
        } else if (mini == 'N'){
            converted = 13;
        } else if (mini == 'O'){
            converted = 15;
        } else if (mini == 'P'){
            converted = 17;
        } else if (mini == 'Q'){
            converted = 19;
        } else if (mini == 'R'){
            converted = 24;
        } else if (mini == 'S'){
            converted = 20;
        } else if (mini == 'T'){
            converted = 21;
        } else if (mini == 'U'){
            converted = 16;
        } else if (mini == 'V'){
            converted = 18;
        } else if (mini == 'W'){
            converted = 26;
        } else if (mini == 'X'){
            converted = 25;
        } else if (mini == 'Y'){
            converted = 22;
        } else if (mini == 'Z'){
            converted = 23;
        }

        return converted;
    }

    public static int convertToNumberPunctuation(int position, String passage){
        int converted = 0;
        char mini = passage.charAt(position);

        if (mini == ' '){
            converted = 54;
        } else if (mini == '.'){
            converted = 53;
        } else if (mini == ','){
            converted = 58;
        } else if (mini == '-'){
            converted = 56;
        } else if (mini == ';'){
            converted = 57;
        } else if (mini == ':'){
            converted = 55;
        } else if (mini == '\''){
            converted = 59;
        }
        return converted;
    }

    public static char convertToChar(double number){
        char converted = ' ';
        
        if (number == 54){
            converted = ' ';
        } else if (number == 53){
            converted = '.';
        } else if (number == 58){
            converted = ',';
        } else if (number == 56){
            converted = '-';
        } else if (number == 55){
            converted = ':';
        } else if (number == 57){
            converted = ';';
        } else if (number == 59){
            converted = '\'';
        } else if (number == 1){
            converted = 'A';
        } else if (number == 3){
            converted = 'B';
        } else if (number == 5){
            converted = 'C';
        } else if (number == 2){
            converted = 'D';
        } else if (number == 4){
            converted = 'E';
        } else if (number == 6){
            converted = 'F';
        } else if (number == 8){
            converted = 'G';
        } else if (number == 10){
            converted = 'H';
        } else if (number == 12){
            converted = 'I';
        } else if (number == 14){
            converted = 'J';
        } else if (number == 7){
            converted = 'K';
        } else if (number == 9){
            converted = 'L';
        } else if (number == 11){
            converted = 'M';
        } else if (number == 13){
            converted = 'N';
        } else if (number == 15){
            converted = 'O';
        } else if (number == 17){
            converted = 'P';
        } else if (number == 19){
            converted = 'Q';
        } else if (number == 24){
            converted = 'R';
        } else if (number == 20){
            converted = 'S';
        } else if (number == 21){
            converted = 'T';
        } else if (number == 16){
            converted = 'U';
        } else if (number == 18){
            converted = 'V';
        } else if (number == 26){
            converted = 'W';
        } else if (number == 25){
            converted = 'X';
        } else if (number == 22){
            converted = 'Y';
        } else if (number == 23){
            converted = 'Z';
        } else if (number == 48){
            converted = 'a';
        } else if (number == 52){
            converted = 'b';
        } else if (number == 51){
            converted = 'c';
        } else if (number == 50){
            converted = 'd';
        } else if (number == 44){
            converted = 'e';
        } else if (number == 49){
            converted = 'f';
        } else if (number == 45){
            converted = 'g';
        } else if (number == 47){
            converted = 'h';
        } else if (number == 34){
            converted = 'i';
        } else if (number == 43){
            converted = 'j';
        } else if (number == 46){
            converted = 'k';
        } else if (number == 35){
            converted = 'l';
        } else if (number == 36){
            converted = 'm';
        } else if (number == 42){
            converted = 'n';
        } else if (number == 37){
            converted = 'o';
        } else if (number == 39){
            converted = 'p';
        } else if (number == 38){
            converted = 'q';
        } else if (number == 40){
            converted = 'r';
        } else if (number == 41){
            converted = 's';
        } else if (number == 27){
            converted = 't';
        } else if (number == 29){
            converted = 'u';
        } else if (number == 33){
            converted = 'v';
        } else if (number == 28){
            converted = 'w';
        } else if (number == 32){
            converted = 'x';
        } else if (number == 30){
            converted = 'y';
        } else if (number == 31){
            converted = 'z';
        } else
        converted = '!';

        return converted;
    }
}