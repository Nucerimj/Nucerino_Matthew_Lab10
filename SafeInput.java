import java.util.Scanner;

public class SafeInput {
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt);
            while (!console.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                console.next(); // discard non-integer input
            }
            input = console.nextInt();
        } while (input < low || input > high);
        return input;
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = console.next().toLowerCase();
        } while (!input.equals("y") && !input.equals("n"));
        return input.equals("y");
    }
}
