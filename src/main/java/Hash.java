import java.util.HashMap;
import java.util.Map;
public class Hash {
    private Map<String, Map<Integer, Map<String, Integer>>> tabla1;
    public Hash() {
        this.tabla1 = new HashMap<>();
    }
    public void agregarBarco(String tipo, int numero, String nombre, int nivel) {
        // Si la tabla 1 no tiene una tabla 2 para el tipo de barco, la crea
        if (!tabla1.containsKey(tipo)) {
            tabla1.put(tipo, new HashMap<>());
        }
        Map<Integer, Map<String, Integer>> tabla2 = tabla1.get(tipo);

        // Si la tabla 2 no tiene una tabla 3 para el número del barco, la crea
        if (!tabla2.containsKey(numero)) {
            tabla2.put(numero, new HashMap<>());
        }
        Map<String, Integer> tabla3 = tabla2.get(numero);

        // Agrega el barco a la tabla 3
        tabla3.put(nombre, nivel);
    }
    public Integer obtenerNivel(String tipo, int numero, String nombre) {
        // Obtiene la tabla 2 para el tipo de barco
        Map<Integer, Map<String, Integer>> tabla2 = tabla1.get(tipo);
        if (tabla2 != null) {
            // Obtiene la tabla 3 para el número del barco
            Map<String, Integer> tabla3 = tabla2.get(numero);
            if (tabla3 != null) {
                // Obtiene el nivel del barco por su nombre
                return tabla3.get(nombre);
            }
        }
        return null;
    }
}
