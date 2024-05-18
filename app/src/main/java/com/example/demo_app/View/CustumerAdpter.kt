package com.example.demo_app.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_app.R
import com.example.demo_app.databinding.AdapterCustomerListBinding

class CustumerAdpter (
    var context: Context
    /*var mListReport: ArrayList<Data>,
    var mOnCustomerListner: OnCustomerListner*/
): RecyclerView.Adapter<CustumerAdpter.CustomerViewHolder>(){

    // lateinit var reportDetails : DataXXXXXXXX

    inner class CustomerViewHolder(
        var mDataBinding: AdapterCustomerListBinding
       /* mOnCustomerListner: OnCustomerListner*/
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

        return CustomerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
    interface OnCustomerListner{
      //  fun onCustomerClick(Report: DataXXXXXXXX)
    }


}