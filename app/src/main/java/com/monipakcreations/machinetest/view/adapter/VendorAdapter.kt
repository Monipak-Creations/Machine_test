package com.monipakcreations.machinetest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.monipakcreations.machinetest.databinding.HolderVendorItemBinding

class VendorAdapter : RecyclerView.Adapter<VendorAdapter.ViewHolder>() {

    private lateinit var vendorModel: VendorModel

    class ViewHolder(val binding: HolderVendorItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(vendorModel: VendorModel, position: Int) {
            binding.textView2.text = vendorModel.vendorsList[position].name
            var adapter = VendorSubAdapter()
            adapter.setData(VendorSubModel(vendorModel.vendorsList[position].subItem))
            binding.vendorSubList.adapter = adapter
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            HolderVendorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return vendorModel.vendorsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(vendorModel, position)
    }

    fun setData(vendorModel: VendorModel) {
        this.vendorModel = vendorModel
        notifyDataSetChanged()
    }

}