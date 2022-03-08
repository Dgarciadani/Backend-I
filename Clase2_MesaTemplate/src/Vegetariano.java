public class Vegetariano extends Menu{
    private boolean especias;
    private int CantSalsas;

    public Vegetariano(double precioBase) {
        super(precioBase);
    }

    public boolean isEspecias() {
        return especias;
    }

    public void setEspecias(boolean especias) {
        this.especias = especias;
    }

    public int getCantSalsas() {
        return CantSalsas;
    }

    public void setCantSalsas(int cantSalsas) {
        CantSalsas = cantSalsas;
    }

    @Override
    public double calcularPrecio() {
        double precio = getPrecioBase();
        if (isEspecias()) {
            precio *= 1.01;
        }
        if (getCantSalsas() != 0) {
            precio += getCantSalsas() * 3.00;

        }return precio;
    }
    @Override
    public void armarPedido() {

        System.out.println("Menu Vegetariano");;
    }
}
