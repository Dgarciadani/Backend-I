package arboles;

public class Arbol {
    private int alto;
    private int horizontal;
    private String color;
    private String tipo;
    private int contador;

    public Arbol(int alto, int horizontal, String color, String tipo) {
        this.alto = alto;
        this.horizontal = horizontal;
        this.color = color;
        this.tipo = tipo;
        contador++;
        System.out.println("Contador:" + contador);
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        horizontal = horizontal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "alto=" + alto +
                ", Horizontal=" + horizontal +
                ", color='" + color + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
