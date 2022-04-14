package com.grego.MasterClass_Javier_Integrative_Class.service;

import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.PersonDTO;
import com.grego.MasterClass_Javier_Integrative_Class.repository.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface IPersonService {

    PersonDTO savePerson(PersonDTO personDTO);

    PersonDTO findPersonById(Integer id);

    void UpdatePerson(Integer id, PersonDTO personDTO);

    void deletePerson(Integer id);

    Set<PersonDTO> findAll();

}
