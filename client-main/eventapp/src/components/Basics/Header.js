import React, { useEffect } from 'react'
import { Link } from 'react-router-dom'
import './style.css'
import logo from '../Basics/images/logo.png'

const Header = () => {
  const userid = 0
  const status = sessionStorage.getItem('loginStatus')
  useEffect(() => {}, [status])

  return (
    <>
      <ul className="unl">
        <div>
          <li className="lists">
            <a className="listsa" href="/">
              {' '}
              <img
                src={logo}
                alt="BEYOND Events"
                width={150}
                height={50}
              />{' '}
            </a>
          </li>
        </div>
        <div>
          <li className="lists2">
            <a
              href={!status ? '/user-signin' : '/dashboard'}
              type="button"
              className={!status ? 'btn btn-success' : 'btn btn-warning'}
              defaultValue={!status ? 'Login/SignUp' : 'Dashboard'}
            >
              Login/Dashbaoard{' '}
            </a>
          </li>
          {
            
          }

        </div>
      </ul>
    </>
  )
}

export default Header
