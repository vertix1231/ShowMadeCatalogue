package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.bangkit.android.expert.core.domain.model.MadeCatalogue
import com.dicoding.bangkit.android.expert.showmadecatalogue.R
import com.dicoding.bangkit.android.expert.showmadecatalogue.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailViewModel: DetailViewModel by viewModel()
//    private lateinit var detailViewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)

//        val factory = ViewModelFactory.getInstance(this)
//        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val madeCatalogue = intent.getParcelableExtra<MadeCatalogue>(EXTRA_DATA)
        showDetailTourism(madeCatalogue)
    }

    private fun showDetailTourism(madeCatalogue: MadeCatalogue?) {
        madeCatalogue?.let {
            supportActionBar?.title = madeCatalogue.name
            binding.content.tvDetailDescription.text = madeCatalogue.description
            Glide.with(this@DetailActivity)
                .load(madeCatalogue.image)
                .into(binding.ivDetailImage)

            var statusFavorite = madeCatalogue.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavorite(madeCatalogue, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}