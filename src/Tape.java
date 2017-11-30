import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Tape {
    private final String tapeName;
    private ArrayList<Character> tape = new ArrayList<>();

    private ReadHeader readHeader = new ReadHeader(0);

    public Tape(int tapeNummer) {
        tapeName = "Tape " + tapeNummer;
    }

    public void initTape(String word) {
        for (char ch : word.toCharArray()) {
            tape.add(ch);
        }
    }

    public Character readFromTape() {
        return tape.get(readHeader.getPosition());
    }

    public void writeOnTape(Character character, Character movement) {
        tape.set(readHeader.getPosition(), character);
        readHeader.makeMovement(movement);

        if (readHeader.getPosition() < 0) {
            tape.add(0, ' ');
            readHeader.makeMovement('R');
        }
        if (tape.size() <= readHeader.getPosition()) {
            tape.add(' ');
        }
    }

    public void print() {
        if (TuringMachine.infMode) {
            printLong();
        } else {
            printShort();
        }
    }

    private void printShort() {
        String headPosition = "         ";
        for (int i = 0; i < readHeader.getPosition(); i++) {
            headPosition += "   ";
        }
        headPosition += "⬇";
        System.out.println(headPosition);
        System.out.println(tapeName + ": " + Arrays.toString(tape.toArray()));
    }

    public void printLong() {
        String headPosition = "        ";

        for (int i = 0; i < 15; i++) {
            headPosition += "   ";
        }
        headPosition += "⬇";
        System.out.println(headPosition);
        ArrayList<Character> output = new ArrayList<>();
        for (int i = readHeader.getPosition() - 15; i < readHeader.getPosition(); i++) {
            if (i >= 0) {
                output.add(tape.get(i));
            } else {
                output.add(' ');
            }
        }
        for (int i = readHeader.getPosition(); i <= readHeader.getPosition() + 15; i++) {
            if (i < tape.size()) {
                output.add(tape.get(i));
            } else {
                output.add(' ');
            }
        }
        System.out.println(tapeName + ": " + Arrays.toString(output.toArray()));
    }

    public void result() {
        System.out.println(tapeName + ": " + Arrays.toString(tape.toArray()));
        System.out.println("Result 🎉 : " + countZero());
    }

    public int countZero() {
        return Collections.frequency(tape, '0');
    }

    public void resultShort() {
        System.out.println("Result 🎉 : " + countZero());
    }
}
