public class ReadHeader {
    private int position;

    public ReadHeader(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void makeMovement(Character movement) {
        if (movement == 'L') {
            position--;
        } else if (movement == 'R') {
            position++;
        }
    }
}
