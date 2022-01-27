package com.example.dukaanandroid.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dukaanandroid.R
import com.example.dukaanandroid.model.Orderlist
import com.example.dukaanandroid.model.filterData

class ListAdapter(val context: Context, val list: ArrayList<Orderlist>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_data, parent, false)
        )
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var order: TextView? = null
        var new: TextView? = null
        var etEditQuantity: String? = null
        var etSellingPrice : TextView?=null
        var order_status : TextView?=null
        var time : TextView?=null
        var image_order : ImageView?=null

        init {
            order = view.findViewById(R.id.order)
            new =view.findViewById(R.id.new_tag)
            etSellingPrice=view.findViewById(R.id.price)
            order_status=view.findViewById(R.id.order_status)
            time=view.findViewById(R.id.time)
            image_order=view.findViewById(R.id.image_order)

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.etSellingPrice!!.text =list.get(position).price
        holder.order_status!!.text =list.get(position).status
        holder.time!!.text=list.get(position).timestamp
        holder.order!!.text=list.get(position).id
        holder.new!!.text=list.get(position).isNew
        if(list.get(position).isNew!!.equals(true))
            holder.new!!.visibility=View.VISIBLE
        else
            holder.new!!.visibility=View.GONE

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
