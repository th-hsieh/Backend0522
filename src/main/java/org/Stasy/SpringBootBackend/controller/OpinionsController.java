package org.Stasy.SpringBootBackend.controller;

import org.Stasy.SpringBootBackend.entity.Opinion;
import org.Stasy.SpringBootBackend.repository.OpinionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
@CrossOrigin(origins = "*")
public class OpinionsController {

    @Autowired
    OpinionsRepository opinionsRepository;

    //simply testing
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //view all opinions
    @GetMapping("/opinions")
    public ResponseEntity<List<Opinion>> readOpinions(){
        return new ResponseEntity<List<Opinion>>(opinionsRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/opinions")
    public ResponseEntity<Opinion> createOpinions(@RequestBody Opinion opinion){
        return new ResponseEntity<Opinion>(opinionsRepository.save(opinion),HttpStatus.CREATED);
    }

    //read an opinion by ID
    @GetMapping("/opinions/{id}")
    public ResponseEntity<Opinion> readOpinion(@PathVariable Long id){
        return new ResponseEntity<Opinion>(opinionsRepository.findById(id).get(),HttpStatus.OK);
    }

    //delete an opinion by ID
    @DeleteMapping("/opinions/{id}")
    public ResponseEntity<HttpStatus> deleteOpinion(@PathVariable Long id){
        opinionsRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/opinions")
    public ResponseEntity<Opinion> updateOpinion(@RequestBody Opinion opinion){
        return new ResponseEntity<Opinion>(opinionsRepository.save(opinion),HttpStatus.OK);
    }

}
