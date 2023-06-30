package com.example.ecampus.presentation.scheduleFragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.databinding.FragmentSpecialtiesBinding
import com.example.ecampus.presentation.adapters.SpecialtiesAdapter
import com.example.ecampus.presentation.viewModels.SpecialtiesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class Specialties(private val getSpecialtiesModel: GetSpecialtiesModel): Fragment() {

    private var binding: FragmentSpecialtiesBinding? = null
    private val specialtiesViewModel: SpecialtiesViewModel by viewModel()
    private var specialtiesAdapter: SpecialtiesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpecialtiesBinding.inflate(inflater,container,false)

        initRecyclerSpecialties()
        loadSpecialties(getSpecialtiesModel)

        var name = arguments?.getString("name").toString()

        binding?.buttonBack?.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return binding?.root
    }


    private fun initRecyclerSpecialties(){
        binding?.recyclerSpecialties?.layoutManager = LinearLayoutManager(context)
        specialtiesAdapter = SpecialtiesAdapter(getSpecialtiesModel,{getSpecialtiesModel: GetSpecialtiesModel, name:String -> loadGroups(getSpecialtiesModel,name)})
        binding?.recyclerSpecialties?.adapter = specialtiesAdapter

    }

    private fun loadSpecialties(Model: GetSpecialtiesModel){
        showProgressBar()
        specialtiesViewModel.loadSpecialties(Model)
        specialtiesViewModel.specialties.observe(viewLifecycleOwner,Observer{
            specialtiesAdapter?.setList(it)
            specialtiesAdapter?.notifyDataSetChanged()
            hideProgressBar()
        })
    }

    private fun hideProgressBar() {
        binding?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBar?.visibility = View.VISIBLE
    }

    private fun loadGroups(getSpecialtiesModel: GetSpecialtiesModel,name:String){

        val parameters = Bundle()
        parameters.putString("name", name)

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val newFragment = Groups(getSpecialtiesModel)

        newFragment.arguments = parameters

        fragmentTransaction.replace(R.id.contentFragment, newFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }




}



