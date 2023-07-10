package com.example.ecampus.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.databinding.InstitutesItemBinding

class SpecialtiesAdapter(private val getSpecialtiesModel: GetSpecialtiesModel, private val loadGroups:(GetSpecialtiesModel,String)->Unit): RecyclerView.Adapter<SpecialtiesHolder>() {

    private var specialtiesList = ArrayList<SpecialtiesApiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtiesHolder {
        val binding: InstitutesItemBinding = InstitutesItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return SpecialtiesHolder(binding)
    }

    override fun getItemCount(): Int {
        return specialtiesList.size
    }

    override fun onBindViewHolder(holder: SpecialtiesHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.recycler_item_anim)
        holder.itemView.startAnimation(animation)
        holder.bind(specialtiesList[position],getSpecialtiesModel,loadGroups,specialtiesList[specialtiesList.size-1])
    }

    fun setList(institutes: ArrayList<SpecialtiesApiModel>){
        specialtiesList.clear()
        specialtiesList.addAll(institutes)
    }


}

class SpecialtiesHolder(val binding: InstitutesItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(specialties: SpecialtiesApiModel,
             getSpecialtiesModel: GetSpecialtiesModel,
             loadGroups:(GetSpecialtiesModel,String)->Unit,
             specialtiesLast:SpecialtiesApiModel){

        when {
            specialties.name == specialtiesLast.name -> {
                binding.nameInstitutes.setBackgroundResource(R.drawable.button_bottom_style)
            }
            else -> {
                binding.nameInstitutes.setBackgroundResource(R.drawable.button_style)
            }
        }

        binding.nameInstitutes.text = specialties.name.toString()

        binding.nameInstitutes.setOnClickListener {
            val Model = GetSpecialtiesModel(getSpecialtiesModel.BranchId,getSpecialtiesModel.InstituteId,specialties.id)
            Log.e("PROVERKA","${Model.BranchId},${Model.InstituteId},${Model.DepartmentId}")
            loadGroups(Model,specialties.name.toString())
        }

    }


}