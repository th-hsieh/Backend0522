package org.Stasy.SpringBootBackend.controller;

import org.Stasy.SpringBootBackend.dto.CollaboratorsDTO;
import org.Stasy.SpringBootBackend.dto.LoginDTO;
import org.Stasy.SpringBootBackend.response.LoginResponse;
import org.Stasy.SpringBootBackend.service.CollaboratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/collaborator")

public class CollaboratorsController {

    @Autowired
    private CollaboratorsService collaboratorsService;

    public CollaboratorsController(CollaboratorsService collaboratorsService) {
        this.collaboratorsService = collaboratorsService;
    }

//    @PostMapping(path="/save")
//    public String saveCollaborator(@RequestBody CollaboratorsDTO collaboratorsDTO){
//        String id = collaboratorsService.addOneCollaborator(collaboratorsDTO);
//        return id;
//    }

//    @PostMapping(path = "/save")
//    public ResponseEntity<?> saveCollaborator(@RequestBody CollaboratorsDTO collaboratorsDTO) {
//        try {
//            String collaboratorName = collaboratorsService.addOneCollaborator(collaboratorsDTO);
//            return ResponseEntity.ok(collaboratorName);
//        } catch (IllegalAccessException e) {
//            String warningMessage = e.getMessage();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(warningMessage);
//        }
//    }

//    @PostMapping(path = "/save")
//    public ResponseEntity<String> saveCollaborator(@RequestBody CollaboratorsDTO collaboratorsDTO) {
//        try {
//            String collaboratorId = collaboratorsService.addOneCollaborator(collaboratorsDTO);
//            return ResponseEntity.ok(collaboratorId);
//        } catch (IllegalArgumentException e) {
//            String errorMessage = e.getMessage();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
//        }
//    }

    @PostMapping(path = "/save")
    public ResponseEntity<String> saveCollaborator(@RequestBody CollaboratorsDTO collaboratorsDTO) {
        try {
            String collaboratorId = collaboratorsService.addOneCollaborator(collaboratorsDTO);
            return ResponseEntity.ok(collaboratorId);
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
            HttpStatus httpStatus = HttpStatus.resolve(e.hashCode());
            return ResponseEntity.status(httpStatus != null ? httpStatus : HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> loginCollaborator(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = collaboratorsService.loginCollaborator(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
