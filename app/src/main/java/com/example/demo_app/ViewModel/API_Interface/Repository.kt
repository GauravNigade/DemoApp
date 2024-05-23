package com.example.demo_app.ViewModel.API_Interface

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.demo_app.Model.NewResponseModel.CustomerResponseModel
import com.example.demo_app.Model.RequestModel.CustomerRequestModel
import com.example.demo_app.Model.ResponseModel.CustumerResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    var getCustomerData = MutableLiveData<CustomerResponseModel>()
    private val apiService by lazy {
        API_Interface.create()
    }
    fun getCustomers(): MutableLiveData<CustomerResponseModel> {
        val customerData = MutableLiveData<CustomerResponseModel>()
        apiService.getCustomerDetails(1 , 10 , 787).enqueue(object : Callback<CustomerResponseModel> {
            override fun onResponse(
                call: Call<CustomerResponseModel>,
                response: Response<CustomerResponseModel>
            ) {
                getCustomerData.value = response.body()
                Log.e("isSuccess" , response.toString())
            }

            override fun onFailure(call: Call<CustomerResponseModel>, t: Throwable) {
               Log.e("Repository" , "On Failure is called")
            }
        })
        return customerData
    }



   /* fun getCoustmers(
        requestModel: CustomerRequestModel
    ): MutableLiveData<CustumerResponseModel> {
        apiService.getCustomerData(requestModel)
            .enqueue(object : Callback<CustumerResponseModel> {
                override fun onResponse(
                    call: Call<CustumerResponseModel>,
                    response: Response<CustumerResponseModel>
                ) {
                    getCustomerData.value = response.body()
                    Log.e("isSuccess" , getCustomerData.toString())
                }
                override fun onFailure(call: Call<CustumerResponseModel>, t: Throwable) {

                    Log.e("Repository" ,"Error Failed")
                }
            })
        return getCustomerData
    }*/
}
