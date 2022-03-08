public class Clasico extends Menu{


    public Clasico(double precioBase) {
        super(precioBase);
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase();
    }

    @Override
    public void armarPedido() {

        System.out.println("menu Clasico");
    }
}
