import java.io.Console;


/* This simulation is used to check, how many different combinations can there be
   To put some number of elements from two separate groups.

   For example:
   1st group: 1 element, 2nd group: 3 elements
   1000 0100 0010 0001 - 4 combinations

   1st group: 2 element, 2nd group: 2 elements
   1100 1010 1001 0110 0101 0011 - 6 combinations

 */

public class Simulation {

    // How many elements are in each group
    private static  int G1 = 2;
    private static  int G2 = 3;

    // Number of "digits" or how much places all elements take
    private static  int N = G1 + G2;

    long comboCount = 0;

    // Abstracts some functions
    MyBitOperations bit = new MyBitOperations();

    public static void main(String args[]){
        new Simulation().start();
    }

    private void start() {


        for(G1 = 1; G1 <= 9; G1++){
            for(G2 = 1; G2 <= 9; G2++){
                N = G1 + G2; comboCount = 0;
                printAllCombinations(0, 0, 0, 0);
                System.out.println("Number of combinations " + G1 + ", " + G2 + ": " + comboCount);
            }
        }
    }


    // g1, g2 - how many elements were used already from each group
    // number - the number, which in binary represents the combination
    // digit - which element/digit (in binary) was already set
    private void printAllCombinations(int g1, int g2, int number, int digit){

        // This combination cannot exist, return
        if(g1 > G1 || g2 > G2)
            return;

        // All the elements were added, print the final combination and return
        if(digit == N){
            //printCombination(number, digit);
            comboCount++;
            return;
        }

        // We CAN try to put another element, so we try it
        // By putting one element from the first group and another one,
        // From the second group in the nth digit place
        digit++;

        int g1Number = setBit(number, digit);
        printAllCombinations(g1+1, g2, g1Number, digit);

        int g2Number = clearBit(number, digit);
        printAllCombinations(g1, g2+1, g2Number, digit);
    }

    // number - the number, which in binary represents the combination
    private void printCombination(int number, int numOfDigits){
        String combination = "";
        for(int i = 1; i <= numOfDigits; i++){
            combination += " " + getBit(number, i);
            if(i % 4 == 0){
                combination += " ";
            }
        }
        System.out.println(combination);
    }

    // Bit manipulation functions
    private int setBit(int number, int digit){
        return bit.setBit(number, digit-1);
    }
    private int getBit(int number, int digit){
        return bit.getBit(number, digit-1);
    }
    private int clearBit(int number, int digit){
        return bit.clearBit(number, digit-1);
    }

}
