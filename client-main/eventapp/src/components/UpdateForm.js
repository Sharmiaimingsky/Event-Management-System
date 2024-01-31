import React from 'react'
import { useState, useEffect } from 'react'
import axios from 'axios'
import { useNavigate, useLocation } from 'react-router'
import './Vendor.css'

const UpdateForm = () => {
  const { state } = useLocation()
  const { Id } = state
  const [vendor, setVendor] = useState([])
  const navigate = useNavigate()
  const [email,setEmail] =useState('')
  const [name,setName] =useState('')
  const [rates,setRates] =useState('')
  const [experience,setExperience] =useState('')
  const [category,setCategory] =useState('')
  const [city,setCity] =useState('')
  const [description,setDescription] =useState('')
const[mobileNumber,setMobileNumber] = useState('')
  const [id,setId] =useState('')
  

  const loadAddVendor = (Id) => {
    const url = `http://localhost:8787/Admin/details/${Id}`
    axios.post(url).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setVendor(result['data'])
        //setCity=result.data.city
        //setExperience=result.data.experience
        //setCity=result.data.city
      }
    })
  }

  const navigateToBack = () => {
    navigate('/vendor-signin')
  }

  const signOut = () => {
    sessionStorage.clear()
    navigate('/vendor-signin')
  }
  useEffect(() => {
    loadAddVendor(Id)
  },[])

  const submitUpdate =(id) => {
    setId(vendor.vendorId);
    const body = {
        rates,
        experience,
        city,
        mobileNumber,
    }

   

    const url =`http://localhost:8787/vendors/edit/${id}`

    axios.post(url,body).then((response)=> {
        const result = response.data
        if (result['status'] === 'success')
            signOut()
    })
  }

  return (
    <div>
      <br></br>
      <br></br>
      <button className="btn btn-primary" style={{ color: 'white', position: 'absolute', left: '30%' }} onClick={() => signOut()}>
        Log Out
      </button>

      <h2 style={{ 'text-align': 'center','color':'white' }}><b>UPDATE</b></h2>

      <form
      className="bgc"
      style={{
        textAlign: 'cent',
        marginTop: '5%',
        marginLeft: '30%',
        marginRight: '40%',
        color: '#FFFFFF',
        paddingLeft : '10px',
        paddingRight : '-500px',
          background : 'linear-gradient(45deg,  #5f2c82,#49a09d)'
      }}>

      <div className="form-group row">
          <label htmlFor="Email" className="col-sm-2 col-form-label">
            ID
          </label>
          <div className="col-sm-10">
            <input
            readOnly
            style={{ color: 'red', fontWeight: 'bold' }}
            onChange={(e) => {
                setId(e.target.value)
              }}
              type="text"
              className="form-control-plaintext"
              id="Email"
              defaultValue={vendor.vendorId}
            />
          </div>
          </div>
        <div className="form-group row">
          <label htmlFor="Name" className="col-sm-2 col-form-label">
            Name
          </label>
          <div className="col-sm-10">
            <input
             style={{ color: 'red', fontWeight: 'bold' }}
            readOnly
            onChange={(e) => {
                setName(e.target.value)
              }}
              type="text"
              className="form-control-plaintext"
              id="Name"
              defaultValue={vendor.name}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="Rates" className="col-sm-2 col-form-label">
            Rates
          </label>
          <div className="col-sm-10">
            <input
             style={{ color: 'white', fontWeight: 'bold' }}
            onChange={(e) => {
                setRates(e.target.value)
              }}
              type="text"
              
              className="form-control-plaintext"
              id="Rates"
              defaultValue={vendor.rates}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="Description" className="col-sm-2 col-form-label">
            Description
          </label>
          <div className="col-sm-10">
            <input
             style={{ color: 'red', fontWeight: 'bold' }}
            readOnly
            onChange={(e) => {
                setDescription(e.target.value)
              }}
              type="text"
              
              className="form-control-plaintext"
              id="Description"
              defaultValue={vendor.description}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="Experience" className="col-sm-2 col-form-label">
            Experience
          </label>
          <div className="col-sm-10">
            <input
             style={{ color: 'white', fontWeight: 'bold' }}
             onChange={(e) => {
                setExperience(e.target.value)
              }}
              type="text"
           
              className="form-control-plaintext"
              id="Experience"
              defaultValue={vendor.experience}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="Category" className="col-sm-2 col-form-label">
            Category
          </label>
          <div className="col-sm-10">
            <input
             style={{ color: 'red', fontWeight: 'bold' }}
            readOnly
             onChange={(e) => {
                setCategory(e.target.value)
              }}
              type="text"
              
              className="form-control-plaintext"
              id="Category"
              defaultValue={vendor.category}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="City" className="col-sm-2 col-form-label">
            City
          </label>
          <div className="col-sm-10">
            <input
             style={{ color: 'white', fontWeight: 'bold' }}
             onChange={(e) => {
                setCity(e.target.value)
              }}
              type="text"
              
              className="form-control-plaintext"
              id="City"
              defaultValue={vendor.city}
            />
          </div>
        </div>

        <div className="form-group row">
          <label htmlFor="mobile" className="col-sm-2 col-form-label">
            mobile
          </label>
          <div className="col-sm-10">
            <input
             style={{ color: 'red', fontWeight: 'bold' }}
             onChange={(e) => {
                setMobileNumber(e.target.value)
              }}
              type="text"
              readOnly
              className="form-control-plaintext"
              id="City"
              defaultValue={vendor.mobileNumber}
            />
          </div>
        </div>
      </form>

      <br></br>
      <br></br>

      <button className="btn btn-success" style={{ color: 'white', position: 'absolute', left: '30%' }} onClick={() => submitUpdate(vendor.vendorId)}>
        Update
      </button>
    </div>
  )
}
export default UpdateForm
