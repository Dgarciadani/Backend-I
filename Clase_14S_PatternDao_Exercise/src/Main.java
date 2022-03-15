import dao.DaoMedicineH2;
import entities.Medicines;
import services.MedicinesService;

public class Main {
    public static void main(String[] args) {
        Medicines medicine1 = new Medicines();
        medicine1.setBrand("Elea");
        medicine1.setName("Adermicina");
        medicine1.setId(1L);
        medicine1.setRegistryFDA(2L);
        //SET DAO IMPL

        MedicinesService medicinesService = new MedicinesService();
        medicinesService.setMedicineDAO(new DaoMedicineH2());

        //REGISTER MEDICINE1
        medicinesService.register(medicine1);

        //SEARCH MEDICINE
        medicinesService.search(1L);

        //SHOW ALL
        medicinesService.searchAll();

        //DELETE MEDICINE
        medicinesService.delete(1L);


    }
}
