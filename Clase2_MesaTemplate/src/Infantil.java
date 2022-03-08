public class Infantil extends Menu{
    private int cantJuguetes;

    public Infantil(double precioBase) {
        super(precioBase);

    }

    public int getCantJuguetes() {
        return cantJuguetes;
    }

    public void setCantJuguetes(int cantJuguetes) {
        this.cantJuguetes = cantJuguetes;
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase()+getCantJuguetes()*3;
    }

    @Override
    public void armarPedido() {

        System.out.println("Menu Infantil");    }
}
