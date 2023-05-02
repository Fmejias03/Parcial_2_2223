package Grafo;

import java.util.ArrayList;
import java.util.Stack;

public class Grafo {
    private ArrayList<Puerto> puertos;

    public Grafo() {
        this.puertos = new ArrayList<Puerto>();
    }

    public void agregarPuerto(Puerto puerto) {
        puertos.add(puerto);
    }

    public void agregarConexion(Puerto origen, Puerto destino, int distancia) {
        origen.agregarArista(destino, distancia);
    }

    public void barridoProfundidad() {
        Stack<Puerto> pila = new Stack<Puerto>();
        ArrayList<Puerto> visitados = new ArrayList<Puerto>();

        pila.push(puertos.get(0));

        while (!pila.isEmpty()) {
            Puerto actual = pila.pop();
            if (!visitados.contains(actual)) {
                System.out.println(actual);
                visitados.add(actual);
                for (Arista arista : actual.getAristas()) {
                    pila.push(arista.getDestino());
                }
            }
        }
    }

    public ArrayList<Puerto> encontrarCaminoCorto(Puerto origen, Puerto destino) {
        ArrayList<Puerto> camino = new ArrayList<Puerto>();
        ArrayList<Puerto> visitados = new ArrayList<Puerto>();
        ArrayList<Integer> distancias = new ArrayList<Integer>();

        for (int i = 0; i < puertos.size(); i++) {
            visitados.add(null);
            distancias.add(Integer.MAX_VALUE);
        }

        visitados.set(puertos.indexOf(origen), origen);
        distancias.set(puertos.indexOf(origen), 0);

        int indiceActual = puertos.indexOf(origen);

        while (indiceActual != puertos.indexOf(destino)) {
            Puerto actual = puertos.get(indiceActual);

            for (Arista arista : actual.getAristas()) {
                int indiceDestino = puertos.indexOf(arista.getDestino());
                int distancia = distancias.get(indiceActual) + arista.getDistancia();
                if (distancia < distancias.get(indiceDestino)) {
                    visitados.set(indiceDestino, actual);
                    distancias.set(indiceDestino, distancia);
                }
            }
            int distanciaMinima = Integer.MAX_VALUE;
            for (int i = 0; i < distancias.size(); i++) {
                if (!visitados.contains(puertos.get(i)) && distancias.get(i) < distanciaMinima) {
                    distanciaMinima = distancias.get(i);
                    indiceActual = i;
                }
            }
        }
        while (indiceActual != puertos.indexOf(origen)) {
            camino.add(0, puertos.get(indiceActual));
            indiceActual = puertos.indexOf(visitados.get(indiceActual));
        }
        camino.add(0, origen);

        return camino;
    }
}

