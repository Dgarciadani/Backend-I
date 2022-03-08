public  abstract class Menu {
    private double precioBase;
    public Menu( double precioBase){
        this.precioBase = precioBase;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecio();
    public abstract void armarPedido();
}
