import java.util.ArrayList;
import java.util.Arrays;

public class Tape {
    private final String bandName;
    private ArrayList<Character> tape = new ArrayList<>();

    private ReadHeader readHeader = new ReadHeader(0);

    public Tape(int bandNummer) {
        bandName = "Band " + bandNummer;
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
        String headPosition = "         ";
        for (int i = 0; i < readHeader.getPosition(); i++) {
            headPosition += "   ";
        }
        headPosition += "⬇";
        System.out.println(headPosition);
        System.out.println(bandName + ": " + Arrays.toString(tape.toArray()));
    }

    public void result() {
        System.out.println(bandName + ": " + Arrays.toString(tape.toArray()));
        System.out.println("Result: " + (tape.size() - 1));
    }

    public void resultShort() {
        System.out.println("Result: " + (tape.size() - 1));
    }
}
