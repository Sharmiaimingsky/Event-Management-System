import { useState } from 'react'
import { Link } from 'react-router-dom'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import './style.css'

const Signin = () => {
  const [mobileNumber, setMobileNumber] = useState('')
  const [question, setQuestion] = useState('')
  const [answer, setAnswer] = useState('')
  const [vendorid, setVendorid] = useState('')
  const navigate = useNavigate()

  const signinUser = () => {
    if (mobileNumber.length == 0) {
      toast.warning('please enter mobile number')
    } else {
      const body = {
        mobileNumber,
question,
answer,
      }
      const url = `http://localhost:8787/vendors/signin`
      axios.post(url, body).then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
          toast.success('Welcome to the application')
          const vid = response.data.data.vendorId
          const Q = response.data.data.question
          const A = response.data.data.answer
          sessionStorage['id'] = vid
         
          navigate('/vendor-update', { state: { Id: vid } })
        } else {
          toast.error('Invalid mobile number or answer')
        }
      })
    }
  }

  return (
    <div className="testdata">
      <h1 className="title" style={{color : 'white', fontWeight : 'bold'}}>
        Signin
      </h1>

      <br></br>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className=" testdata">
                Mobile number
              </label>
              <input
                onChange={(e) => {
                  setMobileNumber(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Security Question
              </label>
              <input
                onChange={(e) => {
                  setQuestion(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>
            <label htmlFor="" className="label-control">
              Answer here
            </label>
            <input
              onChange={(e) => {
                setAnswer(e.target.value)
              }}
              type="text"
              className="form-control"
            />

            <div className="mb-3" style={{color : 'white', fontWeight : 'bold'}}>
              <div className='testdata' style={{color : '#FFFFFF'}}>
                No account yet? <Link to="/vendor-signup"  style={{color : 'white', fontWeight : 'bold'}}>Signup here</Link>
              </div>
              <button onClick={signinUser} className="btn btn-primary">
                Signin
              </button>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  )
}

export default Signin
