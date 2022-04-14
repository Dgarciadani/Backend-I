package com.grego.MasterClass_Javier_Integrative_Class.service;

import com.grego.MasterClass_Javier_Integrative_Class.model.Person;
import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.PersonDTO;
import com.grego.MasterClass_Javier_Integrative_Class.repository.IPersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    private ModelMapper modelmapper;


    @Override
    public PersonDTO savePerson(PersonDTO personDTO) {
        Person person = modelmapper.map(personDTO, Person.class);
        person = personRepository.save(person);
        return modelmapper.map(person, PersonDTO.class);
    }

    @Override
    public PersonDTO findPersonById(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        return person.map(this::mapToDTO).orElse(null);
    }

    @Override
    public void UpdatePerson(Integer id, PersonDTO personDTO) {
        if (personRepository.findById(id).isPresent()) {
        Person person = modelmapper.map(personDTO, Person.class);
        person.setId(id);
        personRepository.save(person);
    }}

    @Override
    public void deletePerson(Integer id) {
        personRepository.findById(id).ifPresent(person -> personRepository.delete(person));
    }

    @Override
    public Set<PersonDTO> findAll() {
        return personRepository.findAll().stream().map(this::mapToDTO).collect(java.util.stream.Collectors.toSet());
    }

    //--Mappers--
    public PersonDTO mapToDTO(Object object) {
        return modelmapper.map(object, PersonDTO.class);
    }

    public Object mapToEntity(Object object) {
        return modelmapper.map(object, Object.class);
    }
}
