package com.example.JPADemo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Alien {
    @Id
    private int aid;

    private String aname;

    public void setAid(int aid){
        this.aid = aid;
    }
    public int getAid(){
        return aid;
    }
    public void setAname(String aname){
        this.aname = aname;
    }
    public String getAname(){
        return aname;
    }

    @Override
    public String toString(){
        return "Aid : " + aid + " Aname : " + aname;
    }
}
