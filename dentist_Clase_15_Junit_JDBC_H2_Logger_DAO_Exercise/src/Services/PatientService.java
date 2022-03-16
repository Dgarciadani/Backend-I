package Services;

import Dao.IDao;
import Entities.Patient;

public class PatientService {
    private IDao<Patient> patientIdao;

    public IDao<Patient> getPatientIdao() {
        return patientIdao;
    }

    public void setPatientIdao(IDao<Patient> patientIdao) {
        this.patientIdao = patientIdao;
    }

    public Patient register(Patient patient) {
        return patientIdao.register(patient);
    }

    public Patient search(int i) {
        return patientIdao.search(i);
    }

    public void delete(int i) {
        patientIdao.delete(i);
    }

    public Patient update(int i, Object o) {
        return patientIdao.update(i, o);

    }

}
