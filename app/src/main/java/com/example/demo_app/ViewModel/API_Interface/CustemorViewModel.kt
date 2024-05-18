package com.example.demo_app.ViewModel.API_Interface

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.demo_app.Model.RequestModel.CustomerRequestModel
import com.example.demo_app.Model.ResponseModel.CustumerResponseModel

class CustemorViewModel : BaseViewModel(){

    var getCustomerViewModel : LiveData<CustumerResponseModel>?

    init {
        getCustomerViewModel = apiRepository.getCustomerData
    }

    fun callCustumerData(requestModel: CustomerRequestModel) {
        getCustomerViewModel = apiRepository.getCoustmers( requestModel)
    }

}