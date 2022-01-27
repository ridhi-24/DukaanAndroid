package com.example.dukaanandroid.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatTextView
import com.example.dukaanandroid.View.Dashboard_fragment
import com.example.dukaanandroid.R

class MainAdapter(val context : Dashboard_fragment, val num :Array<String>, val values :Array<String>) :BaseAdapter(){
     private var layoutInflater: LayoutInflater? = null

    private lateinit var textView: AppCompatTextView
    private lateinit var value: AppCompatTextView
    override fun getCount(): Int {
        return num.size
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, convertview: View?, p2: ViewGroup?): View {
        var convertview =convertview
        if (layoutInflater == null) {
            layoutInflater =context!!.requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertview == null) {
            convertview = layoutInflater!!.inflate(R.layout.row_item, null)

        }
        textView = convertview!!.findViewById(R.id.text_num)
        value =convertview.findViewById(R.id.text_value)
        textView.text=num[p0]
        value.text=values[p0]
return convertview!!



    }
}