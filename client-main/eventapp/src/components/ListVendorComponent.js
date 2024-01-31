import axios from 'axios'
import React, {useState, useEffect} from 'react'

import { useNavigate } from 'react-router-dom'


import { useParams } from 'react-router-dom'
import './style.css'

const ListVendorComponent = () => {

    const {id} = useParams();
    console.log(id);
    const navigate = useNavigate()
    const [vendors, setVendors] = useState([])
    //const { state } = useLocation()
    //const { eventid } = state

 const getAllVendors = () => {

        const url = `http://localhost:8787/vendors/details`
        axios.get(url).then((response) => {
            const result = response.data
          if (result['status'] == 'success') {
           setVendors(result['data'])
           }
        })
    }

 const vendorsSave = (sid) => {
   const uid = sessionStorage.getItem('userid')
   const body = {
      id, sid, uid
   }   
   const url = `http://localhost:8787/events/add`
   axios.post(url,body).then((response) => {
            const result = response.data
            const eventid = result.data.eventid
            const amount = result.data.amount

  if (result['status'] == 'success') {
           navigate("/user-payment", {state:{venueid:id, vendorid:sid, eventid:eventid, amount:amount}})
           }
        })
    

 }


// const loadBlogDetails = () => {
//    const { id } = state
//    const url = `${URL}/blog/details/${id}`
//    axios.get(url).then((response) => {
//      const result = response.data
//      if (result['status'] == 'success') {
//        setBlog(result['data'])
//      }
//    })
//  }
//const loadVendorImage = () => {

//    const { vendorId } = state
//    const url = `http://localhost:8787/attachment/${vendorId}`
//    axios.get(url).then((response) => {
//      const result = response.data
//      if (result['status'] == 'success') {
//        setVendors(result['data'])
//      }
//    })
//  }


//const navigateTo =(vendorId) => {
//    navigate('/vendor-detailsid',{state:{ID:vendorId}})
    
//}
    useEffect(() => {

        getAllVendors();
    }, [])

    return (
        <div className = "container testdata">
            <h2 className = "text-center"> Vendor Services </h2>
            {/*<Link to = "/add-vendor" className = "btn btn-primary mb-2" > Add Vendor </Link>*/}
            <table className="table table-bordered   tablebg" style={{
          borderWidth: '3px',
          borderColor: 'black',
          borderStyle: 'solid',
          color: '#FFFFFF' ,
          maxWidth : '80%',
          background : 'linear-gradient(45deg,  #5f2c82,#49a09d)'
        }}>
                <thead>
                    <th> Vendor Id </th>
                    <th> Name </th>
                    <th> Experience </th>
                    <th> Contact </th>
                    <th> Rates </th>
                    <th> Category </th> 
                     <th> City </th>
                    <th> Vaccination </th>
                    <th> Add Service </th>
                </thead>
                <tbody>
                    
                             {vendors.map(
                            vendor =>
                            <tr key = {vendor.vendorId}>
                                <td> {vendor.vendorId} </td>
                                <td> {vendor.name}</td>
                                <td>{vendor.experience}</td>
                                <td>{vendor.mobileNumber}</td>
                                <td>{vendor.rates}</td>
                                <td>{vendor.category}</td>
                                <td>{vendor.city}</td>
                                <td>{vendor.vaccination}</td>
                                <td><button className="btn btn-outline-danger" style={{color:'white'}}  onClick={ ()=>vendorsSave(vendor.vendorId)} 
                             >ADD</button>
                               </td>

                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListVendorComponent