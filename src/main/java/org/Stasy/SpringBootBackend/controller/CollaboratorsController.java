package org.Stasy.SpringBootBackend.controller;

import org.Stasy.SpringBootBackend.dto.CollaboratorsDTO;
import org.Stasy.SpringBootBackend.dto.LoginDTO;
import org.Stasy.SpringBootBackend.response.LoginResponse;
import org.Stasy.SpringBootBackend.service.CollaboratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/collaborator")

public class CollaboratorsController {

    @Autowired
    private CollaboratorsService collaboratorsService;
    //這是對到await axios.post("http://localhost:8080/collaborator/save"嗎？
    @PostMapping(path="/save")
    public String saveCollaborator(@RequestBody CollaboratorsDTO collaboratorsDTO){
        String id = collaboratorsService.addOneCollaborator(collaboratorsDTO);
        return id;
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> loginCollaborator(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = collaboratorsService.loginCollaborator(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
