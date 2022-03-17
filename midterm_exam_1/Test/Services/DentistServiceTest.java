package Services;

import Idao.Impl.DentistDaoH2;
import Models.Dentist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DentistServiceTest {
    private static DentistService dentistService = new DentistService(new DentistDaoH2());

    @BeforeAll
    public static void Preregister() {
        Dentist dentist = new Dentist(1L, "Juan", "Carlos");
        dentistService.register(dentist);
        Dentist dentist1 = new Dentist(2L, "Pedro", "Lopez");
        dentistService.register(dentist1);

    }

    @Test
    public void register() {
        Dentist dentist = new Dentist(3L, "Pepe", "El");
        String dentistname = dentistService.register(dentist).getName();
        Assertions.assertEquals(dentistname, "Pepe");
    }

    @Test
    public void search() {
        Dentist dentist = dentistService.search(2L);
        Assertions.assertEquals("Pedro", dentist.getName());
        Assertions.assertEquals("Lopez", dentist.getLastName());
        Assertions.assertEquals(2L, dentist.getLicense_id());
    }

    @Test
    public void delete() {
        dentistService.delete(3L);
        Assertions.assertNull(dentistService.search(3L));

    }

    @Test
    public void searchAll() {
        List<Dentist> allDentistList = dentistService.searchAll();
        Assertions.assertTrue(allDentistList.size() >= 1);
        Assertions.assertNotNull(allDentistList.size());
    }

}
//DROP TABLE DENTISTS