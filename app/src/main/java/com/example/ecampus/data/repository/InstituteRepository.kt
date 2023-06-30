package com.example.ecampus.data.repository

import com.example.ecampus.data.dataSource.GroupsApiDataSource
import com.example.ecampus.data.dataSource.InstitutesApiDataSource
import com.example.ecampus.data.models.institutesModels.InstitutesApiModel
import com.example.ecampus.domain.repository.GroupsCall
import com.example.ecampus.domain.repository.InstitutesCall

class InstituteRepository(private val institutesApiDataSource: InstitutesApiDataSource): InstitutesCall {

    override fun getInstitutes(
        onSuccess: (ArrayList<InstitutesApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        institutesApiDataSource.getInstitutes(onSuccess,onError)
    }


}