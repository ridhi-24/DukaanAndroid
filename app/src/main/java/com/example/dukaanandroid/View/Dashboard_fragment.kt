package com.example.dukaanandroid.View

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dukaanandroid.Adapter.ListAdapter
import com.example.dukaanandroid.Adapter.MainAdapter
import com.example.dukaanandroid.databinding.HomeDashboardBinding
import com.example.dukaanandroid.model.ObjectData
import com.example.dukaanandroid.model.Orderlist
import com.example.dukaanandroid.model.data
import com.example.dukaanandroid.model.filterData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class Dashboard_fragment : Fragment() {
    private var values = arrayOf("33", "2918", "301", "19121")
    private var names = arrayOf("ORDERS", "TOTAL SALES", "STORE VIEWS", "PRODUCT VIEWS")
    lateinit var binding: HomeDashboardBinding
    lateinit var inventdata: ArrayList<filterData>
    lateinit var orderlist :ArrayList<Orderlist>
    lateinit var adapter: ListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeDashboardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewsAndListeners()

    }

    private fun initializeViewsAndListeners() {
        val mainAdapter = MainAdapter(this, names, values)
        binding.gridView.adapter = mainAdapter


        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.listview.setLayoutManager(layoutManager)

        val assetJsonData = getAssetJsonData(requireContext(), "points.json")
        val type = object : TypeToken<data<ObjectData>>() {}.type
        var properties = Gson().fromJson<data<ObjectData>>(assetJsonData, type)
      //  Log.e("v", "" + properties)
       inventdata = properties.results.filter as ArrayList<filterData>

        binding.chip.text=inventdata.get(0).name + "(" +inventdata.get(0).count + ")"
        binding.chip2.text=inventdata.get(1).name + "(" + inventdata.get(1).count + ")"
        binding.chip3.text =inventdata.get(2).name + "(" +inventdata.get(2).count + ")"

        orderlist=properties.results.order as ArrayList<Orderlist>
          setadapter(orderlist)
    }

    fun setadapter(productList: ArrayList<Orderlist>) {
        adapter = ListAdapter(requireContext(), productList)
        binding.listview.setAdapter(adapter)
        adapter.notifyDataSetChanged()
    }

    fun getAssetJsonData(context: Context, s: String): String? {
        val json: String
        try {
            val inputStream = context.getAssets().open(s)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.use { it.read(buffer) }
            json = String(buffer)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        // print the data
        Log.i("data", json)
        return json
    }
}