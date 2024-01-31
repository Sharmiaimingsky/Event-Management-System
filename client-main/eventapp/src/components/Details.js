import React from 'react'
import { useState, useEffect } from 'react'
import axios from 'axios'
import { useNavigate, useLocation } from 'react-router'
import './Vendor.css'
import './style.css'
import { URL } from '../config'
const Details = () => {
  const { state } = useLocation()
  const { Id } = state
  const [vendor, setVendor] = useState([])
  const navigate = useNavigate()

  const loadAddVendor = (Id) => {
    const url = `${URL}/Admin/details/${Id}`
    axios.post(url).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setVendor(result['data'])
      }
    })
  }

  const navigateToBack = () => {
    navigate('/admin')
  }

  useEffect(() => {
    loadAddVendor(Id)
  }, [])

  return (
    <div className="testdata">
      <br></br>
      <br></br>
      <button
        className="btn btn-danger"
        style={{ color: 'white', position: 'absolute', left: '30%' }}
        onClick={() => navigateToBack()}
      >
        BACK
      </button>

      <h2 style={{ 'text-align': 'center' }}>
        {' '}
        <b>DETAILS</b>
      </h2>

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
        }}
      >
        <div className="form-group row">
          <label htmlFor="staticEmail" className="col-sm-2 col-form-label">
            Id
          </label>
          <div className="col-sm-10">
            <input
              style={{ color: 'white', fontWeight: 'bold' }}
              type="text"
              readOnly
              className="form-control-plaintext"
              id="staticEmail"
              defaultValue={vendor.vendorId}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="staticEmail" className="col-sm-2 col-form-label">
            Name
          </label>
          <div className="col-sm-10">
            <input
              style={{ color: 'white', fontWeight: 'bold' }}
              type="text"
              readOnly
              className="form-control-plaintext"
              id="staticEmail"
              defaultValue={vendor.name}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="staticEmail" className="col-sm-2 col-form-label">
            Rates
          </label>
          <div className="col-sm-10">
            <input
              style={{ color: 'white', fontWeight: 'bold' }}
              type="text"
              readOnly
              className="form-control-plaintext"
              id="staticEmail"
              defaultValue={vendor.rates}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="staticEmail" className="col-sm-2 col-form-label">
            Description
          </label>
          <div className="col-sm-10">
            <input
              style={{ color: 'white', fontWeight: 'bold' }}
              type="text"
              readOnly
              className="form-control-plaintext"
              id="staticEmail"
              defaultValue={vendor.description}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="staticEmail" className="col-sm-2 col-form-label">
            Experience
          </label>
          <div className="col-sm-10">
            <input
              style={{ color: 'white', fontWeight: 'bold' }}
              type="text"
              readOnly
              className="form-control-plaintext"
              id="staticEmail"
              defaultValue={vendor.experience}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="staticEmail" className="col-sm-2 col-form-label">
            Category
          </label>
          <div className="col-sm-10">
            <input
              style={{ color: 'white', fontWeight: 'bold' }}
              type="text"
              readOnly
              className="form-control-plaintext"
              id="staticEmail"
              defaultValue={vendor.category}
            />
          </div>
        </div>
        <div className="form-group row">
          <label htmlFor="staticEmail" className="col-sm-2 col-form-label">
            City
          </label>
          <div className="col-sm-10">
            <input
              style={{ color: 'white', fontWeight: 'bold' }}
              type="text"
              readOnly
              className="form-control-plaintext"
              id="staticEmail"
              defaultValue={vendor.city}
            />
          </div>
        </div>
      </form>

      <br></br>
      <br></br>

      <button
        className="btn btn-danger"
        style={{ color: 'white', position: 'absolute', left: '30%' }}
        onClick={() => navigateToBack()}
      >
        BACK
      </button>
    </div>
  )
}
export default Details
