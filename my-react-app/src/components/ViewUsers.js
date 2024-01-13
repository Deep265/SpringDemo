import React, { useEffect, useState } from "react";
import UserService from "../services/UserService";
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from "react-router-dom";

const ViewUsers = () => {
  const [state, setState] = useState({
    users: [],
  });

  useEffect(() => {
    UserService.getAllUsers()
      .then((response) => {
        setState({
          users: response.data,
        });
      })
      .catch((error) => {
        console.error("Error fetching users:", error);
      });
  }, []); // Empty dependency array means this effect runs once when the component mounts

  console.log(JSON.stringify(state.users));

  let navigate = useNavigate();
  let handleAddUser = () => {
    navigate({pathname : '/adduser'})
  }

  let handleUpdate = (eid) => {
    navigate('/updateuser/'+eid, {state : {"eid" : eid}})
    // {state:{id:1,name:'sabaoon'}}
  }

  let handleDelete = (eid) => {
    navigate({pathname : '/deleteuser', state : {eid}})
  }


  return (
  <>
  <table className="table table-striped text-center">
    <thead className="bg-success">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Technology</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        {state.users.map((user) => {
            return(
            <tr key={user.eid}>
            <td>{user.eid}</td>
            <td>{user.ename}</td>
            <td>{user.technology}</td>
            <td>
                <button className="btn btn-warning" onClick={()=>{handleUpdate(user.eid)}}>Update</button>
                <button className="btn btn-info" onClick={()=>{handleDelete(user.eid)}}>Delete</button>
            </td>
            </tr>
        )}
        )}
    </tbody>
  </table>
  <button className="btn btn-success form-control" onClick={handleAddUser}>Add User</button>
  </> // Your component JSX goes here
  );
}

export default ViewUsers;
