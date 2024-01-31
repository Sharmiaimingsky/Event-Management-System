import React from 'react'
import { Dropdown } from 'react-bootstrap'
import { useNavigate } from 'react-router'
import { Link } from 'react-router-dom'
import './style.css'

const MenuCard = ({ menuData }) => {
  console.log(menuData)

  const navigate = useNavigate()

  //  const eitherSort = (arr = []) => {
  //    const sorter = (a, b) => {
  //       return +a.price - +b.price;
  //    };
  //    arr.sort(sorter);
  //  };
  //  const sortbyprice=menuData.sort((a,b)=>{
  //    return a.price - b.price;
  //  });

  const navigateToVendors = (Id) => {
    navigate('/vendor-details', { state: { venueId: Id } })
  }

  return (
    <>
      {/* <div>
        <div>
          <Dropdown className=" stylesort">
            ;
            <Dropdown.Toggle variant="success" id="dropdown-basic">
              <i className="fa fa-sort-amount-desc "></i>
            </Dropdown.Toggle>
            <Dropdown.Menu>
              <Dropdown.Item type="submit">Price</Dropdown.Item>
              <Dropdown.Item href="#/action-2">Capacity</Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>
        </div>
      </div> */}

      <section className="main-card--cointainer">
        {menuData.map((curElem) => {
          const {
            id,
            venuename,
            event,
            image,
            price,
            capacity,
            description,
          } = curElem

          return (
            <>
              <div className="card-container"  key={id}>
                <div className="card " >
                  <div className="card-body">
                    {/* <span className="card-number card-circle subtle" >{id}</span> */}
                    <span className="card-author subtle"><h4> <b>{event}</b></h4></span>
                    <h3 className="card-title"> {venuename} </h3>
                    <span className="card-description subtle">
                      {description}
                    </span>
                  </div>
                  <div>
                    <div>
                      <img src={require(`${image}`) .default} alt="imagesshdgh" className="card-media" />
                      
                    </div>
                    <div className="card-medial">
                      <h5>Price</h5>
                      <span className="  subtle">{price}</span>
                      <h5>Capacity</h5>
                      <span className="  subtle">{capacity}</span>
                    </div>
                  </div>
                  <div>
                    {' '}
                    <span className="card-tag  subtle ">
                      <Link to={`/vendor-details/${id}`}>
                        <button style={{marginLeft: '-12px',marginBottom: '-10px', marginRight:'-12px', marginTop: '-12px' }} className="btn btn-outline-success buttonpadding">
                          {' '}
                          Add Service
                        </button>
                      </Link>
                    </span>
                  </div>
                </div>
              </div>
            </>
          )
        })}
      </section>
    </>
  )
}

export default MenuCard
