import java.util.concurrent.TimeUnit;

public class TuringMachine {
    public static boolean stepMode = false;
    public static boolean fastMode = false;
    public static boolean longPrint = false;
    public static int timeout = 500;
    private Tape tape1 = new Tape(1);
    private Tape tape2 = new Tape(2);
    private Tape tape3 = new Tape(3);

    private int counter = 0;

    public TuringMachine(String word) {
        initTapes(word);

        q0();
        q1();
        q2();
        q3();

        printResult();
    }

    /**
     * Init all tree tapes
     *
     * @param word the calculation
     */
    private void initTapes(String word) {
        tape1.initTape(word);
        tape2.initTape(" ");
        tape3.initTape(" ");

        printStep("q0");
    }

    /**
     * Copy all zeros from tape one to tape two, then remove the middle one
     */
    private void q0() {
        while (tape1.readFromTape() == '0') {
            tape1.writeOnTape(' ', 'R');
            tape2.writeOnTape('0', 'R');
            printStep("q0");
        }

        if (tape1.readFromTape() == '1') {
            tape1.writeOnTape(' ', 'R');
            printStep("q0");
        }
    }

    /**
     * move the header of tape two to the start of all the zeros
     */
    private void q1() {
        tape2.writeOnTape(' ', 'L');
        printStep("q1");

        while (tape2.readFromTape() == '0') {
            tape2.writeOnTape('0', 'L');
            printStep("q1");
        }

        tape2.writeOnTape(' ', 'R');
        printStep("q1");
    }

    /**
     * for each zero on tape one copy all zeros from tape two to tape tree
     */
    private void q2() {
        while (tape1.readFromTape() == '0') {
            while (tape2.readFromTape() == '0') {
                tape3.writeOnTape('0', 'R');
                tape2.writeOnTape('0', 'R');
                printStep("q2");
            }

            tape1.writeOnTape(' ', 'R');
            printStep("q2");

            q1();
        }
    }

    /**
     * Finally remove all zeros on tape two
     */
    private void q3() {
        while (tape2.readFromTape() == '0') {
            tape2.writeOnTape(' ', 'R');
            printStep("q4");
        }
    }

    /**
     * Print one step if fast mode is disabled
     *
     * @param zustand
     */
    private void printStep(String zustand) {
        counter++;
        if (!fastMode) {
            System.out.println("Zustand: " + zustand);
            System.out.println("Steps: " + counter);
            tape1.print();
            tape2.print();
            tape3.print();
            System.out.println("-----------------");
            if (stepMode) {
                try {
                    TimeUnit.MILLISECONDS.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Print the result
     */
    private void printResult() {
        System.out.println("\nResult");
        System.out.println("-------------------------------------");
        System.out.println("Steps: " + counter);
        if (!fastMode) {
            tape3.result();
        } else {
            tape3.resultShort();
        }
        System.out.println("-------------------------------------");
    }
}
