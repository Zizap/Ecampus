package com.example.ecampus.domain.repository

import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel

interface ScheduleCall {

    fun getSchedule(specialties: GetScheduleModel,
                    onSuccess: (ScheduleApiModel) -> Unit,
                    onError: (Throwable) -> Unit
    )


}