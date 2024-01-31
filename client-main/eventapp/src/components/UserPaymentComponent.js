import axios from 'axios'
import React, { useState, useEffect } from 'react'
import { useLocation, useNavigate } from 'react-router-dom'
import './style.css'

const UserPaymentComponent = () => {
  const { state } = useLocation()
  const { venueid, vendorid, eventid, amount } = state
  const [vendor, setVendor] = useState([])
  const [venues, setVenue] = useState([])
  console.log(state)
  const navigate = useNavigate()

  const paymentStatus = () => {
    const url = `http://localhost:8787/events/update/${eventid}`
    axios.post(url).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        navigate('/dashboard')
      }
    })
  }

  const loadData = () => {
    const url1 = `http://localhost:8787/vendors/get/${vendorid}`
    axios.get(url1).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setVendor(result['data'])
      }
    })

    const url2 = `http://localhost:8787/venue/get/${venueid}`
    axios.get(url2).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setVenue(result['data'])
      }
    })
  }
  useEffect(() => {
    loadData()
  }, [])

  return (
    <div className="container">
      <br></br>
      <br></br>
      <h2 className="text-center" style={{ color: 'white' }}>
        {' '}
       <b>Bill</b> {' '}
      </h2>
      {/*<Link to = "/add-vendor" className = "btn btn-primary mb-2" > Add Vendor </Link>*/}
      <table
        className="table table-bordered tablebg"
        style={{
          marginTop: '7%',
          marginLeft: '25%',
          borderWidth: '3px',
          borderColor: 'white',
          borderStyle: 'solid',
          color: '#FFFFFF',
          maxWidth: '50%',
            background : 'linear-gradient(45deg,  #5f2c82,#49a09d)'
        }}
      >
        <thead>
          <th> Services </th>
          <th> Rates </th>
        </thead>
        <tbody>
          <tr key={vendor.vendorId}>
            <td>
              {' '}
              {vendor.name} {vendor.category}{' '}
            </td>
            <td> {vendor.rates}</td>
          </tr>

          <tr key={venues.venueid}>
            <td> {venues.venue_name}</td>
            <td> {venues.price}</td>
          </tr>

          <tr>
            <td>Amount</td> <td>{amount}</td>
          </tr>
        </tbody>
      </table>
      <div>
      <button className='btn btn-success btn-lg btn-block' style={{ color: 'white', marginLeft:'50%', marginTop: '5%' }} onClick={() => paymentStatus()}>
        PAY
      </button>
      </div>
    </div>
  )
}

export default UserPaymentComponent
