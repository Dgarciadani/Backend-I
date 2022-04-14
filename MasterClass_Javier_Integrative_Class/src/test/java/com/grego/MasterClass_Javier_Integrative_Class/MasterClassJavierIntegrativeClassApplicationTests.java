package com.grego.MasterClass_Javier_Integrative_Class;

import com.grego.MasterClass_Javier_Integrative_Class.model.Person;
import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.PersonDTO;
import com.grego.MasterClass_Javier_Integrative_Class.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MasterClassJavierIntegrativeClassApplicationTests {


    @Autowired
    private PersonService personService;
    @Autowired
    private ModelMapper modelMapper;
    @Test
    public void savePerson() {
        Person person = new Person();
        person.setName("Javier");
        person.setSurname("Pate");
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
        Assertions.assertSame(personService.savePerson(personDTO).getName(), person.getName());
        Assertions.assertNotNull(personService.savePerson(personDTO));

    }

    @Test
    public void findById() {
        Assertions.assertNotNull(personService.findPersonById(1));
    }
}
