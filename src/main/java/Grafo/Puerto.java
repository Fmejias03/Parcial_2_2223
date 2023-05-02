package Grafo;

import java.util.ArrayList;
import java.util.List;

public class Puerto {
    private String nombre;
    private ArrayList<Arista> aristas;

    public Puerto(String nombre) {
        this.nombre = nombre;
        this.aristas = new ArrayList<Arista>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void agregarArista(Puerto destino, int distancia) {
        Arista arista = new Arista(destino, distancia);
        aristas.add(arista);
        destino.getAristas().add(arista);
    }

    public String toString() {
        return nombre;
    }
}
