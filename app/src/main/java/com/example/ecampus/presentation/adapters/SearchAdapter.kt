package com.example.ecampus.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.ecampus.R
import com.example.ecampus.data.models.searchModel.DataForSearch
import com.example.ecampus.databinding.InstitutesItemBinding

class SearchAdapter(): RecyclerView.Adapter<SearchHolder>() {

    private var searchList = ArrayList<DataForSearch>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        Log.e("Adapter","onCreateViewHolder")
        val binding: InstitutesItemBinding = InstitutesItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return SearchHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.e("Adapter","getItemCount ${searchList.size}")
        return searchList.size
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.recycler_item_anim)
        holder.itemView.startAnimation(animation)
        Log.e("Adapter","onBindViewHolder")
        holder.bind(searchList[position])
    }

    fun setList(searchApiModel: List<DataForSearch>){
        searchList.addAll(searchApiModel)
        notifyDataSetChanged()
        Log.e("Adapter","SetList")
    }


}

class SearchHolder(val binding: InstitutesItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(searchModel: DataForSearch){
        Log.e("Adapter","Bind")
        binding.nameInstitutes.text = searchModel.name.toString()
    }


}