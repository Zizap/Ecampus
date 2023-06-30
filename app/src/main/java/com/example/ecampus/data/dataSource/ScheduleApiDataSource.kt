package com.example.ecampus.data.dataSource

import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel

interface ScheduleApiDataSource {

    fun getSchedule(specialties: GetScheduleModel,
                    onSuccess: (ScheduleApiModel) -> Unit,
                    onError: (Throwable) -> Unit
    )


}