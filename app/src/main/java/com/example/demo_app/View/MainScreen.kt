package com.example.demo_app.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_app.Model.NewResponseModel.ResponseData
import com.example.demo_app.R
import com.example.demo_app.ViewModel.API_Interface.CustemorViewModel
import com.example.demo_app.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {
    lateinit var binding: ActivityMainScreenBinding
    lateinit var mAdapterReport: CustumerAdpter
    lateinit var mListRepoet:ArrayList<ResponseData>
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var getCustumerViewModel: CustemorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_screen)
        mListRepoet = ArrayList()
        mAdapterReport = CustumerAdpter(this , mListRepoet , this)
        getCustumerViewModel = ViewModelProvider(this)[CustemorViewModel::class.java]

        addObserver()
        getCustomerData()
        setupUI()

    }
    private fun setupUI(){

        mLinearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCustomerList.adapter = mAdapterReport
        mAdapterReport.notifyDataSetChanged()
        binding.rvCustomerList.layoutManager = mLinearLayoutManager
    }
    private fun getCustomerData(){
        getCustumerViewModel.callCustumerData()
        binding.progress.visibility = View.VISIBLE
            Log.e("Main Screen","API Request Sending")
        }

    private fun addObserver(){
        getCustumerViewModel.getCustomerViewModel?.observe(
            this,
            androidx.lifecycle.Observer { responseModel ->
                binding.progress.visibility = View.GONE
                try {
                        if (responseModel.statusCode == "200") {
                            mListRepoet.clear()
                            mListRepoet.addAll(responseModel.responseData)
                            mAdapterReport.notifyDataSetChanged()
                            Log.e("Main Screen observer" , responseModel.responseData.toString())
                        } else if (responseModel.responseData ==null) {
                            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                        }
                } catch (ignored: Exception) {
                }
            })
    }
}