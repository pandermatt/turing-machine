import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String calculation;
        if (args.length > 0) {
            calculation = args[0];
            System.out.println("Your calculation: " + calculation);
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your calculation: ");

            calculation = scanner.next();
        }

        if (args.length > 1) {
            if (args[1].equals("1"))
                TuringMachine.stepMode = true;
            if (args[1].equals("0"))
                TuringMachine.stepMode = false;
            System.out.println("Step Mode 🐢 \t: " + TuringMachine.stepMode);
        }

        if (args.length > 2) {
            if (args[2].equals("1"))
                TuringMachine.fastMode = true;
            if (args[2].equals("0"))
                TuringMachine.fastMode = false;
            System.out.println("Fast Mode 🐇 \t: " + TuringMachine.fastMode);
        }

        if (args.length > 3) {
            if (args[3].equals("1"))
                TuringMachine.infMode = true;
            if (args[3].equals("0"))
                TuringMachine.infMode = false;
            System.out.println("Infinity Tape ⏩\t: " + TuringMachine.infMode);
        }

        if (args.length > 4) {
            TuringMachine.timeout = Integer.parseInt(args[4]);
            System.out.println("Timeout ⏰ \t: " + TuringMachine.timeout);
        }

        TuringMachine.calculation = calculation;

        new TuringMachine(calcToString(calculation));
    }

    public static String calcToString(String calculation) {
        String[] parts = calculation.split("\\*");
        String fPart = parts[0];
        String lPart = parts[1];

        String string = "";
        for (int n = 0; n < Integer.parseInt(fPart); n++) {
            string += "0";
        }
        string += "1";
        for (int z = 0; z < Integer.parseInt(lPart); z++) {
            string += "0";
        }
        return string;
    }
}
