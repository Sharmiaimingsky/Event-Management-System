import React from "react";

const navbar = ({ filterItem, menuList }) => {
  return (
   <>

      <nav className="navbarcss btn-grp" >
        <div className="btn-group" style={{backgroundColor: '#7851a9'}}>
          {menuList.map((curElem) => {
            return (
              <button
              style={{backgroundColor: '#CDB0EE' , color:'white'}}
                className="btn-group__item"
                onClick={() => filterItem(curElem)}>
                {curElem}
              </button>
            );
          })}
        </div>
      </nav>
    </>
  );
};

export default navbar;
