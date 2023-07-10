package com.example.ecampus.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.ecampus.R
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.data.models.mapPlace.MapPlaces
import com.example.ecampus.databinding.CorpsItemBinding
import com.example.ecampus.databinding.InstitutesItemBinding

class CorpsAdapter(private val movePlace:(MapPlaces)->Unit): RecyclerView.Adapter<CorpsHolder>() {

    private var corpsList = ArrayList<MapPlaces>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorpsHolder {
        val binding: CorpsItemBinding = CorpsItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return CorpsHolder(binding)
    }

    override fun getItemCount(): Int {
        return corpsList.size
    }

    override fun onBindViewHolder(holder: CorpsHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.recycler_item_anim)
        holder.itemView.startAnimation(animation)
        holder.bind(corpsList[position],movePlace)
    }

    fun setList(corps: List<MapPlaces>){
        corpsList.clear()
        corpsList.addAll(corps)
    }


}

class CorpsHolder(val binding: CorpsItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(mapPlaces: MapPlaces,
             movePlace: (MapPlaces) -> Unit,
    ){

        binding.nameInstitutes.text = mapPlaces.id.toString()

        binding.nameInstitutes.setOnClickListener {
            movePlace(mapPlaces)
        }

    }


}