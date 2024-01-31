import React, { useState, useEffect } from 'react';

 import axios from 'axios'



import "./style.css";
const OrderSummary = () => {
    const [data, setData] = useState([]);
   
 const loadData = async () => {
 const userid = sessionStorage.getItem('userid')
        const response = await axios.get(`http://localhost:8787/details/${userid}`);
        const result = response.data  
        console.log(response)     
 setData(result['data']);
    };
useEffect(() => {
loadData();
}, []); 
return ( 
    <div style={{ marginTop: "2%" }}>
        <table className='table ' style={{
          background : 'linear-gradient(45deg,  #5f2c82, #FF7F7F)' , color:'white'}}>
            
            <thead className='thead-dark'>
                <tr>
                    <th>OrderId</th>    
                    <th>Amount</th>
                    <th>Payment Status</th>
                    
                </tr>
            </thead>
            <tbody>
                {data.map((item, index) => {
                    return (
                        <tr key={item.eventid}>
                            <th scope="row">{index + 1}</th>
                            <td>{item.amount}</td>
                            <td>{item.paymentStatus}</td>
                          
                        </tr>
                    )

                })}

            </tbody>
        </table>
    </div>
  );
};

export default OrderSummary;
