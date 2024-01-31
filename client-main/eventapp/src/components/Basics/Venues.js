import React, { useState, useEffect } from 'react'
import './style.css'

import MenuCard from './MenuCard'
import Navbar from './Navbar'

import axios from 'axios'
import { toast } from 'react-toastify'
import { useNavigate, useLocation, Link } from 'react-router-dom'

// console.log(uniqueList);

const Venues = () => {
  const navigate = useNavigate()
  const { state } = useLocation()
  const { city, price, venueCapacity } = state
  console.log(state)
  const [menuData, setMenuData] = useState([]) //[]
  const [menu ,setMenu] = useState([])

  const loadData = async () => {
    const body = {
      city,
      price,
      venueCapacity,
    }
    const response = await axios.post('http://localhost:8787/venue', body)
    console.log(response)
    if (response.data.data.length == 0) {
      if (response.data.data.length == 0 && price == 0 && venueCapacity == 0)
        toast.error('Please enter valid data')
      else if (price == 0) toast.error('Price can not be zero')
      else if (venueCapacity == 0) toast.error('Capacity can not be zero')
      else
        toast.error(
          'We do not provide service in this city...Please enter valid city name',
        )
      navigate('/')
    } else 
    {
      setMenuData(response.data.data)
      setMenu(response.data.data)
    }
  }

  useEffect(() => {
    loadData()
  }, [])

  const uniqueList = ['All', 'Wedding', 'Fest', 'BirthDay', 'Corporate']
  const [menuList, setMenuList] = useState(uniqueList)

  const filterItem = (event) => {
    console.log(event)
    if (event ==='All') {
      // console.log(menuData)
      setMenuData(menu)
       return
    }
    else
     {
      const updatedList = menu.filter((curElem) => {
        return curElem.event === event
      })
      
      setMenuData(updatedList)
    }
    console.log(menuData)
  }

  return (
    <>
      <Navbar filterItem={filterItem} menuList={menuList} />
      <MenuCard menuData={menuData} />
    </>
  )
}

export default Venues
