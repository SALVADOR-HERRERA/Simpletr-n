import java.util.Scanner;

public class Simpletronc {

    private static final int limitmemory = 1000;
    private static int[] memory = new int[limitmemory];

    public static void main(String[] args) {
        int instructionCounter = 0;
        int accumulator = 0;
        Scanner ent = new Scanner(System.in);

        System.out.println("SIMPLETRON INSTRUCTIONS");
        System.out.println("    \\_/");
        System.out.println("    (* *)");
        System.out.println("   __)#(__");
        System.out.println("   ( )...( )(_)");
        System.out.println("   || |_| ||//");
        System.out.println(">==() | | ()/");
        System.out.println("   _(___)_");
        System.out.println("  [-]   [-]");

        System.out.println("SYMPLETRON WORKING SO HARD (BETTER THAN CHAVA FROM THE ITQ)");

        // Load program into memory
        for (int counter = 0; counter < limitmemory; counter++) {
            System.out.print(counter + " ? ");
            int instruction = ent.nextInt();
            memory[counter] = instruction;
            if (instruction == 4300 || instruction == 0) {
                System.out.println("End of input.");
                break;
            }
        }

        // Execution phase
        while (instructionCounter < limitmemory) {
            int instruction = memory[instructionCounter];

            if (instruction >= 1000 && instruction < 1100) { 
                System.out.println("Enter a number: ");
                memory[instruction - 1000] = ent.nextInt();
            } else if (instruction >= 2000 && instruction < 2100) {
                memory[instruction - 2000] = ent.nextInt();
            } else if (instruction >= 3000 && instruction < 3100) { 
                accumulator += memory[instruction - 3000];
            } else if (instruction >= 3100 && instruction < 3200) {
                accumulator = memory[instruction - 3100] % memory[instructionCounter + 1]; 
                instructionCounter++; 
            } else if (instruction >= 3200 && instruction < 3300) {
                // Exponentiation
                int base = memory[instruction - 3200];
                int exponent = memory[instructionCounter + 1];
                accumulator = (int) Math.pow(base, exponent); 
                instructionCounter++; 
            } else if (instruction >= 1100 && instruction < 2000) {                 
                System.out.println("Value at memory[" + (instruction - 1000) + "] = " + memory[instruction - 1000]);
            } else if (instruction == 4300) { 
                System.out.println("Program halted.");
                ent.close();
                return;
            } else {
                System.out.println("Invalid operation code: " + instruction);
            }

            instructionCounter++;
        }
        
        System.out.println("Enter the total number of numbers to be processed:");
        int totalNumbers = ent.nextInt();
        int largestNumber = Integer.MIN_VALUE;

        for (int i = 0; i < totalNumbers; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            int number = ent.nextInt();
            if (number > largestNumber) {
                largestNumber = number;
            }
        }

        System.out.println("The largest number entered is: " + largestNumber);

        ent.close();
    }
}
