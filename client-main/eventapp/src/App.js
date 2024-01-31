import React from "react";
import Venues from "./components/Basics/Venues";
import Header from "./components/Basics/Header";
import Footer from "./components/Basics/Footer";
import Start from "./components/Basics/Start";
import DashBoard from "./components/Basics/DashBoard";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import ListVendorComponent from "./components/ListVendorComponent";
import UserPaymentComponent from "./components/UserPaymentComponent";
import Details from "./components/Details";
import UpdateForm from "./components/UpdateForm";
import Signin from "./components/Signin";
import Signup from "./components/Signup";
import DeleteVendor from "./components/DeleteVendor";
import AddVendor from "./components/AddVendor";
import USignin from "./pages/Signin";
import USignup from "./pages/Signup";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer } from "react-toastify";
import About from "./pages/footer/About"
import Stories from "./pages/footer/Stories"



const App = () => {
  return (
    <div>
      <Header />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Start />} />
          <Route path="/user-signin" element={<USignin />} />
          <Route path="/user-signup" element={<USignup />} />
          <Route path="/venues" element={<Venues />} />
          <Route path="/dashboard/" element={<DashBoard />} />
          <Route path="/vendor-details/:id" element={<ListVendorComponent />} />
          <Route path="/user-payment" element={<UserPaymentComponent />} />
          <Route path="/delete-vendor" element={<DeleteVendor />} />
          <Route path="/admin" element={<AddVendor />} />
          <Route path="/admin-details" element={<Details />} />
          <Route path="/vendor-signup" element={<Signup />} />
          <Route path="/vendor-signin" element={<Signin />} />
          <Route path="/vendor-update" element={<UpdateForm />} />
          <Route path="/about" element= {<About/>}/>
          <Route path="/stories" element={<Stories/>}/>
        </Routes>
      </BrowserRouter>
      <ToastContainer theme="colored" position="top-right" autoClose='2000'/>
      <Footer />
    </div>
  );
};

export default App;
