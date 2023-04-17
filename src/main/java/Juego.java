import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener configuración de barcos para el Usuario 1
        System.out.println("Configuración de barcos para el Usuario 1");
        ArrayList<Ship> Barcos1 = getBarcosUser(scanner);

        // Obtener configuración de barcos para el Usuario 2
        System.out.println("Configuración de barcos para el Usuario 2");
        ArrayList<Ship> Barcos2 = getBarcosUser(scanner);

        // Crear usuarios
        User user1 = new User(Barcos1);
        User user2 = new User(Barcos2);

       // Iniciar juego
        while (true){
            System.out.println("Turno del usuario 1");
            Point shotPoint1 = getShotUser(scanner);
            boolean isHit = user1.attack(shotPoint1, user2);
            if (isHit) {
                System.out.println("¡Le diste a un barco!");
            } else {
                System.out.println("¡Fallaste!");
            }

            if (!user2.isAlive()) {
                System.out.println("¡El usuario 1 ganó!");
                break;
            }

            System.out.println("Turno del usuario 2");
            Point shotPoint2 = getShotUser(scanner);
            isHit = user2.attack(shotPoint2, user1);
            if (isHit) {
                System.out.println("¡Le diste a un barco!");
            } else {
                System.out.println("¡Fallaste!");
            }

            if (!user1.isAlive()) {
                System.out.println("¡El usuario 2 ganó!");
                break;
            }

        }
    }

    private static Point getShotUser(Scanner scanner) {
        System.out.println("Ingrese las coordenadas de disparo (x,y): ");
        String[] shotCoordinates = scanner.nextLine().split(",");
        Point shotPoint = new Point(Integer.parseInt(shotCoordinates[0]), Integer.parseInt(shotCoordinates[1]));
        return shotPoint;

    }

    private static ArrayList<Ship> getBarcosUser(Scanner scanner) {
        ArrayList<Ship> ships = new ArrayList<>();
        System.out.println("Ingrese la cantidad de barcos: ");
        int shipCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < shipCount; i++) {
            System.out.println("Ingrese las coordenadas de inicio y fin del barco " + (i + 1) + " (x1,y1,x2,y2): ");
            String[] shipCoordinates = scanner.nextLine().split(",");
            Point start = new Point(Integer.parseInt(shipCoordinates[0]), Integer.parseInt(shipCoordinates[1]));
            Point end = new Point(Integer.parseInt(shipCoordinates[2]), Integer.parseInt(shipCoordinates[3]));
            Ship ship = new Ship(start, end);
            ships.add(ship);
        }
        return ships;
    }


}
