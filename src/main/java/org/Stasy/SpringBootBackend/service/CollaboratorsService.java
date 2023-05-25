package org.Stasy.SpringBootBackend.service;

import org.Stasy.SpringBootBackend.dto.CollaboratorsDTO;
import org.Stasy.SpringBootBackend.dto.LoginDTO;
import org.Stasy.SpringBootBackend.response.LoginResponse;

public interface CollaboratorsService {

    String addOneCollaborator(CollaboratorsDTO collaboratorsDTO);
    LoginResponse loginCollaborator(LoginDTO loginDTO);

}
