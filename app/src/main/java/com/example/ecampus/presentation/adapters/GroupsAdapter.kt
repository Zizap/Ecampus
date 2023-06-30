package com.example.ecampus.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.data.models.institutesModels.InstitutesApiModel
import com.example.ecampus.databinding.InstitutesItemBinding

class GroupsAdapter(private val loadLesson:(GetScheduleModel,String)->Unit): RecyclerView.Adapter<GroupsHolder>() {

    private var GroupsList = ArrayList<GroupsApiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupsHolder {
        val binding: InstitutesItemBinding = InstitutesItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return GroupsHolder(binding)
    }

    override fun getItemCount(): Int {
        return GroupsList.size
    }

    override fun onBindViewHolder(holder: GroupsHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.recycler_item_anim)
        holder.itemView.startAnimation(animation)
        holder.bind(GroupsList[position],loadLesson)
    }

    fun setList(institutes: ArrayList<GroupsApiModel>){
        GroupsList.clear()
        GroupsList.addAll(institutes)
    }


}

class GroupsHolder(val binding: InstitutesItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(group: GroupsApiModel,
             loadLesson: (GetScheduleModel,String) -> Unit){

        binding.nameInstitutes.text = group.name.toString()

        val getScheduleModel = GetScheduleModel(group.id,null,null)

        binding.nameInstitutes.setOnClickListener {
            loadLesson(getScheduleModel,group.name.toString())
        }


    }


}