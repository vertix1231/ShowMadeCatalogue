package com.dicoding.bangkit.android.expert.core.utils

import com.dicoding.bangkit.android.expert.core.data.source.local.entity.MadeCatalogueEntity
import com.dicoding.bangkit.android.expert.core.data.source.remote.response.MadeCatalogueResponse
import com.dicoding.bangkit.android.expert.core.domain.model.MadeCatalogue

object DataMapper {
    fun mapResponsesToEntities(input: List<MadeCatalogueResponse>): List<MadeCatalogueEntity> {
        val tourismList = ArrayList<MadeCatalogueEntity>()
        input.map {
            val tourism = MadeCatalogueEntity(
                tourismId = it.id,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    // UBAH ROOM ENTITY MADECATALOGUE JADI MODEL DOMAIN MADECATALOGUE

    fun mapEntitiesToDomain(input: List<MadeCatalogueEntity>): List<MadeCatalogue> =
        input.map {
            MadeCatalogue(
                tourismId = it.tourismId,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }
    fun mapDomainToEntity(input: MadeCatalogue) = MadeCatalogueEntity(
        tourismId = input.tourismId,
        description = input.description,
        name = input.name,
        address = input.address,
        latitude = input.latitude,
        longitude = input.longitude,
        like = input.like,
        image = input.image,
        isFavorite = input.isFavorite
    )
}