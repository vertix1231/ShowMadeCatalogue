package com.dicoding.bangkit.android.expert.maps

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.bangkit.android.expert.core.data.Resource
import com.dicoding.bangkit.android.expert.maps.databinding.ActivityMapsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class MapsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapsBinding
    private val mapsViewModel : MapsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        loadKoinModules(mapsModule)

        supportActionBar?.title = "MadeCatalogue Map"

        getMadeCatalogueMapsData()
    }

    @SuppressLint("SetTextI18n")
    private fun getMadeCatalogueMapsData() {
        mapsViewModel.madecataloguemap.observe(this,{
            if (it!=null){
                when(it){

                    is Resource.Loading -> binding.progressBar.visibility=View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvMaps.text = "This is map of ${it.data?.get(0)?.name}"
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = it.message
                    }
                }
            }
        })
    }


}