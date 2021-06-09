package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.home

import androidx.lifecycle.ViewModel
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.usecase.MadeCatalogueUseCase

class HomeViewModel(madeCatalogueUseCase: MadeCatalogueUseCase) : ViewModel() {

    val madeCatalogue = madeCatalogueUseCase.getAllMadeCatalogue()

}

