package com.example.ecampus.data.repository

import com.example.ecampus.data.dataSource.ScheduleApiDataSource
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel
import com.example.ecampus.domain.repository.ScheduleCall

class ScheduleRepository(private val scheduleApiDataSource: ScheduleApiDataSource):ScheduleCall {

    override fun getSchedule(
        specialties: GetScheduleModel,
        onSuccess: (ScheduleApiModel) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        scheduleApiDataSource.getSchedule(specialties,onSuccess,onError)
    }


}