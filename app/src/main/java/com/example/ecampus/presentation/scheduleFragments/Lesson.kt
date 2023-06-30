package com.example.ecampus.presentation.scheduleFragments

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
import com.example.ecampus.databinding.FragmentLessonBinding
import com.example.ecampus.presentation.adapters.LessonAdapter
import com.example.ecampus.presentation.adapters.ScheduleSliderAdapter
import com.example.ecampus.presentation.viewModels.ScheduleViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel


class Lesson(private val getScheduleModel: GetScheduleModel) : Fragment() {

    private var binding: FragmentLessonBinding? = null
    private var scheduleSliderAdapter:ScheduleSliderAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLessonBinding.inflate(inflater,container,false)

//        val parameters = Bundle()
//        parameters.putString("name", name)
//
//        newFragment.arguments = parameters
        scheduleSliderAdapter = ScheduleSliderAdapter(context as FragmentActivity)
        scheduleSliderAdapter?.getScheduleModel(getScheduleModel)
        binding?.slider?.adapter = scheduleSliderAdapter

        val tabLayoutMediator = binding?.tabSlider?.let {
            binding?.slider?.let {
                    it1 -> TabLayoutMediator(
                it,
                it1,
                TabLayoutMediator.TabConfigurationStrategy{ tab, position ->
                    when(position){
                        0 -> {
                            //tab.setIcon(R.drawable.dragon)
                            tab.text = getString(R.string.monday)
                        }
                        1 -> {
                            //tab.setIcon(R.drawable.startup)
                            tab.text = getString(R.string.tuesday)
                        }
                        2 -> {
                            //tab.setIcon(R.drawable.ghost)
                            tab.text = getString(R.string.wednesday)
                        }
                        3 -> {
                            //tab.setIcon(R.drawable.mask)
                            tab.text = getString(R.string.thursday)
                        }
                        4 -> {
                            //tab.setIcon(R.drawable.mask)
                            tab.text = getString(R.string.friday)
                        }
                        5 -> {
                            //tab.setIcon(R.drawable.mask)
                            tab.text = getString(R.string.saturday)
                        }
                    }
                })
            }
        }

        tabLayoutMediator?.attach()
        return binding?.root
    }



}