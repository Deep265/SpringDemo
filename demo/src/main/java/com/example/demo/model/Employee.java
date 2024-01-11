<<<<<<< HEAD
package com.example.demo.model;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee {
    private int id;
    private String Name;
    private String Gender;
    private String PhoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Employee() {
    }

    public Employee(int id, String name, String gender, String phoneNumber) {
        this.id = id;
        Name = name;
        Gender = gender;
        PhoneNumber = phoneNumber;
    }
}
=======
package com.example.demo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee {
    private int id;
    private String Name;
    private String Gender;
    private String PhoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Employee() {
    }

    public Employee(int id, String name, String gender, String phoneNumber) {
        this.id = id;
        Name = name;
        Gender = gender;
        PhoneNumber = phoneNumber;
    }
}
>>>>>>> 518d6b0a9aa6584e4105ffc0bbb1c18c0eef7b4e
