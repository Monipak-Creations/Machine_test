package com.monipakcreations.machinetest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.monipakcreations.machinetest.databinding.HolderVendorItemBinding
import com.monipakcreations.machinetest.databinding.HolderVendorSubItemBinding

class VendorSubAdapter : RecyclerView.Adapter<VendorSubAdapter.ViewHolder>() {

    private lateinit var vendorSubModel: VendorSubModel
    class ViewHolder(val binding: HolderVendorSubItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(vendorSubModel: VendorSubModel, position: Int) {
        binding.textView.text = vendorSubModel.vendorsSubList[position].name
        binding.textView4.text =
            "KD ${vendorSubModel.vendorsSubList[position].addonValues[0].price}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HolderVendorSubItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)    }

    override fun getItemCount(): Int {
        return vendorSubModel.vendorsSubList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(vendorSubModel,position)
    }

    fun setData(vendorSubModel: VendorSubModel) {
        this.vendorSubModel = vendorSubModel
        notifyDataSetChanged()
    }

}