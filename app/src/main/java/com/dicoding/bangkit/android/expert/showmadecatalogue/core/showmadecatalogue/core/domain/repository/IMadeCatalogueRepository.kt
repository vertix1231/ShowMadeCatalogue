package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.repository

import androidx.lifecycle.LiveData
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.Resource
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.model.MadeCatalogue

interface IMadeCatalogueRepository {

    fun getAllMadeCatalogue(): LiveData<Resource<List<MadeCatalogue>>>

    fun getFavoriteMadeCatalogue(): LiveData<List<MadeCatalogue>>

    fun setFavoriteMadeCatalogue(tourism: MadeCatalogue, state: Boolean)
}