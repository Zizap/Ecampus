package com.example.ecampus.data.dataSource

import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.getModels.GetSearchModel
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel
import com.example.ecampus.data.models.searchModel.SearchApiModel

interface SearchApiDataSource {

    fun search(searchModel: GetSearchModel,
                    onSuccess: (SearchApiModel) -> Unit,
                    onError: (Throwable) -> Unit
    )

}