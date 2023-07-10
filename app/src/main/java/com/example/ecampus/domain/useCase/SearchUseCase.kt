package com.example.ecampus.domain.useCase


import com.example.ecampus.data.models.getModels.GetSearchModel
import com.example.ecampus.data.models.searchModel.SearchApiModel
import com.example.ecampus.domain.repository.SearchCall

class SearchUseCase(private val searchCall: SearchCall) {

    fun search(
        searchModel: GetSearchModel,
        onSuccess: (SearchApiModel) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        searchCall.search(searchModel,onSuccess,onError)
    }

}