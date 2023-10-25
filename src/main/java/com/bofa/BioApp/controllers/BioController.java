package com.bofa.BioApp.controllers;

import com.bofa.BioApp.models.Bio;
import com.bofa.BioApp.services.BioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("bio")
public class BioController {

    @Autowired
    private BioService bioService;



    @GetMapping
    public List<Bio> getAllBios(){
        return bioService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBioById(@PathVariable int id){
        Optional<Bio> bio = bioService.getBioById(id);

        if (bio.isPresent()){
            return new ResponseEntity<Bio>(bio.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<String>("Unable to find user with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Bio> createNewBio(@RequestBody Bio bio){
        Bio b = bioService.createNewBio(bio);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBio(@PathVariable int id, @RequestBody Bio bio){
        Optional<Bio> b = bioService.getBioById(id);

        if (b.isEmpty()){
            return new ResponseEntity<String>("Unable to find user with id: " + id, HttpStatus.NOT_FOUND);
        }

        Bio updatedB = bioService.update(id, bio);

        return new ResponseEntity<>(updatedB, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBio(@RequestParam int id){
        Optional<Bio> b = bioService.getBioById(id);

        if (b.isEmpty()){
            return new ResponseEntity<String>("Unable to find user with id: " + id, HttpStatus.NOT_FOUND);
        }

        bioService.delete(id);

        return new ResponseEntity<>("Bio with id: " + id + " successfully deleted!", HttpStatus.OK);
    }


}
