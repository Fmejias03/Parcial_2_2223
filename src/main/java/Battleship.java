import java.awt.*;

public class Battleship extends Ship {
    private boolean[] isolatedContainers;

    public Battleship(Point start, Point end) {
        super(start, end);
        isolatedContainers = new boolean[3];
        if (start.getX() == end.getX()) {
            direction = CardinalPoints.NORTH;
            isolatedContainers[0] = true;
            isolatedContainers[2] = true;
        } else {
            direction = CardinalPoints.EAST;
            isolatedContainers[1] = true;
            isolatedContainers[2] = true;
        }
    }

    public boolean[] getIsolatedContainers() {
        return isolatedContainers;
    }

    public boolean getShot(Point shotPoint) {
        if (direction == CardinalPoints.NORTH) {
            if (shotPoint.getX() != start.getX()) {
                return false;
            }
            int container = (int) (shotPoint.getY() - start.getY());
            if (container < 0 || container > 4) {
                return false;
            }
            if (!isolatedContainers[container / 2]) {
                return false;
            }
            isolatedContainers[container / 2] = false;
            hitPoints++;
            if (hitPoints == 5) {
                return true;
            }
        } else {
            if (shotPoint.getY() != start.getY()) {
                return false;
            }
            int container = (int) (shotPoint.getX() - start.getX());
            if (container < 0 || container > 4) {
                return false;
            }
            if (!isolatedContainers[container / 2]) {
                return false;
            }
            isolatedContainers[container / 2] = false;
            hitPoints++;
            if (hitPoints == 5) {
                return true;
            }
        }
        return false;
    }

}

