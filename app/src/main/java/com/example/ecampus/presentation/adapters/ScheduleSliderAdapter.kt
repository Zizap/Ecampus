package com.example.ecampus.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.presentation.scheduleFragments.ScheduleFragment

class ScheduleSliderAdapter(fragmentActivity:FragmentActivity):FragmentStateAdapter(fragmentActivity) {

    private var getScheduleModel: GetScheduleModel? = null

    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> {
                ScheduleFragment(getScheduleModel!!,0)
            }
            1 -> {
                ScheduleFragment(getScheduleModel!!,1)
            }
            2 -> {
                ScheduleFragment(getScheduleModel!!,2)
            }
            3 -> {
                ScheduleFragment(getScheduleModel!!,3)
            }
            4 -> {
                ScheduleFragment(getScheduleModel!!,4)
            }
            5 -> {
                ScheduleFragment(getScheduleModel!!,5)
            }
            else -> {
                ScheduleFragment(getScheduleModel!!,0)
            }
        }
    }

    fun getScheduleModel(getScheduleModel: GetScheduleModel){

        this.getScheduleModel = getScheduleModel

    }

}