import java.awt.*;

public class Battleship extends Ship {
    private boolean[] hitPoints;

    public Battleship(Point start, Point end) {
        super(5, start, end);
        this.hitPoints = new boolean[5];
    }
}
