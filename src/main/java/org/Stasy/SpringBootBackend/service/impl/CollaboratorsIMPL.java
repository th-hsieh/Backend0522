package org.Stasy.SpringBootBackend.service.impl;
import org.Stasy.SpringBootBackend.dto.CollaboratorsDTO;
import org.Stasy.SpringBootBackend.dto.LoginDTO;
import org.Stasy.SpringBootBackend.entity.Collaborator;
import org.Stasy.SpringBootBackend.repository.CollaboratorsRepository;
import org.Stasy.SpringBootBackend.response.LoginResponse;
import org.Stasy.SpringBootBackend.service.CollaboratorsService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollaboratorsIMPL implements CollaboratorsService {

    @Autowired
    private CollaboratorsRepository collaboratorsRepository;

    @Override
    public String addOneCollaborator(CollaboratorsDTO collaboratorsDTO) {
        String email = collaboratorsDTO.getEmail();

        // Check if email already exists in the database
        if (collaboratorsRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("An email address can only be registered for an account.") ;
        }

        Collaborator collaborator = new Collaborator(
                collaboratorsDTO.getCollaborator_id(),
                collaboratorsDTO.getCollaborator_name(),
                email,
                collaboratorsDTO.getPassword()
        );

        collaboratorsRepository.save(collaborator);
        return collaborator.getCollaborator_name();
    }


    @Override
    public LoginResponse loginCollaborator(LoginDTO loginDTO){

        Collaborator collaborator1 = collaboratorsRepository.findByEmail(loginDTO.getEmail());
        if(collaborator1 != null){
            String password = loginDTO.getPassword();
            String encodedPassword = collaborator1.getPassword();
            Boolean isPwdRight;

            if(password.equals(encodedPassword)){
                isPwdRight=true;
            }else{
                isPwdRight=false;
            }

            if(isPwdRight){
                Optional<Collaborator> collaborator = collaboratorsRepository.findOneByEmailAndPassword(loginDTO.getEmail(),loginDTO.getPassword());
                if (collaborator.isPresent()){
                    return new LoginResponse("Login Success",true);
                }else{
                    return new LoginResponse("Login Failed",false);
                }
            }else{
                return new LoginResponse("Password Doesn't Match", false);
            }
        }else {
            return new LoginResponse("Email Doesn't exist", false);
        }
    }

}
