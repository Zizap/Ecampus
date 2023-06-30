package com.example.ecampus.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.ecampus.R
import com.example.ecampus.data.models.scheduleModel.Schedule
import com.example.ecampus.data.models.scheduleModel.Weekday
import com.example.ecampus.databinding.LessonItemBinding

class LessonAdapter(): RecyclerView.Adapter<LessonHolder>() {

    private var scheduleList = ArrayList<Schedule>()
    private var weekdayList = ArrayList<Weekday>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonHolder {
        val binding: LessonItemBinding = LessonItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return LessonHolder(binding)
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    override fun onBindViewHolder(holder: LessonHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.recycler_item_anim)
        holder.itemView.startAnimation(animation)
        holder.bind(scheduleList[position])
    }

    fun setList(schedule: ArrayList<Schedule>,weekday: ArrayList<Weekday>){
        scheduleList.clear()
        scheduleList.addAll(schedule)
        weekdayList.addAll(weekday)
    }


}

class LessonHolder(val binding: LessonItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(lesson: Schedule){

        val aud = lesson.aud

        binding.discipline.text = lesson.discipline.toString()

        if (lesson.pairNumberStart.toString() != lesson.pairNumberEnd.toString()){
            binding.pair.text = "${lesson.pairNumberStart.toString()} - ${lesson.pairNumberEnd.toString()} пара"
        } else {
            binding.pair.text = "${lesson.pairNumberStart.toString()} пара"
        }
        binding.lessonnType.text = lesson.lessonType.toString()
        Log.e("lessonType",lesson.lessonType.toString())
        binding.aud.text = aud.name.toString()
    }


}