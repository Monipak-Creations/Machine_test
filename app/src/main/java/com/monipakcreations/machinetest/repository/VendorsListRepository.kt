package com.monipakcreations.machinetest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.monipakcreations.machinetest.dto.Data
import com.monipakcreations.machinetest.dto.VendorDetails
import com.monipakcreations.machinetest.network.RetrofitServices
import kotlinx.coroutines.*

class VendorsListRepository {
    private val vendorsService = RetrofitServices().getVendorsAPIService()
    private var job: Job? = null

    private val mutableLiveData = MutableLiveData<VendorDetails?>();

    fun getRandomLists(id: String, lang: String, userID: String) {
        job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = vendorsService.getVendorsList(id,lang,userID)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful)
                        mutableLiveData.value = response.body()
                    else
                        mutableLiveData.value = null
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    mutableLiveData.value = null
                }

            }

        }
    }

    fun getLiveData(): LiveData<VendorDetails?> {
        return mutableLiveData
    }
}