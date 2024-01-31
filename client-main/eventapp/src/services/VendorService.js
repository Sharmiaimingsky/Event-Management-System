import axios from 'axios'

const VENDOR_BASE_REST_API_URL = 'http://localhost:8787/vendors/details';

class VendorService{

    getAllVendors(){
        return axios.get(VENDOR_BASE_REST_API_URL)
    }

    getVendorsById(vendorId){
        console.log(vendorId);
        return axios.get(VENDOR_BASE_REST_API_URL + '/' + vendorId);
    }

}

export default new VendorService();