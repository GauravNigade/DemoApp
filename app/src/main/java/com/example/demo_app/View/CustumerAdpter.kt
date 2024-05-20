package com.example.demo_app.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_app.Model.ResponseModel.CustumerData
import com.example.demo_app.R
import com.example.demo_app.databinding.AdapterCustomerListBinding

class CustumerAdpter(
    var context: Context,
    var mListRepoet: ArrayList<CustumerData>,
    var mOnCustomerListner: MainScreen
): RecyclerView.Adapter<CustumerAdpter.CustomerViewHolder>(){

     lateinit var reportDetails : CustumerData

    inner class CustomerViewHolder(
        var mDataBinding: AdapterCustomerListBinding, mOnCustomerListner: MainScreen
    ):
        RecyclerView.ViewHolder(mDataBinding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<AdapterCustomerListBinding>(
            inflater,
            R.layout.adapter_customer_list,
            parent,
            false
        )

        return CustomerViewHolder(view , mOnCustomerListner)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {

        if (position ==1) {
            holder.mDataBinding.imgAnimal.setImageResource(R.drawable.cow)
        }else if (position ==2){
            holder.mDataBinding.imgAnimal.setImageResource(R.drawable.buffalo)
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
    interface OnCustomerListner{
        fun onCustomerClick(Report: CustumerData)
    }


}