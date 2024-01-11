package com.example.SqlConnection.dao;

import com.example.SqlConnection.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface EmpRepo extends JpaRepository<Emp, Integer> {

}
