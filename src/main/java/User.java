import java.util.ArrayList;
import java.awt.Point;
public class User {
    private ArrayList<Ship> ships;
    private boolean isAlive;

    public User(ArrayList<Ship> ships) throws IllegalArgumentException {
        if (ships == null || ships.size() == 0) {
            throw new IllegalArgumentException("El usuario debe tener al menos un barco.");
        }
        this.ships = ships;
        this.isAlive = true;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        isAlive = false;
    }

    public boolean attack(Point shotPoint, User user) throws IllegalArgumentException {
        if (shotPoint == null || user == null) {
            throw new IllegalArgumentException("El punto de disparo y el usuario no pueden ser nulos.");
        }

        for (Ship ship : user.getShips()) {
            if (ship.getShot(shotPoint)) {
                return true;
            }
        }

        return false;
    }

    public void getShot(Point shotPoint) {
        for (Ship ship : ships) {
            ship.getShot(shotPoint);
        }
    }
}

