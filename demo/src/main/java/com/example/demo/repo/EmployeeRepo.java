package com.example.demo.repo;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class EmployeeRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Employee employee){
        String sql = "insert into employee(id, Name, Gender, PhoneNumber) values (?,?,?,?)";

        int rows= template.update(sql, employee.getId(), employee.getName(), employee.getGender(), employee.getPhoneNumber());
        System.out.println(rows + "row/s affected");
    }

    public List<Employee> findAll(){

        return new ArrayList<Employee>();
    }

}
