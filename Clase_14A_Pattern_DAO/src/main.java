import dao.PlaneDaoH2;
import entities.Plane;
import services.PlaneService;

public class main {
    public static void main(String[] args) {

        //CREATE A PLANE
        Plane plane1 = new Plane();
        plane1.setBrand("Airbus");
        plane1.setModel("747");
        plane1.setRegistry("AA3445US");
        plane1.setStartDate("22/01/2022");
        plane1.setId(1L);

        //SET PlaneService
        PlaneService services = new PlaneService();
        services.setPlaneDao(new PlaneDaoH2());

        //Save plane
        services.registerPlane(plane1);

        //Find plane
        services.searchPlane(1L);

        //Find ALl
        services.ListAllPlanes();

        //Delete plane
        services.deletePlane(1L);


    }
}
