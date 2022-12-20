public class FinalProject extends Matrix {
    public int row;
    public int column;
    //may need to convert the passage into an array and then read from the array in order to push into the matrix
    public static void main(String []args){
        //String tester = "Juice Wrld 999!";
        String input = "When a child first catches adults out - when it first walks into his grave little head that adults do not always have divine intelligence, that their judgments are not always wise, their thinking true, their sentences just - his world falls into panic desolation. The gods are fallen and all safety gone. And there is one sure thing about the fall of gods: they do not fall a little; they crash and shatter or sink deeply into green muck. It is a tedious job to build them up again; they never quite shine. And the child's world is never quite whole again. It is an aching kind of growing.";
        String encodedString = "";
        String decodedString = "";
        
        double[] passageArray = new double[600];
        double[] encodedArray = new double[600];
        double[] decodedArray = new double[600];
        double[] modifiedEncodedArray = new double[600];

        double[][] passageMatrix = new double[85][7];

        double[][] encoder = new double[7][7];
        double[][] decoder = new double[7][7];

        double[][] encoded = new double[85][7];
        double[][] decoded = new double[85][7];

        setEncodingMatrix(encoder);
        setDecodingMatrix2(decoder);

        System.out.println("The original passage is as follows:");
        System.out.println(input);
        System.out.println();

        passageArray = arrayConstruction(input);
        passageMatrix = addToMatrix(passageArray, passageMatrix);
        encoded = encode(encoder, passageMatrix, encoded);
        encodedArray = arrayFromMatrix(encoded, encodedArray); //all values are over 100 and therefore showing up as !'s when converted... try subtracting by 150 and then see if that changes things...'
        modifiedEncodedArray = validateEntries(encodedArray);
        modifiedEncodedArray = roundArray(modifiedEncodedArray);
        encodedString = passageFromArray(modifiedEncodedArray, encodedString);
        //readArray(modifiedEncodedArray);
        //readArray(encodedArray);
        //readArray(passageArray);

        System.out.println("The encoded String is as follows:");
        System.out.println(encodedString);
        System.out.println();

        decoded = decode(decoder, encoded, decoded);
        decoded = round(decoded);
        decodedArray = arrayFromMatrix(decoded, decodedArray);
        decodedString = passageFromArray(decodedArray, decodedString);
        System.out.println("The decoded String is as follows:");
        System.out.println(decodedString);
        System.out.println();
        //System.out.println("Decoded Array:");
        //readArray(decodedArray);
        System.out.println();
        System.out.println();
        System.out.println("Encoded Array:");
        readArray(modifiedEncodedArray);
        System.out.println();
        System.out.println();
        System.out.println();
        //readArray(decodedArray);  
        //readArray(encodedArray);
        //readMatrix(decoded); 
    }

    public static void readMatrix(double[][] matrix){
        int counter = 0;
        for(int i = 0; i < 85; i++){
            for(int j = 0; j < 7; j++){
            System.out.print(matrix[i][j] + " ");
            counter++;
            }
        }
        System.out.println("Total values: " +counter);
    }
    

    public static void setEncodingMatrix(double[][] matrix){
        matrix[0][0] = 3;
        matrix[0][1] = 8;
        matrix[0][2] = 1;
        matrix[0][3] = 8;
        matrix[0][4] = 3;
        matrix[0][5] = 4;
        matrix[0][6] = 9;
        matrix[1][0] = 2;
        matrix[1][1] = 1;
        matrix[1][2] = 5;
        matrix[1][3] = 5;
        matrix[1][4] = 7;
        matrix[1][5] = 6;
        matrix[1][6] = 5;
        matrix[2][0] = 5;
        matrix[2][1] = 2;
        matrix[2][2] = 3;
        matrix[2][3] = 0;
        matrix[2][4] = 5;
        matrix[2][5] = 3;
        matrix[2][6] = 8;
        matrix[3][0] = 1;
        matrix[3][1] = 1;
        matrix[3][2] = 0;
        matrix[3][3] = 1;
        matrix[3][4] = 0;
        matrix[3][5] = 8;
        matrix[3][6] = 0;
        matrix[4][0] = 3;
        matrix[4][1] = 2;
        matrix[4][2] = 0;
        matrix[4][3] = 3;
        matrix[4][4] = 5;
        matrix[4][5] = 5;
        matrix[4][6] = 1;
        matrix[5][0] = 1;
        matrix[5][1] = 5;
        matrix[5][2] = 9;
        matrix[5][3] = 4;
        matrix[5][4] = 1;
        matrix[5][5] = 0;
        matrix[5][6] = 4;
        matrix[6][0] = 0;
        matrix[6][1] = 8;
        matrix[6][2] = 1;
        matrix[6][3] = 4;
        matrix[6][4] = 1;
        matrix[6][5] = 6;
        matrix[6][6] = 0;    
    }

    public static void setDecodingMatrix(double[][] matrix){
        matrix[0][0] = 0.04008515;
        matrix[0][1] = -0.28611190;
        matrix[0][2] = -0.00646985;
        matrix[0][3] = 0.12432003;
        matrix[0][4] = 0.39258530;
        matrix[0][5] = 0.18224166;
        matrix[0][6] = -0.23029107;
        matrix[1][0] = -0.02986025;
        matrix[1][1] = -0.04258175;
        matrix[1][2] = 0.07102624;
        matrix[1][3] = -0.09184901;
        matrix[1][4] = -0.02432663;
        matrix[1][5] = -0.01555808;
        matrix[1][6] = 0.16971299;
        matrix[2][0] = -0.05786074;
        matrix[2][1] = 0.01137932;
        matrix[2][2] = 0.00193334;
        matrix[2][3] = 0.03461496;
        matrix[2][4] = -0.00201961;
        matrix[2][5] = 0.11260073;
        matrix[2][6] = -0.01824243;
        matrix[3][0] = 0.11787302;
        matrix[3][1] = -0.01748128;
        matrix[3][2] = -0.17688311;
        matrix[3][3] = 0.04827268;
        matrix[3][4] = 0.14803012;
        matrix[3][5] = 0.07339599;
        matrix[3][6] = -0.16038119;
        matrix[4][0] = 0.07867589;
        matrix[4][1] = 0.13956828;
        matrix[4][2] = 0.05314409;
        matrix[4][3] = -0.18235584;
        matrix[4][4] = -0.00827126;
        matrix[4][5] = -0.10166034;
        matrix[4][6] = 0.13634380;
        matrix[5][0] = -0.01601224;
        matrix[5][1] = 0.04327187;
        matrix[5][2] = 0.01404084;
        matrix[5][3] = 0.11490704;
        matrix[5][4] = -0.06453610;
        matrix[5][5] = -0.03000995;
        matrix[5][6] = 0.02761991;
        matrix[6][0] = 0.05928664;
        matrix[6][1] = 0.08174082;
        matrix[6][2] = 0.07208172;
        matrix[6][3] = 0.00316388;
        matrix[6][4] = -0.20915623;
        matrix[6][5] = -0.07744535;
        matrix[6][6] = 0.01277224;
    }

    public static void setDecodingMatrix2(double[][] matrix){
        matrix[0][0] = 15799.0/394136.0;
        matrix[0][1] = -112767.0/394136.0;
        matrix[0][2] = -1275.0/197068.0;
        matrix[0][3] = 48999.0/394136.0;
        matrix[0][4] = 38683.0/98534.0;
        matrix[0][5] = 17957.0/98534.0;
        matrix[0][6] = -45383.0/197068.0;
        matrix[1][0] = -11769.0/394136.0;
        matrix[1][1] = -16783.0/394136.0;
        matrix[1][2] = 13997.0/197068.0;
        matrix[1][3] = -36201.0/394136.0;
        matrix[1][4] = -2397.0/98534.0;
        matrix[1][5] = -1533.0/98534.0;
        matrix[1][6] = 33445.0/197068.0;
        matrix[2][0] = -22805.0/394136.0;
        matrix[2][1] = 4485.0/394136.0;
        matrix[2][2] = 381.0/197068.0;
        matrix[2][3] = 13643.0/394136.0;
        matrix[2][4] = -199.0/98534.0;
        matrix[2][5] = 11095.0/98534.0;
        matrix[2][6] = -3595.0/197068.0;
        matrix[3][0] = 23229.0/197068.0;
        matrix[3][1] = -3445.0/197068.0;
        matrix[3][2] = -17429.0/98534.0;
        matrix[3][3] = 9513.0/197068.0;
        matrix[3][4] = 7293.0/49267.0;
        matrix[3][5] = 3616.0/49267.0;
        matrix[3][6] = -15803.0/98534.0;
        matrix[4][0] = -31009.0/394136.0;
        matrix[4][1] = 55009.0/394136.0;
        matrix[4][2] = 10473.0/197068.0;
        matrix[4][3] = -71873.0/394136.0;
        matrix[4][4] = -815.0/98534.0;
        matrix[4][5] = -10017.0/98534.0;
        matrix[4][6] = 26869.0/197068.0;
        matrix[5][0] = -6311.0/394136.0;
        matrix[5][1] = 17055.0/394136.0;
        matrix[5][2] = 2767.0/197068.0;
        matrix[5][3] = 45289.0/394136.0;
        matrix[5][4] = -6359.0/98534.0;
        matrix[5][5] = -2957.0/98534.0;
        matrix[5][6] = 5443.0/197068.0;
        matrix[6][0] = 23367.0/394136.0;
        matrix[6][1] = 32217.0/394136.0;
        matrix[6][2] = 14205.0/197068.0;
        matrix[6][3] = 1247.0/394136.0;
        matrix[6][4] = -20609.0/98534.0;
        matrix[6][5] = -7631.0/98534.0;
        matrix[6][6] = 2517.0/197068.0;
    }

    public static double[] validateEntries(double[] array){
        int arrayLength = array.length;
        for(int i = 0; i < arrayLength; i++){
            if(array[i] >= 10000){
                array[i] -= 9950;
            } else if(array[i] > 9500){
                array[i] -= 5450;
            } else if(array[i] > 9000){
                array[i] -= 5450;
            } else if(array[i] > 8500){
                array[i] -= 5450;
            } else if(array[i] > 8000){
                array[i] -= 5450;
            } else if(array[i] > 7500){
                array[i] -= 5450;
            } else if(array[i] > 7000){
                array[i] -= 5450;
            } else if(array[i] > 6500){
                array[i] -= 5450;
            } else if(array[i] > 6000){
                array[i] -= 5450;
            } else if(array[i] > 5500){
                array[i] -= 5450;
            } else if(array[i] > 5000){
                array[i] -= 4950;
            }  else if(array[i] > 4500){
                array[i] -= 4450;
            } else if(array[i] > 4000){
                array[i] -= 3950;
            } else if(array[i] > 3500){
                array[i] -= 3450;
            } else if(array[i] > 3000){
                array[i] -= 2950;
            } else if(array[i] > 2500){
                array[i] -= 2450;
            } else if(array[i] > 2000){
                array[i] -= 1950;
            } else if(array[i] > 1500){
                array[i] -= 1450;
            } else if(array[i] > 1000){
                array[i] -= 999;
            } else if(array[i] > 950){
                array[i] -= 900;
            } else if(array[i] > 900){
                array[i] -= 850;
            } else if(array[i] > 850){
                array[i] -= 800;
            } else if(array[i] > 800){
                array[i] -= 750;
            } else if(array[i] > 750){
                array[i] -= 700;
            } else if(array[i] > 700){
                array[i] -= 650;
            } else if(array[i] > 650){
                array[i] -= 600;
            } else if(array[i] > 600){
                array[i] -= 550;
            } else if(array[i] > 550){
                array[i] -= 500;
            } else if(array[i] > 500){
                array[i] -= 450;
            } else if(array[i] > 450){
                array[i] -= 400;
            } else if(array[i] > 400){
                array[i] -= 350;
            } else if(array[i] > 350){
                array[i] -= 300;
            } else if(array[i] >= 300){
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
        int counter = 0;
        int arrayLength = array.length;
        for(int i = 0; i < arrayLength; i++){
            System.out.print(array[i] + " ");
            counter++;
        }
        System.out.println("The total value count is " +counter);
    }

    public static double[][] encode(double[][] encoder, double[][] passageMatrix, double[][] finale){
        //matrix multiplication
        for(int i = 0; i < 85; i++){
            for(int j = 0; j < 7; j++){
                for(int k = 0; k < 7; k++){
                    finale[i][j] += passageMatrix[i][k] * encoder[k][j];
                }
            }
        }
        return finale;        
    }

    public static double[][] decode(double[][] decoder, double[][] needsToBeDecoded, double[][] finale){
        for(int i = 0; i < 85; i++){
            for(int j = 0; j < 7; j++){
                finale[i][j] = 0;
                for(int k = 0; k < 7; k++){
                    finale[i][j] += needsToBeDecoded[i][k] * decoder[k][j];
                    finale[i][j] = Math.round(finale[i][j]);
                    /*if(finale[i][j] % 5 == 0){
                        finale[i][j] = finale[i][j];
                    } else if (finale[i][j] % 5 < 2.5 && finale[i][j] % 5 != 0){
                        finale[i][j] = finale[i][j] - (finale[i][j] % 5);
                    } else if (finale[i][j] % 5 > 2.5 && finale[i][j] % 5 != 0) {
                        finale[i][j] = finale[i][j] + (5 - finale[i][j] % 5);
                    }*/
                    //finale[i][j] = 5*(Math.floor(Math.abs(finale[i][j]/5)));
                    //finale[i][j] = Math.round(finale[i][j]);
            }
        }
    }
        return finale;
    }

    public static double[][] round(double[][] finale){
        for(int i = 0; i < 85; i++){
            for(int j = 0; j < 7; j++){
                    if(finale[i][j] % 5 == 0){
                        finale[i][j] = finale[i][j];
                    } else if (finale[i][j] % 5 < 2.5 && finale[i][j] % 5 != 0){
                        finale[i][j] = finale[i][j] - (finale[i][j] % 5);
                    } else if (finale[i][j] % 5 > 2.5 && finale[i][j] % 5 != 0) {
                        finale[i][j] = finale[i][j] + (5 - finale[i][j] % 5);
                    }
            }
        }
        return finale;
    }

    public static double[] roundArray(double[] finale){
        for(int i = 0; i < finale.length; i++){
            if(finale[i] % 5 == 0){
                finale[i] = finale[i];
            } else if (finale[i] % 5 < 2.5 && finale[i] % 5 != 0){
                finale[i] = finale[i] - (finale[i] % 5);
            } else if (finale[i] % 5 > 2.5 && finale[i] % 5 != 0) {
                finale[i] = finale[i] + (5 - finale[i] % 5);
            }
        }
        return finale;
    }

    public static double[][] addToMatrix(double[] array, double[][] matrix){
        int arraySize = 600;
        int position = 0; //holds position while navigating the array
        for(int i = 0; i < 85; i++){
            for(int j = 0; j < 7; j++){
                if(position < arraySize){
                matrix[i][j] = array[position];
                }
                if(position < arraySize){
                    position++;                       
                    }
                }                               
            }
            return matrix;
        }

    public static double[] arrayFromMatrix(double[][] matrix, double[] array){
        int arrayPlaceholder = 0;
        for(int i = 0; i < 85; i++){
            for(int j = 0; j < 7; j++){
                array[arrayPlaceholder] = matrix[i][j];
                arrayPlaceholder++;
            }
        }
        return array;
    }

    public static String passageFromArray(double[] array, String finishedPassage){
        for(int i = 0; i < 589; i++){
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
            converted = 5;
        } else if (mini == 'b'){
            converted = 10;
        } else if (mini == 'c'){
            converted = 15;
        } else if (mini == 'd'){
            converted = 20;
        } else if (mini == 'e'){
            converted = 25;
        } else if (mini == 'f'){
            converted = 30;
        } else if (mini == 'g'){
            converted = 35;
        } else if (mini == 'h'){
            converted = 40;
        } else if (mini == 'i'){
            converted = 45;
        } else if (mini == 'j'){
            converted = 50;
        } else if (mini == 'k'){
            converted = 55;
        } else if (mini == 'l'){
            converted = 60;
        } else if (mini == 'm'){
            converted = 65;
        } else if (mini == 'n'){
            converted = 70;
        } else if (mini == 'o'){
            converted = 75;
        } else if (mini == 'p'){
            converted = 80;
        } else if (mini == 'q'){
            converted = 85;
        } else if (mini == 'r'){
            converted = 90;
        } else if (mini == 's'){
            converted = 95;
        } else if (mini == 't'){
            converted = 100;
        } else if (mini == 'u'){
            converted = 105;
        } else if (mini == 'v'){
            converted = 110;
        } else if (mini == 'w'){
            converted = 115;
        } else if (mini == 'x'){
            converted = 120;
        } else if (mini == 'y'){
            converted = 125;
        } else if (mini == 'z'){
            converted = 130;
        }
        return converted;
    }

    public static int convertToNumberUpper(int position, String passage){
        int converted = 0;
        char mini = passage.charAt(position);

        //~INCOMPLETE~
        if (mini == 'A'){
            converted = 135;
        } else if (mini == 'B'){
            converted = 140;
        } else if (mini == 'C'){
            converted = 145;
        } else if (mini == 'D'){
            converted = 150;
        } else if (mini == 'E'){
            converted = 155;
        } else if (mini == 'F'){
            converted = 160;
        } else if (mini == 'G'){
            converted = 165;
        } else if (mini == 'H'){
            converted = 170;
        } else if (mini == 'I'){
            converted = 175;
        } else if (mini == 'J'){
            converted = 180;
        } else if (mini == 'K'){
            converted = 185;
        } else if (mini == 'L'){
            converted = 190;
        } else if (mini == 'M'){
            converted = 195;
        } else if (mini == 'N'){
            converted = 200;
        } else if (mini == 'O'){
            converted = 205;
        } else if (mini == 'P'){
            converted = 210;
        } else if (mini == 'Q'){
            converted = 215;
        } else if (mini == 'R'){
            converted = 220;
        } else if (mini == 'S'){
            converted = 225;
        } else if (mini == 'T'){
            converted = 230;
        } else if (mini == 'U'){
            converted = 235;
        } else if (mini == 'V'){
            converted = 240;
        } else if (mini == 'W'){
            converted = 245;
        } else if (mini == 'X'){
            converted = 250;
        } else if (mini == 'Y'){
            converted = 255;
        } else if (mini == 'Z'){
            converted = 260;
        }

        return converted;
    }

    public static int convertToNumberPunctuation(int position, String passage){
        int converted = 0;
        char mini = passage.charAt(position);

        if (mini == ' '){
            converted = 265;
        } else if (mini == '.'){
            converted = 270;
        } else if (mini == ','){
            converted = 275;
        } else if (mini == '-'){
            converted = 280;
        } else if (mini == ';'){
            converted = 285;
        } else if (mini == ':'){
            converted = 290;
        } else if (mini == '\''){
            converted = 295;
        }
        return converted;
    }

    public static char convertToChar(double number){
        char converted = ' ';
        
        if (number == 265){
            converted = ' ';
        } else if (number == 270){
            converted = '.';
        } else if (number == 275){
            converted = ',';
        } else if (number == 280){
            converted = '-';
        } else if (number == 285){
            converted = ':';
        } else if (number == 290){
            converted = ';';
        } else if (number == 295){
            converted = '\'';
        } else if (number == 135){
            converted = 'A';
        } else if (number == 140){
            converted = 'B';
        } else if (number == 145){
            converted = 'C';
        } else if (number == 150){
            converted = 'D';
        } else if (number == 155){
            converted = 'E';
        } else if (number == 160){
            converted = 'F';
        } else if (number == 165){
            converted = 'G';
        } else if (number == 170){
            converted = 'H';
        } else if (number == 175){
            converted = 'I';
        } else if (number == 180){
            converted = 'J';
        } else if (number == 185){
            converted = 'K';
        } else if (number == 190){
            converted = 'L';
        } else if (number == 195){
            converted = 'M';
        } else if (number == 200){
            converted = 'N';
        } else if (number == 205){
            converted = 'O';
        } else if (number == 210){
            converted = 'P';
        } else if (number == 215){
            converted = 'Q';
        } else if (number == 220){
            converted = 'R';
        } else if (number == 225){
            converted = 'S';
        } else if (number == 230){
            converted = 'T';
        } else if (number == 235){
            converted = 'U';
        } else if (number == 240){
            converted = 'V';
        } else if (number == 245){
            converted = 'W';
        } else if (number == 250){
            converted = 'X';
        } else if (number == 255){
            converted = 'Y';
        } else if (number == 260){
            converted = 'Z';
        } else if (number == 5){
            converted = 'a';
        } else if (number == 10){
            converted = 'b';
        } else if (number == 15){
            converted = 'c';
        } else if (number == 20){
            converted = 'd';
        } else if (number == 25){
            converted = 'e';
        } else if (number == 30){
            converted = 'f';
        } else if (number == 35){
            converted = 'g';
        } else if (number == 40){
            converted = 'h';
        } else if (number == 45){
            converted = 'i';
        } else if (number == 50){
            converted = 'j';
        } else if (number == 55){
            converted = 'k';
        } else if (number == 60){
            converted = 'l';
        } else if (number == 65){
            converted = 'm';
        } else if (number == 70){
            converted = 'n';
        } else if (number == 75){
            converted = 'o';
        } else if (number == 80){
            converted = 'p';
        } else if (number == 85){
            converted = 'q';
        } else if (number == 90){
            converted = 'r';
        } else if (number == 95){
            converted = 's';
        } else if (number == 100){
            converted = 't';
        } else if (number == 105){
            converted = 'u';
        } else if (number == 110){
            converted = 'v';
        } else if (number == 115){
            converted = 'w';
        } else if (number == 120){
            converted = 'x';
        } else if (number == 125){
            converted = 'y';
        } else if (number == 130){
            converted = 'z';
        } else
        converted = '!';

        return converted;
    }
}