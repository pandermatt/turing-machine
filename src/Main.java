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
            System.out.println("Step Mode 🐢 : " + TuringMachine.stepMode);
        }

        if (args.length > 2) {
            if (args[2].equals("1"))
                TuringMachine.fastMode = true;
            if (args[2].equals("0"))
                TuringMachine.fastMode = false;
            System.out.println("Fast Mode 🐇 : " + TuringMachine.fastMode);
        }

        if (args.length > 3) {
            if (args[3].equals("1"))
                TuringMachine.longPrint = true;
            if (args[3].equals("0"))
                TuringMachine.longPrint = false;
            System.out.println("Long Print ⏩ : " + TuringMachine.longPrint);
        }


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
