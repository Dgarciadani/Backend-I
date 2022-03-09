public class CheckFacade {
    private AvionAPI avionAPI;
    private HotelAPI hotelAPI;

    public CheckFacade() {
        this.avionAPI = new AvionAPI();
        this.hotelAPI = new HotelAPI();
    }
    public void buscar(String fechaIda, String fechaVuelta, String origen, String ciudad){
        avionAPI.buscarVuelos(fechaIda,fechaVuelta,origen,ciudad);
        hotelAPI.buscarHoteles(fechaIda,fechaVuelta,ciudad);
    }
}
