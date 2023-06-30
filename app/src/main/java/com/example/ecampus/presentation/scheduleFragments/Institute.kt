package com.example.ecampus.presentation.scheduleFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.databinding.InstituteFragmentBinding
import com.example.ecampus.presentation.adapters.InstitutesAdapter
import com.example.ecampus.presentation.viewModels.InstitutesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class Institute : Fragment() {


    private var binding: InstituteFragmentBinding? = null
    private val institutesViewModel: InstitutesViewModel by viewModel()
    private var institutesAdapter: InstitutesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InstituteFragmentBinding.inflate(inflater,container,false)

        initRecyclerInstitute()
        loadInstitute()

        return binding?.root
    }


    private fun initRecyclerInstitute(){
        binding?.recyclerInstitutes?.layoutManager = LinearLayoutManager(context)
        institutesAdapter = InstitutesAdapter({getSpecialtiesModel: GetSpecialtiesModel,name: String -> loadSpecialties(getSpecialtiesModel,name)})
        binding?.recyclerInstitutes?.adapter = institutesAdapter
    }

    private fun loadInstitute(){
        showProgressBar()
        institutesViewModel.loadInstitutes()
        institutesViewModel.institutes.observe(viewLifecycleOwner, Observer {
            institutesAdapter?.setList(it)
            institutesAdapter?.notifyDataSetChanged()
            hideProgressBar()
        })

    }

    private fun hideProgressBar() {
        binding?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBar?.visibility = View.VISIBLE
    }

    private fun loadSpecialties(getSpecialtiesModel: GetSpecialtiesModel,name:String){

        val parameters = Bundle()
        parameters.putString("name", name)

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val newFragment = Specialties(getSpecialtiesModel)

        newFragment.arguments = parameters

        fragmentTransaction.replace(R.id.contentFragment, newFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }




}






