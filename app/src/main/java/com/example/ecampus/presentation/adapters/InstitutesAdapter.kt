package com.example.ecampus.presentation.adapters

import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.institutesModels.InstitutesApiModel
import com.example.ecampus.databinding.InstitutesItemBinding
import kotlinx.coroutines.delay


class InstitutesAdapter(private val loadSpecialties:(GetSpecialtiesModel,String)->Unit): RecyclerView.Adapter<InstitutesHolder>() {

    private var institutesList = ArrayList<InstitutesApiModel>()
    private val handler = Handler()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstitutesHolder {
        val binding: InstitutesItemBinding = InstitutesItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return InstitutesHolder(binding)
    }

    override fun getItemCount(): Int {
        return institutesList.size
    }

    override fun onBindViewHolder(holder: InstitutesHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.recycler_item_anim)
        holder.itemView.startAnimation(animation)
        holder.bind(institutesList[position],loadSpecialties)


//        YoYo.with(Techniques.Tada).
//        duration(700).
//        playOn(holder.itemView)

    }

    fun setList(institutes: ArrayList<InstitutesApiModel>){
        institutesList.clear()
        institutesList.addAll(institutes)
    }
}

class InstitutesHolder(val binding: InstitutesItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(institute: InstitutesApiModel,
             loadSpecialties:(GetSpecialtiesModel,String)->Unit){


        binding.nameInstitutes.text = institute.name.toString()

        binding.nameInstitutes.setOnClickListener(View.OnClickListener {
            val getSpecialtiesModel = GetSpecialtiesModel(institute.branchId,institute.id,null)
            Log.e("PROVERKA","${getSpecialtiesModel.BranchId},${getSpecialtiesModel.InstituteId},${getSpecialtiesModel.DepartmentId}")
            loadSpecialties(getSpecialtiesModel,institute.name.toString())


        })
    }
}