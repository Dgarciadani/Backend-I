package services;

import dao.IDao;
import entities.Plane;

import java.util.List;

public class PlaneService {
    private IDao<Plane> planeDao;


    public IDao<Plane> getPlaneDao() {
        return planeDao;
    }

    public void setPlaneDao(IDao<Plane> planeDao) {
        this.planeDao = planeDao;
    }

    public Plane registerPlane(Plane plane) {
        return planeDao.register(plane);
    }

    public void deletePlane(Long id) {
        planeDao.delete(id);
    }

    public Plane searchPlane(Long id) {
        return planeDao.search(id);
    }

    public List<Plane> ListAllPlanes() {
        return planeDao.findAll();
    }
}
