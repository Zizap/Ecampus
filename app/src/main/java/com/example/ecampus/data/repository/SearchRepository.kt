package com.example.ecampus.data.repository

import com.example.ecampus.data.dataSource.SearchApiDataSource
import com.example.ecampus.data.models.getModels.GetSearchModel
import com.example.ecampus.data.models.searchModel.SearchApiModel
import com.example.ecampus.domain.repository.SearchCall

class SearchRepository(private val searchApiDataSource: SearchApiDataSource):SearchCall {

    override fun search(
        searchModel: GetSearchModel,
        onSuccess: (SearchApiModel) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        searchApiDataSource.search(searchModel,onSuccess,onError)
    }
}