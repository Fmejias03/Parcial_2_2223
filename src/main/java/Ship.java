import java.awt.Point;

public class Ship {
    protected int hitPoints;
    protected int size;
    protected Point start;
    protected Point end;
    protected CardinalPoints direction;

    public Ship(int size, Point start, Point end) {
        this.size = size;
        this.hitPoints = 0;
        this.start = start;
        this.end = end;
        if (start.getX() == end.getX()) {
            this.direction = CardinalPoints.NORTH;
        } else if (start.getY() == end.getY()) {
            this.direction = CardinalPoints.EAST;
        } else {
            throw new IllegalArgumentException("Los barcos no están alineados correctamente");
        }
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public void setDirection(CardinalPoints direction) {
        this.direction = direction;
    }

    public boolean isSunk() {
        return hitPoints >= size;
    }

    public boolean getShot(Point shotPoint) {
        if (direction == CardinalPoints.NORTH) {
            if (shotPoint.getX() != start.getX()) {
                return false;
            }
            if (shotPoint.getY() >= start.getY() && shotPoint.getY() <= end.getY()) {
                hitPoints++;
                return true;
            }
        } else if (direction == CardinalPoints.EAST) {
            if (shotPoint.getY() != start.getY()) {
                return false;
            }
            if (shotPoint.getX() >= start.getX() && shotPoint.getX() <= end.getX()) {
                hitPoints++;
                return true;
            }
        } else if (direction == CardinalPoints.SOUTH) {
            if (shotPoint.getX() != start.getX()) {
                return false;
            }
            if (shotPoint.getY() >= end.getY() && shotPoint.getY() <= start.getY()) {
                hitPoints++;
                return true;
            }
        } else if (direction == CardinalPoints.WEST) {
            if (shotPoint.getY() != start.getY()) {
                return false;
            }
            if (shotPoint.getX() >= end.getX() && shotPoint.getX() <= start.getX()) {
                hitPoints++;
                return true;
            }
        }
        return false;
    }
}