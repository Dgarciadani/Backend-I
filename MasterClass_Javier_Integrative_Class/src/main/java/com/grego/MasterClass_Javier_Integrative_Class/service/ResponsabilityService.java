package com.grego.MasterClass_Javier_Integrative_Class.service;

import com.grego.MasterClass_Javier_Integrative_Class.model.Responsability;
import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.ResponsabilityDTO;
import com.grego.MasterClass_Javier_Integrative_Class.repository.IResponsabilityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

public class ResponsabilityService implements IResponsabilityService {
    @Autowired
    private IResponsabilityRepository responsabilityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponsabilityDTO saveResponsability(ResponsabilityDTO responsabilityDTO) {
        Responsability responsability = responsabilityRepository.save(convertToEntity(responsabilityDTO));
        return convertToDTO(responsability);
    }

    @Override
    public ResponsabilityDTO findResponsabilityById(Integer id) {
        Responsability responsability = responsabilityRepository.findById(id).orElse(null);
        return convertToDTO(responsability);
    }

    @Override
    public void UpdateResponsability(Integer id, ResponsabilityDTO responsabilityDTO) {
        Responsability responsability = convertToEntity(responsabilityDTO);
        responsability.setId(id);
        responsabilityRepository.save(responsability);

    }

    @Override
    public void deleteResponsability(Integer id) {
        responsabilityRepository.findById(id).ifPresent(responsability -> responsabilityRepository.delete(responsability));
    }



    @Override
    public Set<ResponsabilityDTO> findAll() {
        return responsabilityRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toSet());
    }


    // Mapping
    public ResponsabilityDTO convertToDTO(Responsability responsability) {
        return modelMapper.map(responsability, ResponsabilityDTO.class);
    }

    public Responsability convertToEntity(ResponsabilityDTO responsabilityDTO) {
        return modelMapper.map(responsabilityDTO, Responsability.class);
    }
}
