package com.example.SqlConnection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Emp {
    @Id
    private int eid;
    private String ename;
    private String technology;
    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getTechnology() {
        return technology;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
    }
    @Override
    public String toString() {
        return "Emp [eid=" + eid + ", ename=" + ename + ", technology=" + technology + "]";
    }

}
