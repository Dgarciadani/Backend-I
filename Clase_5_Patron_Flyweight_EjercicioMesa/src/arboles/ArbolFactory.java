package arboles;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private static HashMap<String, Arbol> bosque = new HashMap<>();

    public Arbol getArboles(int alto, int ancho, String color, String tipo) {
        String clave = "key:" + alto + ":" + ancho + ":" + color + ":" + tipo;
        System.out.println(clave);

        if (!bosque.containsKey(clave)) {
            bosque.put(clave, new Arbol(alto, ancho, color, tipo));
            System.out.println("Nuevo Arbol Plantado");
            return bosque.get(clave);

        }
        System.out.println("Arbol Encontrado");
        return bosque.get(clave);
    }
}
