package com.example.ecampus.presentation.scheduleFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetSearchModel
import com.example.ecampus.data.models.searchModel.DataForSearch
import com.example.ecampus.databinding.FragmentSearchBinding
import com.example.ecampus.presentation.adapters.SearchAdapter
import com.example.ecampus.presentation.viewModels.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.FieldPosition


class Search(private val position: Int,private val query: String) : Fragment() {

    private var binding: FragmentSearchBinding? = null
    private val searchViewModel: SearchViewModel by viewModel()
    private var searchAdapter: SearchAdapter? = null
    private var page: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater,container,false)

        initRecycler()
        startLoadData(query,page)

        binding?.tvLoadTeacher?.setOnClickListener {
            page++
            startLoadData(query,page)
        }

        return binding?.root
    }

    private fun initRecycler(){
        binding?.teacher?.layoutManager = LinearLayoutManager(context)
        searchAdapter = SearchAdapter()
        binding?.teacher?.adapter = searchAdapter
    }

    private fun startLoadData(query:String,page:Int){
        when (position){
            0 -> {
                binding?.tvTeacher?.setText(R.string.teacher)
                loadDataForSearch(GetSearchModel(query,10,1,page))
            }
            1 -> {
                binding?.tvTeacher?.setText(R.string.groups)
                loadDataForSearch(GetSearchModel(query,10,2,page))
            }
            2 -> {
                binding?.tvTeacher?.setText(R.string.room)
                loadDataForSearch(GetSearchModel(query,10,3,page))
            }
        }
    }

    private fun loadDataForSearch(getSearchModel: GetSearchModel){
        showProgressBar()
        searchViewModel.search(getSearchModel)
        searchViewModel.searchApiModel.observe(viewLifecycleOwner, Observer {
            val list = ArrayList<DataForSearch>()
            it.fullList.forEach { item ->
                list.addAll(item.items)
            }
            searchAdapter?.setList(list)
            searchAdapter?.notifyDataSetChanged()

            hideProgressBar()

        })
    }

    private fun hideProgressBar() {
        binding?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBar?.visibility = View.VISIBLE
    }
}