package com.example.ecampus.data.models.scheduleModel

import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ScheduleApiModel(
    @SerializedName("currentWeekIndex") @Expose
    val currentWeekIndex: Int,
    @SerializedName("weekdays") @Expose
    val weekdays: List<Weekday>,
    @SerializedName("weeks") @Expose
    val weeks: List<Week>,
    @SerializedName("forLabel") @Expose
    val forLabel: String,
    @SerializedName("name") @Expose
    val name: String,
    @SerializedName("id") @Expose
    val id: Int,
    @SerializedName("weekDoubled") @Expose
    val weekDoubled: Boolean,
    @SerializedName("scheduleExist") @Expose
    val scheduleExist: Boolean,
    @SerializedName("personalSchedule") @Expose
    val personalSchedule: Boolean,
    @SerializedName("date") @Expose
    val date: String,
    @SerializedName("title") @Expose
    val title: String,
    @SerializedName("pageTitle") @Expose
    val pageTitle: String,
    @SerializedName("type") @Expose
    val type: Int
)

data class Weekday(
    @SerializedName("id") @Expose
    val id: Int,
    @SerializedName("weekDay") @Expose
    val weekDay: String,
    @SerializedName("date") @Expose
    val date: String,
    @SerializedName("lessons") @Expose
    val lessons: List<Schedule>
)

data class Week(
    @SerializedName("weekType") @Expose
    val weekType: String,
    @SerializedName("dateBegin") @Expose
    val dateBegin: String,
    @SerializedName("dateEnd") @Expose
    val dateEnd: String,
    @SerializedName("number") @Expose
    val number: Int
)


data class Schedule (

    @SerializedName("id") @Expose
    val id: Int? = null,
    @SerializedName("lessonDayId") @Expose
    val lessonDayId: Int? = null,
    @SerializedName("teacherId") @Expose
    val teacherId: Int? = null,
    @SerializedName("roomId") @Expose
    val roomId: Int? = null,
    @SerializedName("discipline") @Expose
    val discipline: String? = null,
    @SerializedName("timeBegin") @Expose
    val timeBegin: String? = null,
    @SerializedName("timeEnd") @Expose
    val timeEnd: String? = null,
    @SerializedName("aud") @Expose
    val aud: Aud,
    @SerializedName("lessonType") @Expose
    val lessonType: String? = null,
    @SerializedName("pairNumberStart") @Expose
    val pairNumberStart: Int? = null,
    @SerializedName("pairNumberEnd") @Expose
    val pairNumberEnd: Int? = null,
    @SerializedName("weekDay") @Expose
    val weekDay: String? = null,
    @SerializedName("subGroups") @Expose
    val subGroups: Any? = null,
    @SerializedName("teacher") @Expose
    val teacher: Teacher? = null,
    @SerializedName("academicGroup") @Expose
    val academicGroup: Any? = null,
    @SerializedName("groups") @Expose
    val groups: List<GroupsApiModel>? = null,
    @SerializedName("current") @Expose
    val current: Boolean? = null,
    @SerializedName("lessonName") @Expose
    val lessonName: String? = null,

)

data class Aud(
    @SerializedName("id") @Expose
    val id: Int,
    @SerializedName("name") @Expose
    val name: String,
    @SerializedName("parentId") @Expose
    val parentId: Any?
)


data class Teacher(
    @SerializedName("id") @Expose
    val id: Int,
    @SerializedName("name") @Expose
    val name: String,
    @SerializedName("parentId") @Expose
    val parentId: Any?
)




