import { useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";


const Index = () => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [rates, setRates] = useState("");
  const [vaccination, setVaccination] = useState('')
  const [experience, setExperience] = useState('')
  const [category, setCategory] = useState('')
  const [city, setCity] = useState('')
  const [mobileNumber, setMobileNumber] = useState('')
  const [question, setQuestion] = useState('')
  const [answer, setAnswer] = useState('')
  const flag=1;
  const navigate = useNavigate();

  // useEffect(() => {
  //   signinUser()
  //   console.log('getting called')
  // }, [])
  const signupVendor = () => {
    if (name.length == 0) {
      toast.warning("Please enter name");
    } else if (description.length == 0) {
      toast.warning("Please enter description");
    }else if (rates.length == 0) {
        toast.warning("Please enter valid rate");
    } else if (vaccination.length == 0) {
        toast.warning('Please enter vaccination status')
      } else if (experience.length == 0) {
        toast.warning('Please enter experience in years')
      } else if (category.length == 0) {
        toast.warning('Please enter category')
      } else if (city.length == 0) {
        toast.warning('Please enter city')
      } else if (mobileNumber.length == 0) {
        toast.warning('Please enter Mobile number')
      } else if (question.length == 0) {
        toast.warning('Please enter Security Question')
      } else if (answer.length == 0) {
        toast.warning('Please enter Answer')
   
    } else {
      const body = {
        name,
        description,
        rates,
        vaccination,
        experience,
        category,
        city,
        mobileNumber,
        question,
        answer,
        flag,
      };

      // url to make signin api call
      const url = `http://localhost:8787/vendors/signup`;

      // make api call using axios
      axios.post(url, body).then((response) => {
        // get the server result
        const result = response.data;
        console.log(result);
        if (result["status"] == "success") {
          toast.success("Successfully signed up");

          // get the data sent by server
          console.log(result);
          // navigate to home component
          navigate("/vendor-signin");
        } else {
          toast.error("Error");
        }
      });
    }
  };
  return (
      <div>
    
      <h1 className="title" style={{color : 'white', fontWeight : 'bold'}}>Signup</h1>

      <br></br>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Name
              </label>
              <input
                onChange={(e) => {
                  setName(e.target.value);
                }}
                type="text"
                className="form-control"
              />
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                  Description
                </label>
                <input
                  onChange={(e) => {
                    setDescription(e.target.value);
                  }}
                  type="text"
                  className="form-control"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                  Rates
                </label>
                <input
                  onChange={(e) => {
                    setRates(e.target.value);
                  }}
                  type="number"
                  className="form-control"
                />
              </div>
              <div className="mb-3">
              <label htmlFor="" className="label-control">
                vaccination
              </label>
              <input
                onChange={(e) => {
                  setVaccination(e.target.value)
                }}
                type="boolean"
                className="form-control"
                />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
               Experience in Years
              </label>
              <input
                onChange={(e) => {
                  setExperience(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="label-control">
              Category
              </label>
              <input
                onChange={(e) => {
                  setCategory(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
               City
              </label>
              <input
                onChange={(e) => {
                  setCity(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="label-control">
               Mobile Number
              </label>
              <input
                onChange={(e) => {
                  setMobileNumber(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="label-control">
              Security Question
              </label>
              <input
                onChange={(e) => {
                  setQuestion(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="label-control">
               Answer
              </label>
              <input
                onChange={(e) => {
                  setAnswer(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>
              
              <div className="mb-3" style={{color : 'white', fontWeight : 'bold'}}>
                <div>
                  Already have an account?{" "}
                  <Link to="/vendor-signin" style={{color : 'white', fontWeight : 'bold'}}>Signin here.</Link>
                </div>
                <button onClick={signupVendor} className="btn btn-primary">
                  Signup
                </button>
              </div>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
    
  );
}
export default Index;
