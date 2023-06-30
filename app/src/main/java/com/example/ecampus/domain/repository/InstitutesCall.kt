package com.example.ecampus.domain.repository

import com.example.ecampus.data.models.institutesModels.InstitutesApiModel

interface InstitutesCall {

    fun getInstitutes(onSuccess: (ArrayList<InstitutesApiModel>) -> Unit,
                      onError: (Throwable) -> Unit
    )

}