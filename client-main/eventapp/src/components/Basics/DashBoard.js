import React from "react";
import { Button , Modal} from 'react-bootstrap';
import "./style.css";
// import "F:/cdac programs/Prroject/tset-front/node_modules/bootstrap/dist/css/bootstrap.min.css";


import OrderSummary from "./OrderSummary";
import {useNavigate,useParams,Link}  from "react-router-dom"

import axios from "axios";
import StarsRating from 'react-star-rate';


//const initialState = {
//  ratings: 0.0,
//  message: " ",
//};

const DashBoard = () => {

  const [value, setValue] = React.useState(0);
  const [show, setShow] = React.useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  const [show1, setShow1] = React.useState(false);
  const handleClose1 = () => setShow1(false);
  const handleShow1 = () => setShow1(true);
  const [fullscreen, setFullscreen] = React.useState(false);
  const [stat, setStat] = React.useState(''); 
  const{message}=stat;
  const navigate = useNavigate();
  const handleInputTextChange = (e) => {
     console.log(e.target.value);
    //const { name, value } = e.target;
    setStat(e.target.value);

  };
  const data=[{value,stat}];
  const submitChanges=(e)=>{
    e.preventDefault();
    addFeedback(); 
  }
 
  const signOut = () => {
    sessionStorage.clear()
    window.location.href = "/";
  }
 

  const addFeedback =async()=>{
    console.log(data);
    const userid = sessionStorage.getItem('userid')
    const ratings =  value  
    const feedback =  stat  
       
    const body = { userid , ratings , feedback} 

    const response=await axios.post('http://localhost:8787/events/feedback',body);

    handleClose1()

   };
  return (
    <> 
     <div className="testdata">
     <br></br>
      <br></br>
     <button className="btn btn-danger" style={{ color: 'white' , position: 'absolute',
                right: 40, }} onClick={() => signOut()}>
        Log Out
      </button>
         <div className="row manageordersfeedbacks2">
             <div className="col manageordersfeedbacks">
                 

        <Button variant="dark" style={{color:'white'}} className="btn1css " onClick={handleShow}> Orders </Button>
        <Modal
        size='lg'
        show={show}
        onHide={handleClose}
        backdrop="static"
        keyboard={false}
        scrollable={true}
        fullscreen={fullscreen}
        >
        <Modal.Header closeButton>
            Previous Orders
        </Modal.Header>
        <Modal.Body>
       <p>
      your orders summary
       </p>
       <OrderSummary/>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="danger" onClick={handleClose}>
            Close
          </Button>
         
        </Modal.Footer>
      </Modal>      
             </div>
             <div className="col manageordersfeedbacks">
             <Button variant="danger" className="btn2css" onClick={handleShow1}> FeedBack </Button>
             </div>
             <Modal
        show={show1}
        onHide={handleClose1}
        backdrop="static"
        keyboard={false}
        scrollable={true}
        >
        <Modal.Header closeButton>
         FeedBack For Services
        </Modal.Header>
        <Modal.Body>
        <form onSubmit={submitChanges}>
        <div>
          <h1 className="textalignment">Rate the event</h1>
            <div style={{ paddingLeft:'28%'}} > 
            {/* <ReactStars
            classNames="styleratings"
            count={5}
            onChange={ RatingChanged}
            size={40}
            isHalf={true}
            ratings={ratings}
            name="ratings"
    emptyIcon={<i className="far fa-star"></i>}
    halfIcon={<i className="fa fa-star-half-alt"></i>}
    fullIcon={<i className="fa fa-star"></i>}
    activeColor="#ffd700"
  /> */}
        <StarsRating
        value={value}
        onChange={value => {
        setValue(value);
        console.log(value);
         }}
       />
 
            </div>     
            <div>
            <div className="mb-3">
            <label htmlFor="exampleFormControlTextarea1" className="form-label">Anything you want us to Improve</label>
           <textarea className="form-control" id="exampleFormControlTextarea1"  rows="3" name="message" value={message} onChange={handleInputTextChange}></textarea>
           </div>
            </div>   
        </div>
        </form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose1}>
            Close
          </Button>
          <Button  type="submit" variant="primary" onClick={addFeedback}>Submit FeedBack </Button>
        </Modal.Footer>
      </Modal>
         </div>
        
        
     </div>
    </>
  );
};

export default DashBoard;
