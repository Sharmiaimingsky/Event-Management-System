import React from "react";
import AwesomeSlider from 'react-awesome-slider';
import withAutoplay from 'react-awesome-slider/dist/autoplay';
import 'react-awesome-slider/dist/styles.css';
const AutoplaySlider = withAutoplay(AwesomeSlider);

const SlideShow = ({imageData}) => {    
  return (
     <>
   <AutoplaySlider
    play={true}
    cancelOnInteraction={false} // should stop playing on user interaction
    interval={2500}
    className="manageCv2"
   
  >
 
     {imageData.map((curElem) => {
            const { id,image } = curElem;
         return(
             <>     
             <div key={id}>
             <img src={image} alt="images" className="alignmentc" />
             </div>
            
             </>
           ); 
   
})}
 </AutoplaySlider>
    </>
  );
};

export default SlideShow;
