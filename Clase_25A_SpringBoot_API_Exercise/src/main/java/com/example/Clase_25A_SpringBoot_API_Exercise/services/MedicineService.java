package com.example.Clase_25A_SpringBoot_API_Exercise.services;


import com.example.Clase_25A_SpringBoot_API_Exercise.dao.Idao;
import com.example.Clase_25A_SpringBoot_API_Exercise.domain.Medicine;

import java.util.List;

public class MedicineService {
    private Idao<Medicine> medicineDao;

    public MedicineService(Idao<Medicine> medicineDao) {
        this.medicineDao = medicineDao;
    }


    public Idao<Medicine> getMedicineDAO() {
        return medicineDao;
    }

    public void setMedicineDAO(Idao<Medicine> medicineDao) {
        this.medicineDao = medicineDao;
    }

    public Medicine register(Medicine medicine) {
        return medicineDao.register(medicine);
    }

    public void delete(int id) {
        medicineDao.delete(id);
    }

    public Medicine search(int id) {
        return medicineDao.search(id);
    }

    public List<Medicine> searchAll() {
        return medicineDao.searchAll();
    }
}
