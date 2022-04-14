package com.grego.MasterClass_Javier_Integrative_Class.service;

import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.ResponsabilityDTO;

import java.util.Set;

public interface IResponsabilityService {

    ResponsabilityDTO saveResponsability(ResponsabilityDTO responsabilityDTO);

    ResponsabilityDTO findResponsabilityById(Integer id);

    void updateResponsability(Integer id, ResponsabilityDTO responsabilityDTO);

    void deleteResponsability(Integer id);

    Set<ResponsabilityDTO> findAll();
}
