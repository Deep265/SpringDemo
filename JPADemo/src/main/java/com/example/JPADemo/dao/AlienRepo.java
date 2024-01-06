package com.example.JPADemo.dao;

import com.example.JPADemo.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
    Here we create a interface for saving data to the database
    CurdRepository Already Has its implementation in springboot
    Alt+Click on CrudRepository to check available methods
 */
public interface AlienRepo extends CrudRepository<Alien,Integer> {

    List<Alien> findByAname(String aname);

    // We use question mark because value is from user and its replaced & 1 is for parameter value
    @Query("from Alien where aname=?1 order by aname desc")
    List<Alien> findAnameSorted(String aname);
}
