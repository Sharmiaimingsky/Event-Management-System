import React from 'react'
import { useState, useEffect } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router'
import './style.css'
import { URL } from '../config'

const DeleteVendor = () => {
  const [vendor, setVendor] = useState([])
  const navigate = useNavigate()

  const loadAddVendor =  async () => {
    const url = `${URL}/Admin/allvendors`
    await axios.get(url).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setVendor(result['data'])
      }
    })
  }

  const delete1 = (id) => {
    const url = `${URL}/Admin/deletevendor/${id}`
    axios.post(url).then((response) => {
      const result = response.data
      loadAddVendor()
      if (result['status'] == 'success') {
        loadAddVendor()
        window.location.reload(false)
      }
    })
  }
  const navigateToNewPage = () => {
    navigate('/admin')
  }
  const navigateToDetails = (id) => {
    navigate('/admin-details', { state: { Id: id } })
  }

  const signOut = () => {
    sessionStorage.clear()
    window.location.href = "/";
  }

  useEffect(() => {
    loadAddVendor()
  },[])
  return (
    <div className="testdata">
       <br></br>
      <br></br>
      <button className="btn btn-danger" style={{ color: 'white',position: 'absolute',
                right: 40,
                 }} onClick={signOut}>
        Log Out
      </button>
      <br></br>
      <br></br>
      <button className="btn btn-success" style={{ color: 'white' , position: 'absolute',
                left: 40,
                }} onClick={navigateToNewPage}>
        ADD NEW VENODR
      </button>

      <h2 style={{ 'text-align': 'center' }}>ALL VENDOR</h2>
      <table
        className="table table-bordered  tablebg"
        style={{
          borderWidth: '3px',
          borderColor: 'black',
          borderStyle: 'solid',
          color: '#FFFFFF' ,
          maxWidth : '80%',
          background : 'linear-gradient(45deg,  #5f2c82,#49a09d)'
         
        }}
      >
        <thead>
          <th>ID</th>
          <th>NAME</th>
          <th>CITY</th>
          <th>DETAILS</th>
          <th>REMOVE</th>
        </thead>
        {vendor.map((b) => {
          return (
            <tbody>
              <tr>
                <td>{b.vendorId}</td>
                <td>{b.name}</td>
                <td>{b.city}</td>
                <td>
                  <button
                    className='btn btn-outline-light'
                    onClick={() => navigateToDetails(b.vendorId)}
                  >
                    DETAILS
                  </button>
                </td>
                <td>
                  <button className="btn btn-outline-danger" style={{color:'white'}} onClick={() => delete1(b.vendorId)}> delete </button>
                </td>
              </tr>
            </tbody>
          )
        })}
      </table>
    </div>
  )
}

export default DeleteVendor
