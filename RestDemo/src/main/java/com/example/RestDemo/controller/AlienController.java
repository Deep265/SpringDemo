package com.example.RestDemo.controller;

import com.example.RestDemo.dao.AlienRepo;
import com.example.RestDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController // for avoid using @ResponseBody every time
public class AlienController {
    @Autowired
    AlienRepo repo;

    // restricts response only to json no other format (Request Contains accept:application/xml)
    @RequestMapping(path="/getAlien/{id}",produces={"application/json"})
    @ResponseBody
    public Optional<Alien> getAlien(@PathVariable("id") int id){
        return repo.findById(id);
    }

    @RequestMapping("/getAll")
    public List<Alien> getAll(){
        return repo.findAll();
    }

    @PostMapping("/addAlien")
    //,consumes={"application/json"}
    public Alien addAlien(@RequestBody Alien alien){
        // RequestBody accepting json
        System.out.println(alien.getId());
        repo.save(alien);
        return alien;
    }

    @DeleteMapping("/deleteAlien/{id}")
    public Optional<Alien> deleteAlien(@PathVariable("id") int id){
        Optional<Alien> temp = repo.findById(id);
        repo.deleteById(id);
        return temp;
    }

    @PutMapping("/updateAlien")
    // Put = saveOrUpdate
    public Optional<Alien> updateAlien(@RequestBody Alien alien){
        repo.save(alien);
        return repo.findById(alien.getId());
    }
}
