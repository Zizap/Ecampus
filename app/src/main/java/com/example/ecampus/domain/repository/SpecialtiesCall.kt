package com.example.ecampus.domain.repository

import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel

interface SpecialtiesCall {

    fun getSpecialties(specialties: GetSpecialtiesModel,
                       onSuccess: (ArrayList<SpecialtiesApiModel>) -> Unit,
                       onError: (Throwable) -> Unit
    )

}