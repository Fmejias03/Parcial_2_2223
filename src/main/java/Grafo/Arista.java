package Grafo;

public class Arista {
    private Puerto destino;
    private int distancia;

    public Arista(Puerto destino, int distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public Puerto getDestino() {
        return destino;
    }

    public int getDistancia() {
        return distancia;
    }
}