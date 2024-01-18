import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import UserService from "../services/UserService";
import 'bootstrap/dist/css/bootstrap.min.css';
import { useParams } from "react-router-dom";

const UpdateUser = () => {
    
    // const { eid } = useParams();
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    const eid = location.state.eid;
    const navigate = useNavigate();
    console.log(location.state)
    console.log(eid)
  
    const [user, setUser] = useState({
      eid: '',
      ename: '',
      technology: '',
    });
  
    const [ename, setEname] = useState('');
    const [technology, setTechnology] = useState('');
  
    useEffect(() => {
        if (location.state && location.state.eid) {
          UserService.findUser(location.state.eid)
            .then((response) => {
              setUser(response.data);
            })
            .catch(() => {});
        }
      }, [location.state]);
      
  
    // const handleNameChange = (e) => {
    //   setEname(e.target.value);
    //   setUser({ ...user, ename: e.target.value });
    // };

    const handleNameChange = (e) => {
        setEname((prevEname) => {
          setUser({ ...user, ename: e.target.value });
          return e.target.value; // This value will be used as the new state for ename
        });
      };
      
  
    // const handleTechnologyChange = (e) => {
    //   setTechnology(e.target.value);
    //   setUser({ ...user, technology: e.target.value });
    // };

    const handleTechnologyChange = (e) => {
        setTechnology((prevTechnology) => {
          setUser({ ...user, technology: e.target.value });
          return e.target.value; // This value will be used as the new state for ename
        });
      };
      
  
    const handleSubmit = async (e) => {
      e.preventDefault();
        if(ename == ""){
            setEname(user.ename)
        }
        if(technology == ""){
            setTechnology(user.technology)
        }
      try {
        const updatedUser = { eid: user.eid, ename, technology };
        console.log(updatedUser);
        await UserService.updateUser(updatedUser);
        alert("User Updated Successfully!");
        navigate('/');
      } catch (error) {
        alert("User Update Failed");
      }
    };
  
    return (
      <>
        <form onSubmit={handleSubmit}>
          <label>
            ID :
            <input
              type="text"
              value={user.eid || ''}
              className="form-control"
              placeholder={location.state.eid}
            />
            Name :
            <input
              onChange={handleNameChange}
              type="text"
              value={user.ename || ''}
              className="form-control"
              placeholder={user.ename}
            />
            Technology :
            <input
              onChange={handleTechnologyChange}
              type="text"
              value={user.technology || ''}
              className="form-control"
              placeholder={user.technology}
            />
  
            <input
              type="submit"
              value="Update"
              className="form-control bg-warning"
            />
          </label>
        </form>
      </>
    );
  };
  
  export default UpdateUser;
  