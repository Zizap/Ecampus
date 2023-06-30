package com.example.ecampus.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel
import com.example.ecampus.domain.useCase.ScheduleUseCase

class ScheduleViewModel(private val scheduleUseCase: ScheduleUseCase): ViewModel() {

    private val _scheduleApiModel = MutableLiveData<ScheduleApiModel>()
    val scheduleApiModel: LiveData<ScheduleApiModel> get() = _scheduleApiModel

    fun loadSchedule(getScheduleModel: GetScheduleModel) {
        scheduleUseCase.getSchedule(
            specialties = getScheduleModel,
            onSuccess = { data ->
                _scheduleApiModel.value = data
            },
            onError = {

            }
        )
    }
}
//
//private val _weekdayList = MutableLiveData<ArrayList<Weekday>>()
//val weekdayList: LiveData<ArrayList<Weekday>> get() = _weekdayList
//
//private val _lessonList = MutableLiveData<ArrayList<Schedule>>()
//val lessonList: LiveData<ArrayList<Schedule>> get() = _lessonList

//_weekdayList.value?.addAll(scheduleApiModel!!.weekdays)
//
//for (weekday in scheduleApiModel!!.weekdays) {
//
//    _lessonList.value?.addAll(weekday.lessons)
//    Log.e("EBATNIHYAHYA",weekday.lessons.toString())
//}