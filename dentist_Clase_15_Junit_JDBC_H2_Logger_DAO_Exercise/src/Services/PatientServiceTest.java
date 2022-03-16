package Services;

import Dao.PatientDaoH2;
import Entities.Address;
import Entities.Patient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PatientServiceTest {
    private static PatientService patientService = new PatientService(new PatientDaoH2());

    @Test
    public void setEntitiesEx() {
        Address address0 = new Address("calle falsa", 123, "Springfield", "Oregon");
        Patient patient0 = new Patient("Marco", "Aurelio", 40814957, new Date(), address0);
        Address address1 = new Address("siempre viva", 742, "Springfield", "Oregon");
        Patient patient1 = new Patient("Julio", "Cesar", 10770346, new Date(), address1);
        Assert.assertNotNull(patientService.register(patient0));
        Assert.assertNotNull(patientService.register(patient1));
    }

    @Test
    public void registerPatient() {
        Address address = new Address("Av.Nuñez", 4738, "Cordoba", "CBA");
        Patient patient = new Patient("Grego", "Garcia", 23498430, new Date(), address);

        Assert.assertNotNull(patientService.register(patient).getId());
    }
    @Test
    public void searchPatient() {
        Patient patient = patientService.search(2);
        System.out.println(patient);
        Assert.assertNotNull(patient);
    }
    @Test
    public void deletePatient() {
        patientService.delete(1);

        Assert.assertNull(patientService.search(1));
    }


}