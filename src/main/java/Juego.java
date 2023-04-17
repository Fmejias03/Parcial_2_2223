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
        boolean isUser1Turn = true;
        while (user1.isAlive() && user2.isAlive()) {
            User currentUser = isUser1Turn ? user1 : user2;
            User otherUser = isUser1Turn ? user2 : user1;
            System.out.println("Turno del usuario " + (isUser1Turn ? "1" : "2"));
            System.out.println("Ingrese las coordenadas de disparo (x,y): ");
            String[] shotCoordinates = scanner.nextLine().split(",");
            Point shotPoint = new Point(Integer.parseInt(shotCoordinates[0]), Integer.parseInt(shotCoordinates[1]));
            if (currentUser.attack(shotPoint, otherUser)) {
                System.out.println("¡Le diste a un barco!");
            } else {
                System.out.println("¡Fallaste!");
            }
            isUser1Turn = !isUser1Turn;
        }

        if (user1.isAlive()) {
            System.out.println("¡El usuario 1 ganó!");
        } else {
            System.out.println("¡El usuario 2 ganó!");
        }




    }
}
