import { useState } from "react";
import { Link } from "react-router-dom";
import "./index.css";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";

const USignin = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const signinUser = () => {
    if (email.length == 0) {
      toast.warning("please enter email");
    } else if (password.length == 0) {
      toast.warning("please enter password");
    } else {
      const body = {
        email,
        password,
      };

      // url to make signin api call
      const url = `http://localhost:8787/user/signin`;

      // make api call using axios
      axios.post(url, body).then((response) => {
        // get the server result
        const result = response.data;
        console.log(result);
        if (result["status"] == "success") {
         // toast.success("Welcome to the application");

          // get the data sent by server
          const { userid, name, role } = result["data"];

          // persist the logged in user's information for future use
          sessionStorage["userid"] = userid;
          sessionStorage["role"] = role;
          sessionStorage["loginStatus"] = true;
          if(role == "user"){
          // navigate to home component
        //  window.location.href = "/";
          setTimeout(() => navigate('/',  toast.info(<h6>Welcome User {name}</h6>)), 500)
          }
          else
          setTimeout(() => navigate('/admin',  toast.info(<h6>Welcome Admin {name}</h6>)), 500)
         // window.location.href = "/admin";
        } else {
          toast.error("Invalid user name or password");
        }
      });
    }
  };

  return (
    <div>
      <h1 className="title" style={{color : 'white', fontWeight : 'bold'}}>Signin</h1>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Email address
              </label>
              <input
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Password
              </label>
              <input
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
                type="password"
                className="form-control"
              />
            </div>

            <div className="mb-3 " style={{color : 'white', fontWeight : 'bold'}}>
              <div>
                No account yet? <Link to="/user-signup" style={{color : 'white', fontWeight : 'bold'}}>Signup here</Link>
              </div>
              <button onClick={signinUser} className="btn btn-primary">
                Signin
              </button>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  );
};

export default USignin;
