package com.example.ecampus.domain.repository

import com.example.ecampus.data.models.getModels.GetSearchModel
import com.example.ecampus.data.models.searchModel.SearchApiModel

interface SearchCall {

    fun search(searchModel: GetSearchModel,
               onSuccess: (SearchApiModel) -> Unit,
               onError: (Throwable) -> Unit
    )

}