package com.monipakcreations.machinetest.view

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.monipakcreations.machinetest.dto.Data
import com.monipakcreations.machinetest.dto.VendorDetails
import com.monipakcreations.machinetest.repository.VendorsListRepository

class VendorsViewModel : ViewModel(){
    private var liveData: LiveData<VendorDetails?>
    private var repository: VendorsListRepository = VendorsListRepository()
    val progressBar: ObservableField<String> = ObservableField("INVISIBLE")

    init {
        liveData = repository.getLiveData()
    }

    fun getRandomImage(id: String, lang: String, userID: String) {
        repository.getRandomLists(id,lang,userID)
    }

    fun getRandomImagesLiveData(): LiveData<VendorDetails?> {
        return liveData
    }

}