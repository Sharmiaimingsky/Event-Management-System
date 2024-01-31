import React, { useState, useEffect } from 'react'
import  "../../../node_modules/bootstrap/dist/css/bootstrap.min.css"

import './style.css'
import RangeSlider from 'react-bootstrap-range-slider'
import SlideShow from './SlideShow'
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import 'react-bootstrap-buttons/dist/react-bootstrap-buttons.css'
import { Button } from 'react-bootstrap-buttons'
import Images from './image'
import { toast } from 'react-toastify'
import { useNavigate } from 'react-router-dom'
const initialState = {
  city: ' ',
  price: '100000',
  venueCapacity: '1000',
}

const SearchForm = () => {
  const [state, setState] = useState(initialState)
  const [imageData, setImage] = useState(Images)
  const { city, price, venueCapacity } = state
  const navigate = useNavigate()

  const handleSubmit = (e) => {
    e.preventDefault()
    if (sessionStorage.getItem('loginStatus')) {
      if (sessionStorage.getItem('role') == 'user') {
        if (city == ' ') toast.error('Please enter the city name')
        else setTimeout(() => navigate('/venues', { state }), 500)
      } else setTimeout(() => navigate('/admin'), 500)
    } else {
      setTimeout(() => navigate('/user-signin'), 500)
    }

    // }else{
    //     updateperson(state,personid);
    //     toast.success("data updated");
    //     setTimeout(()=> navigate("/"),500);
    // }
  }

  useEffect(() => {

  })

  const handleInputChange = (e) => {
    const { name, value } = e.target
    setState({ ...state, [name]: value })
  }

  return (
    <>
      <div className="testdata">
        <form className="example alignmentform" onSubmit={handleSubmit}>
          <div>
            <input
              type="text"
              id="city"
              onChange={handleInputChange}
              name="city"
              placeholder="Search city..."
            />

            <Button type="submit" btnStyle="dark" lg>
              <i className="fa fa-search"></i>
            </Button>
          </div>

          <div className="containers">
            <div>
              <h5>
                {' '}
                <b> Price</b>{' '}
              </h5>
              <RangeSlider
                variant="primary"
                name="price"
                value={price}
                min="0"
                max="100000"
                onChange={handleInputChange}
              />
            </div>

            <div>
              <h5>
                {' '}
                <b>Capacity</b>
              </h5>
              <RangeSlider
                value={venueCapacity}
                name="venueCapacity"
                min="0"
                max="1000"
                variant="primary"
                onChange={handleInputChange}
              />
            </div>
          </div>
        </form>
      </div>
      <SlideShow imageData={imageData} />
    </>
  )
}

export default SearchForm
