package com.example.ecampus.presentation.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecampus.presentation.scheduleFragments.Search

class SearchSliderAdapter(fragmentActivity:FragmentActivity):FragmentStateAdapter(fragmentActivity) {

    private var query: String = ""

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> {
                Log.e("createFragment","Работает-0")
                Search(0,query)
            }
            1 -> {
                Log.e("createFragment","Работает-1")
                Search(1,query)
            }
            2 -> {
                Search(2,query)
            }
            else -> {
                Search(0,query)
            }
        }
    }

    fun getQuery(query: String){
        Log.e("getQue","Раотает---${query}")
        this.query = query

    }

}