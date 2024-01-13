import React, { useState } from "react";
import UserService from "../services/UserService";
import { useNavigate } from "react-router-dom";

let AddUser = () => {
    let navigate = useNavigate();
    let [eid, setEid] = useState('');
    let [ename, setEname] = useState('');
    let [technology, setTechnology] = useState('');

    let handleId = (e) => {
        setEid(e.target.value)
    }

    let handleName = (e) => {
        setEname(e.target.value)
    }

    let handleTechnology = (e) => {
        setTechnology(e.target.value)
    }

    let handleSubmit = (e) => {
        e.preventDefault();

        let user = {eid : eid, ename : ename, technology : technology}
        //alert(JSON.stringify(user))

        UserService.addUser(user).then(()=>{
            alert("User Added Successfully!")
            navigate({pathname : '/'});
        }, ()=>{
            alert("User Creation Failed")
        });
    }

    return(
        <>
        <form onSubmit={handleSubmit}>
            <label>
                ID : <input onChange={handleId} type="text" value={eid} className="form-control"/>
                Name : <input onChange={handleName} type="text" value={ename} className="form-control"/>
                Technology : <input onChange={handleTechnology} type="text" value={technology} className="form-control"/>

                <input type="submit" value="Submit" className="form-control bg-success"/>
            </label>
        </form>
        </>
    );
}
export default AddUser; 