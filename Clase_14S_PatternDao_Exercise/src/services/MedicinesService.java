package services;

import dao.Idao;
import entities.Medicines;

import java.util.List;

public class MedicinesService {
    private Idao<Medicines> medicineDao;


    public Idao<Medicines> getMedicineDAO() {
        return medicineDao;
    }

    public void setMedicineDAO(Idao<Medicines> medicineDao) {
        this.medicineDao = medicineDao;
    }

    public Medicines register(Medicines medicines) {
        return medicineDao.register(medicines);
    }

    public void delete(Long id) {
        medicineDao.delete(id);
    }

    public Medicines search(Long id) {
        return medicineDao.search(id);
    }

    public List<Medicines> searchAll() {
        return medicineDao.searchAll();
    }
}
