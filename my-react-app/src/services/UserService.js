import React from "react";
import axios from "axios";

const getAllUsersUrl= " http://localhost:8080/emps ";
const findUserUrl= " http://localhost:8080/getEmp/ ";
const addUserUrl = " http://localhost:8080/addEmp ";
const updateUserUrl = " http://localhost:8080/updateEmp ";
const deleteUserUrl = " http://localhost:8080/deleteEmp ";

class UserService{
    
    getAllUsers(){
        return axios.get(getAllUsersUrl);
    }

    findUser(eid){
        return axios.get(findUserUrl + eid);
    }

    addUser(user){
        return axios.post(addUserUrl, user);
    }

    updateUser(user){
        return axios.put(updateUserUrl, user);
    }

    deleteuser(eid){
        return axios.delete(deleteUserUrl + eid);
    }

}
export default new UserService();