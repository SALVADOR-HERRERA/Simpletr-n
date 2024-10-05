import java.util.Scanner;

public class Simpletrond {

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

        // Load program into memory using hexadecimal input
        for (int counter = 0; counter < limitmemory; counter++) {
            System.out.print(counter + " ? ");
            String hexInput = ent.next(); 
            int instruction = Integer.parseInt(hexInput, 16);  
            memory[counter] = instruction;
            if (instruction == 0x10E0 || instruction == 0) { 
                System.out.println("End of input.");
                break;
            }
        }

        // Execution phase
        while (instructionCounter < limitmemory) {
            int instruction = memory[instructionCounter];

            if (instruction >= 0x3E8 && instruction < 0x44C) {  
                System.out.println("Enter a number: ");
                memory[instruction - 0x3E8] = ent.nextInt();  
            } else if (instruction >= 0x7D0 && instruction < 0x7DC) {  
                memory[instruction - 0x7D0] = ent.nextInt();  
            } else if (instruction >= 0xBB8 && instruction < 0xC2C) {  //3000 to 3100
                accumulator += memory[instruction - 0xBB8]; 
            } else if (instruction >= 0x45C && instruction < 0x7D0) {  
                System.out.println("Value at memory[" + (instruction - 0x3E8) + "] = " + memory[instruction - 0x3E8]);
            } else if (instruction == 0x10E0) { 
                System.out.println("Program halted.");
                ent.close();
                return;
            } else {
                System.out.println("Invalid operation code: " + instruction);
            }

            instructionCounter++;
        }

        ent.close();
    }
}
