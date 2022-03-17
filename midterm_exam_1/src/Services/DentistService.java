package Services;

import Idao.IDao;
import Models.Dentist;

import java.util.List;

public class DentistService {
    private IDao<Dentist> idaoPatient;

    public DentistService(IDao<Dentist> idaoPatient) {
        this.idaoPatient = idaoPatient;
    }

    public Dentist register(Dentist dentist) {
        return idaoPatient.register(dentist);
    }

    public Dentist search(Long id) {
        return idaoPatient.search(id);
    }

    public void delete(Long id) {
        idaoPatient.delete(id);

    }

    public List<Dentist> searchAll() {
        return idaoPatient.searchAll();
    }

}
