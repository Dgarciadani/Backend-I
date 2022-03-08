import java.util.Map;
import java.util.HashMap;

public class ComputadoraFactory {
    private static Map<String, Computadora> macLigeros = new HashMap<>();

    public Computadora getComputer(String os, int ram, int disco) {
        String clave = "key:" + os + ":" + ram + ":" + disco;
        System.out.println(clave);
        if (!macLigeros.containsKey(clave)) {
            macLigeros.put(clave, new Computadora(os, ram, disco));
            System.out.println("Pc Creada");
            return macLigeros.get(clave);
        }
        System.out.println("Pc Obtenida");
        return macLigeros.get(clave);
    }
}
