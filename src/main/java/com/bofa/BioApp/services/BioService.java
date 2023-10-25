package com.bofa.BioApp.services;

import com.bofa.BioApp.models.Bio;
import com.bofa.BioApp.util.MockDB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BioService {
    public List<Bio> getAll() {
        return MockDB.bioList;
    }

    public Optional<Bio> getBioById(int id) {
        return MockDB.bioList.stream()
                        .filter(b -> b.getId() == id)
                        .findAny();

    }

    public Bio createNewBio(Bio bio) {
        Bio b;
        if (bio.getFunFacts() == null){
            b = new Bio(bio.getName(), bio.getAge());
        } else{
            b = new Bio(bio.getName(), bio.getAge(),bio.getFunFacts());
        }

        MockDB.bioList.add(b);

        return b;
    }

    public Bio update(int id, Bio bio) {
        MockDB.bioList.stream()
                .filter(b -> b.getId() == id)
                .forEach(b ->{
                    b.setName(bio.getName());
                    b.setAge(bio.getAge());
                    if (bio.getFunFacts() != null){
                        b.setFunFacts(bio.getFunFacts());
                    } else{
                        b.setFunFacts(new ArrayList<>());
                    }
                });

        return getBioById(id).get();
    }

    public void delete(int id) {
        Bio b = getBioById(id).get();
        MockDB.bioList.remove(b);
    }
}
