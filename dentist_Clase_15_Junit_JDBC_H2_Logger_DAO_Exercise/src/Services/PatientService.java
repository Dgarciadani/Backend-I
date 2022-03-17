package Services;

import Dao.IDao;
import Models.Patient;

import java.util.List;

public class PatientService {
    private IDao<Patient> patientIdao;

    public IDao<Patient> getPatientIdao() {
        return patientIdao;
    }

    public PatientService(IDao<Patient> patientIdao) {
        this.patientIdao = patientIdao;
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

    public Patient update(int i, Patient patient) {
        return patientIdao.update(i, patient);

    }
    public List<Patient> searchAll(){
        return patientIdao.searchAll();
    }

}
