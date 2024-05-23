package com.example.demo_app.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_app.Model.NewResponseModel.ResponseData
import com.example.demo_app.Model.ResponseModel.CustumerData1
import com.example.demo_app.R
import com.example.demo_app.databinding.AdapterCustomerListBinding

class CustumerAdpter(
    var context: Context,
    var mListRepoet: ArrayList<ResponseData>,
    var mOnCustomerListner: MainScreen
): RecyclerView.Adapter<CustumerAdpter.CustomerViewHolder>(){
     //lateinit var reportDetails : CustumerData1
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

        val mCustData = mListRepoet[position]
        holder.mDataBinding.txtCustName.text = mCustData.fName
        holder.mDataBinding.txtCustLastName.text = mCustData.lName
        holder.mDataBinding.txtCustMobNo.text = mCustData.mobileNo

        if (mCustData.isCow ==1 && mCustData.isBuffalo ==0){
            holder.mDataBinding.imgAnimal.setImageResource(R.drawable.cow)
        }else if(mCustData.isBuffalo == 1 && mCustData.isCow ==1){
            holder.mDataBinding.imgAnimal.setImageResource(R.drawable.buffalo)
        }else{
            holder.mDataBinding.imgAnimal.setImageResource(R.drawable.placeholderimg)
        }
    }
    override fun getItemCount(): Int {
        return mListRepoet.size
    }
    interface OnCustomerListner{
        fun onCustomerClick(Report: CustumerData1)
    }


}