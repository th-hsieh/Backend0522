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

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public String addOneCollaborator(CollaboratorsDTO collaboratorsDTO){

        Collaborator collaborator = new Collaborator(

            collaboratorsDTO.getCollaborator_id(),
            collaboratorsDTO.getCollaborator_name(),
            collaboratorsDTO.getEmail(),
            collaboratorsDTO.getPassword()
            //this.passwordEncoder.encode(collaboratorsDTO.getPassword())
        );

        collaboratorsRepository.save(collaborator);
        return collaborator.getCollaborator_name();

    }

    @Override
    public LoginResponse loginCollaborator(LoginDTO loginDTO){
        String msg = "";
        Collaborator collaborator1 = collaboratorsRepository.findByEmail(loginDTO.getEmail());
        if(collaborator1 != null){
            String password = loginDTO.getPassword();
            String encodedPassword = collaborator1.getPassword();
            Boolean isPwdRight;// = passwordEncoder.matches(password, encodedPassword);

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
