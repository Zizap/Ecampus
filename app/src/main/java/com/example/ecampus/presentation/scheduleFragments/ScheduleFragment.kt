package com.example.ecampus.presentation.scheduleFragments

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.scheduleModel.Schedule
import com.example.ecampus.data.models.scheduleModel.Weekday
import com.example.ecampus.databinding.FragmentScheduleBinding
import com.example.ecampus.presentation.adapters.LessonAdapter
import com.example.ecampus.presentation.viewModels.ScheduleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ScheduleFragment(private val getScheduleModel: GetScheduleModel,private val position: Int) : Fragment() {

    private var binding:FragmentScheduleBinding? = null
    private val scheduleViewModel: ScheduleViewModel by viewModel()
    private var lessonAdapter: LessonAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScheduleBinding.inflate(inflater,container,false)

        Log.e("OPAJOPA",getScheduleModel.Id.toString())
        initRecyclerSchedule()
        loadSchedule(getScheduleModel)

        return binding?.root
    }

    private fun initRecyclerSchedule(){
        binding?.recyclerSchedule?.layoutManager = LinearLayoutManager(requireContext())
        lessonAdapter = LessonAdapter()
        binding?.recyclerSchedule?.adapter = lessonAdapter

    }

    private fun loadSchedule(getScheduleModel: GetScheduleModel){
        showProgressBar()
        scheduleViewModel.loadSchedule(getScheduleModel)
        scheduleViewModel.scheduleApiModel.observe(viewLifecycleOwner, Observer{
            val weekdaysList:ArrayList<Weekday> = ArrayList()
            val lessonList:ArrayList<Schedule> = ArrayList()
            if (it != null && it.weekdays != null) {
                for (weekday in it.weekdays) {
                    when (position){
                        0 -> {
                            if (weekday.weekDay.toString() == "Понедельник"){
                                weekdaysList.add(weekday)
                            }
                        }
                        1 -> {
                            if (weekday.weekDay.toString() == "Вторник"){
                                weekdaysList.add(weekday)
                            }
                        }
                        2 -> {
                            if (weekday.weekDay.toString() == "Среда"){
                                weekdaysList.add(weekday)
                            }
                        }
                        3 -> {
                            if (weekday.weekDay.toString() == "Четверг"){
                                weekdaysList.add(weekday)
                            }
                        }
                        4 -> {
                            if (weekday.weekDay.toString() == "Пятница"){
                                weekdaysList.add(weekday)
                            }
                        }
                        5 -> {
                            if (weekday.weekDay.toString() == "Суббота"){
                                weekdaysList.add(weekday)
                            }
                        }
                    }
                }
            }
            if ((it != null) && !weekdaysList.isEmpty()){
                for (weekday in weekdaysList) {
                    lessonList.addAll(weekday.lessons)
                }
            }

            if (lessonList.isEmpty()){
                binding?.recyclerSchedule?.visibility = View.GONE
                binding?.notInfo?.visibility = View.VISIBLE
                binding?.notInfo?.text = "На этот день расписание не предоставлено"
                hideProgressBar()
            } else {
                lessonAdapter?.setList(lessonList,weekdaysList)
                lessonAdapter?.notifyDataSetChanged()
                hideProgressBar()
            }
        })
    }

    private fun hideProgressBar() {
        binding?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBar?.visibility = View.VISIBLE
    }
}