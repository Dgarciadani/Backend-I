public class Computadora {
    private int id;
    private String os;
    private int ram;
    private int disco;
    private static int contador;

    public Computadora(String os, int ram, int disco) {
        this.os = os;
        this.ram = ram;
        this.disco = disco;
        contador++;
        System.out.println("contador:" + contador);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", disco=" + disco +
                '}';
    }
}
