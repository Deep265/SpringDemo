// import React, { useEffect } from "react";
// import { useLocation, useNavigate } from "react-router-dom";
// import UserService from "../services/UserService";

// let DeleteUser = () => {
//     let location = useLocation();
//     let navigate = useNavigate();

//     useEffect(() => {
//         console.log('Location state:', location.state);
      
//         const userId = location.state?.eid;
      
//         if (userId) {
//           UserService.deleteuser(userId)
//             .then(() => {
//               alert(`User ID ${userId} Deleted Successfully!`);
//               navigate({ pathname: '/' });
//             })
//             .catch((error) => {
//               console.error('Error deleting user:', error);
//               alert(`Failed to delete user with ID ${userId}`);
//               navigate({ pathname: '/' });
//             });
//         } else {
//           alert('Invalid user ID');
//           navigate({ pathname: '/' });
//         }
//       }, [location.state, navigate]);
      
      
      
//     return(
//         <>
        
//         </>
//     );
// }
// export default DeleteUser; 

import React, { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import UserService from "../services/UserService";

let DeleteUser = () => {
  let location = useLocation();
  let navigate = useNavigate();

  useEffect(() => {
    console.log('Location state:', location.state);

    if (location.state && location.state.eid) {
      const userId = location.state.eid;

      UserService.deleteuser(userId)
        .then(() => {
          alert(`User ID ${userId} Deleted Successfully!`);
          navigate({ pathname: '/' });
        })
        .catch((error) => {
          console.error('Error deleting user:', error);
          alert(`Failed to delete user with ID ${userId}`);
          navigate({ pathname: '/' });
        });
     } 
    else {
      alert('Invalid user ID');
      navigate({ pathname: '/' });
    }
  }, [location.state, navigate]);

  return (
    <>
      
    </>
  );
};

export default DeleteUser;
