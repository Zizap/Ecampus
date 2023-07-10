package com.example.ecampus.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecampus.data.models.getModels.GetSearchModel
import com.example.ecampus.data.models.searchModel.DataForSearch
import com.example.ecampus.data.models.searchModel.ListEntity
import com.example.ecampus.data.models.searchModel.SearchApiModel
import com.example.ecampus.domain.useCase.SearchUseCase

class SearchViewModel(private val searchUseCase: SearchUseCase): ViewModel() {

    private val _searchApiModel = MutableLiveData<SearchApiModel>()
    val searchApiModel: LiveData<SearchApiModel> get() = _searchApiModel


    fun search(getSearchModel: GetSearchModel){

        searchUseCase.search(
            searchModel = getSearchModel,

            onSuccess = {
                        data -> _searchApiModel.value = data
            },

            onError = {
            }
        )
    }


}