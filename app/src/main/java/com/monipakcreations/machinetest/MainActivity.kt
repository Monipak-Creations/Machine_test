package com.monipakcreations.machinetest

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SmoothScroller
import com.google.android.material.tabs.TabLayout
import com.monipakcreations.machinetest.databinding.ActivityMainBinding
import com.monipakcreations.machinetest.view.VendorsViewModel
import com.monipakcreations.machinetest.view.adapter.VendorAdapter
import com.monipakcreations.machinetest.view.adapter.VendorModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vendorsViewModel: VendorsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        vendorsViewModel =
            ViewModelProvider(this)[VendorsViewModel::class.java]

        if(isNetworkAvailable(this@MainActivity)){
            vendorsViewModel.getRandomImage("127", "en", "")
            binding.progressBar.visibility = View.VISIBLE
        }else{
            Toast.makeText(this@MainActivity, "Please connect to internet !", Toast.LENGTH_SHORT).show()
        }


        vendorsViewModel.getRandomImagesLiveData().observe(this, Observer {
            Log.d(">>>", "onCreate: $it")

            binding.progressBar.visibility = View.INVISIBLE


            if (it != null) {
                for (item in it.data.vendorsItems[0].items) {
                    binding.tabLayout.addTab(binding.tabLayout.newTab().setText(item.name))
                }
            }

            var adapter = VendorAdapter()
            if (it != null) {
                adapter.setData(VendorModel(it.data.vendorsItems[0].items))
            }
            binding.vendorList.adapter = adapter

        })


        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
//                    Toast.makeText( this@MainActivity,""+tab.position, Toast.LENGTH_SHORT).show()

                    if (tab.position != binding.vendorList.getCurrentPosition()) {
                        val smoothScroller: SmoothScroller = object : LinearSmoothScroller(
                            applicationContext
                        ) {
                            override fun getVerticalSnapPreference(): Int {
                                return SNAP_TO_START
                            }
                        }

                        smoothScroller.targetPosition = tab.position

                        binding.vendorList.layoutManager?.startSmoothScroll(smoothScroller)
                        binding.tabLayout.getTabAt(binding.vendorList.getCurrentPosition())
                            ?.select()

                    }


                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        binding.vendorList.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    Log.d("scroll", "idle")
                } else if (newState == RecyclerView.SCROLL_STATE_SETTLING) {
//                    Log.d("scroll", "settling")
                } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
//                    Log.d("scroll", "dragging")
                }


            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
//                Log.d("scroll", "scrolling")
                if (binding.vendorList.getCurrentPosition() != binding.tabLayout.selectedTabPosition) {
                    binding.tabLayout.getTabAt(binding.vendorList.getCurrentPosition())?.select()
                }


            }
        })


    }

    fun RecyclerView?.getCurrentPosition(): Int {
        return (this?.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}