import java.util.concurrent.TimeUnit;

public class TuringMachine {
    public static boolean stepMode = false;
    public static boolean fastMode = false;
    public static int timeout = 500;
    private Tape tape1 = new Tape(1);
    private Tape tape2 = new Tape(2);
    private Tape tape3 = new Tape(3);

    private int counter = 0;

    public TuringMachine(String word) {
        initTapes(word);

        fromTapeOneToTapeTwo();
        removeMiddle();
        moveTape2Left();
        fromTapeTwoToTapeThree();
        clearTape2();

        printResult();
    }

    private void initTapes(String word) {
        tape1.initTape(word);
        tape2.initTape(" ");
        tape3.initTape(" ");

        printStep();
    }

    private void fromTapeOneToTapeTwo() {
        while (tape1.readFromTape() == '0') {
            tape1.writeOnTape(' ', 'R');
            tape2.writeOnTape('0', 'R');
            printStep();
            counter++;
        }
    }

    private void fromTapeTwoToTapeThree() {
        while (tape1.readFromTape() == '0') {
            while (tape2.readFromTape() == '0') {
                tape3.writeOnTape('0', 'R');
                tape2.writeOnTape('0', 'R');
                printStep();
                counter++;
            }

            tape1.writeOnTape(' ', 'R');
            printStep();
            counter++;

            moveTape2Left();
        }
    }

    private void removeMiddle() {
        if (tape1.readFromTape() == '1') {
            tape1.writeOnTape(' ', 'R');
            printStep();
            counter++;
        }
    }

    private void moveTape2Left() {
        tape2.writeOnTape(' ', 'L');
        printStep();
        counter++;

        while (tape2.readFromTape() == '0') {
            tape2.writeOnTape('0', 'L');
            printStep();
            counter++;
        }

        tape2.writeOnTape(' ', 'R');
        printStep();
        counter++;
    }

    private void clearTape2() {
        while (tape2.readFromTape() == '0') {
            tape2.writeOnTape(' ', 'R');
            printStep();
            counter++;
        }
    }


    private void printStep() {
        if (!fastMode) {
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
