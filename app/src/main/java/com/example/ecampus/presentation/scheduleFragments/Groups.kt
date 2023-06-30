package com.example.ecampus.presentation.scheduleFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.databinding.FragmentGroupsBinding
import com.example.ecampus.presentation.adapters.GroupsAdapter
import com.example.ecampus.presentation.viewModels.GroupsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class Groups(private val getSpecialtiesModel: GetSpecialtiesModel) : Fragment() {

    private var binding: FragmentGroupsBinding? = null
    private val groupsViewModel: GroupsViewModel by viewModel()
    private var groupsAdapter: GroupsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupsBinding.inflate(inflater,container,false)

        initRecyclerGroups()
        loadGroups(getSpecialtiesModel)

        var name = arguments?.getString("name").toString()

        binding?.buttonBack?.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return binding?.root
    }


    private fun initRecyclerGroups(){
        binding?.recyclerGroups?.layoutManager = LinearLayoutManager(context)
        groupsAdapter = GroupsAdapter({getScheduleModel: GetScheduleModel,name:String -> loadLesson(getScheduleModel,name)})
        binding?.recyclerGroups?.adapter = groupsAdapter

    }

    private fun loadGroups(getSpecialtiesModel: GetSpecialtiesModel){
        showProgressBar()
        groupsViewModel.loadGroups(getSpecialtiesModel)
        groupsViewModel.groups.observe(viewLifecycleOwner,Observer{
            groupsAdapter?.setList(it)
            groupsAdapter?.notifyDataSetChanged()
            hideProgressBar()
        })

    }

    private fun hideProgressBar() {
        binding?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBar?.visibility = View.VISIBLE
    }

    private fun loadLesson(getScheduleModel: GetScheduleModel,name:String){

        val parameters = Bundle()
        parameters.putString("name", name)

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val newFragment = Lesson(getScheduleModel)

        newFragment.arguments = parameters

        fragmentTransaction.replace(R.id.contentFragment, newFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }






}
