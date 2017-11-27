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

    private void initTapes(String word) {
        tape1.initTape(word);
        tape2.initTape(" ");
        tape3.initTape(" ");

        printStep();
    }

    private void q0() {
//        fromTapeOneToTapeTwo
        while (tape1.readFromTape() == '0') {
            System.out.println("q0");
            tape1.writeOnTape(' ', 'R');
            tape2.writeOnTape('0', 'R');
            printStep();
        }

//        removeMiddle
        if (tape1.readFromTape() == '1') {
            System.out.println("q0");
            tape1.writeOnTape(' ', 'R');
            printStep();
        }
    }

    private void q1() {
//        moveTape2Left
        System.out.println("q1");
        tape2.writeOnTape(' ', 'L');
        printStep();

        while (tape2.readFromTape() == '0') {
            System.out.println("q1");
            tape2.writeOnTape('0', 'L');
            printStep();
        }

        System.out.println("q1");
        tape2.writeOnTape(' ', 'R');
        printStep();
    }

    private void q2() {
//        fromTapeTwoToTapeThree
        while (tape1.readFromTape() == '0') {
            while (tape2.readFromTape() == '0') {
                System.out.println("q2");
                tape3.writeOnTape('0', 'R');
                tape2.writeOnTape('0', 'R');
                printStep();
            }

            System.out.println("q2");
            tape1.writeOnTape(' ', 'R');
            printStep();

            q1();
        }
    }

    private void q3() {
//        clearTape2
        while (tape2.readFromTape() == '0') {
            System.out.println("q4");
            tape2.writeOnTape(' ', 'R');
            printStep();
        }
    }


    private void printStep() {
        counter++;
        if (!fastMode) {
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

    private void printResult() {
        System.out.println("Steps: " + counter);
        if (!fastMode) {
            tape1.print();
            tape2.print();
            tape3.print();


            System.out.println("----------------------------------");
            System.out.println("Steps: " + counter);
            tape3.result();
            System.out.println("-------------------------------------");
        } else {
            tape3.resultShort();
        }
    }
}
