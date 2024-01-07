package com.example.RestDemo.dao;

import com.example.RestDemo.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


public interface AlienRepo extends JpaRepository<Alien,Integer> {

}
