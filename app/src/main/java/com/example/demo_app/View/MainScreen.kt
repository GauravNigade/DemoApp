package com.example.demo_app.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_app.Model.RequestModel.CustomerRequestModel
import com.example.demo_app.R
import com.example.demo_app.ViewModel.API_Interface.CustemorViewModel
import com.example.demo_app.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {
    lateinit var binding: ActivityMainScreenBinding
    lateinit var mAdapterReport: CustumerAdpter
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var getCustumerViewModel: CustemorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_screen)
        mAdapterReport = CustumerAdpter(this)
        getCustumerViewModel = ViewModelProvider(this)[CustemorViewModel::class.java]

        setupUI()
        getCustomerData()
    }

    private fun setupUI(){
        mLinearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCustomerList.adapter = mAdapterReport
        mAdapterReport.notifyDataSetChanged()
        binding.rvCustomerList.layoutManager = mLinearLayoutManager
    }

    private fun getCustomerData(){

                val requestModel = CustomerRequestModel(
                    "tblcustomer", 787, 404, "" )
        getCustumerViewModel.callCustumerData(requestModel)

            }
    }