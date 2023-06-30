package com.example.ecampus.domain.useCase

import com.example.ecampus.data.models.institutesModels.InstitutesApiModel
import com.example.ecampus.domain.repository.InstitutesCall

class InstituteUseCase(private val institutesCall: InstitutesCall) {

    fun getInstitutes(
        onSuccess: (ArrayList<InstitutesApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        institutesCall.getInstitutes(onSuccess,onError)
    }

}