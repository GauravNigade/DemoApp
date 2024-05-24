package com.example.demo_app.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.ContextCompat
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
): RecyclerView.Adapter<CustumerAdpter.CustomerViewHolder>() , Filterable {
    //lateinit var reportDetails : CustumerData1
    private var filteredList: ArrayList<ResponseData> = ArrayList(mListRepoet)
    private val mColors = intArrayOf(R.color.RedColor, R.color.GreenColor, R.color.BlueColor)

    inner class CustomerViewHolder(
        var mDataBinding: AdapterCustomerListBinding, mOnCustomerListner: MainScreen
    ) : RecyclerView.ViewHolder(mDataBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<AdapterCustomerListBinding>(
            inflater,

            R.layout.adapter_customer_list,
            parent,
            false
        )
        return CustomerViewHolder(view, mOnCustomerListner)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {

        val mCustData = mListRepoet[position]

        val colorIndex = position % mColors.size
        holder.mDataBinding.txtCustName.setTextColor(
            ContextCompat.getColor(
                holder.itemView.context,
                mColors[colorIndex]
            )
        )
        holder.mDataBinding.txtCustLastName.setTextColor(
            ContextCompat.getColor(
                holder.itemView.context,
                mColors[colorIndex]
            )
        )
        holder.mDataBinding.txtCustName.text = mCustData.fName
        holder.mDataBinding.txtCustLastName.text = mCustData.lName
        holder.mDataBinding.txtCustMobNo.text = mCustData.mobileNo

        if (mCustData.isCow == 1 && mCustData.isBuffalo == 0) {
            holder.mDataBinding.imgAnimal.setImageResource(R.drawable.cow)
        } else if (mCustData.isBuffalo == 1 && mCustData.isCow == 1) {
            holder.mDataBinding.imgAnimal.setImageResource(R.drawable.buffalo)
        } else {
            holder.mDataBinding.imgAnimal.setImageResource(R.drawable.placeholderimg)

        }
    }

    override fun getItemCount(): Int {
        return mListRepoet.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString()?.lowercase() ?: ""
                val results = FilterResults()

                results.values = if (query.isEmpty()) {
                    mListRepoet
                } else {
                    mListRepoet.filter {
                        it.fName.lowercase().contains(query) ||
                                it.lName.lowercase().contains(query) ||
                                it.mobileNo.contains(query)
                    } as ArrayList<ResponseData>
                }
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as ArrayList<ResponseData>
                notifyDataSetChanged()
            }
        }
    }

    interface OnCustomerListner {
        fun onCustomerClick(Report: CustumerData1)
    }
}


