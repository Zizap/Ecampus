package com.example.ecampus.presentation.scheduleFragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetSearchModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.searchModel.DataForSearch
import com.example.ecampus.databinding.InstituteFragmentBinding
import com.example.ecampus.presentation.adapters.InstitutesAdapter
import com.example.ecampus.presentation.adapters.ScheduleSliderAdapter
import com.example.ecampus.presentation.adapters.SearchAdapter
import com.example.ecampus.presentation.adapters.SearchSliderAdapter
import com.example.ecampus.presentation.viewModels.InstitutesViewModel
import com.example.ecampus.presentation.viewModels.SearchViewModel
import com.google.android.material.tabs.TabLayoutMediator
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

        initSliderForSearch("А")


        binding?.searchTF?.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s?.toString()?:""

                if (query != ""){
                    hideRecycler()
                    initSliderForSearch(query)
                }
                else {
                    showRecycler()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })


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


    private fun initSliderForSearch(query:String){
        val searchSliderAdapter: SearchSliderAdapter = SearchSliderAdapter(context as FragmentActivity)
        searchSliderAdapter.getQuery(query)
        binding?.slider?.adapter = searchSliderAdapter

        val tabLayoutMediator = binding?.tabSlider?.let {
            binding?.slider?.let {
                    it1 -> TabLayoutMediator(
                it,
                it1,
                TabLayoutMediator.TabConfigurationStrategy{ tab, position ->
                    when(position){
                        0 -> {
                            //tab.setIcon(R.drawable.dragon)
                            tab.text = getString(R.string.teacher)
                        }
                        1 -> {
                            //tab.setIcon(R.drawable.startup)
                            tab.text = getString(R.string.groups)
                        }
                        2 -> {
                            //tab.setIcon(R.drawable.ghost)
                            tab.text = getString(R.string.room)
                        }
                    }
                })
            }
        }
        tabLayoutMediator?.attach()
    }

    private fun showRecycler(){
        binding?.constraintRecyclerInstitute?.visibility = View.VISIBLE
        binding?.searchContent?.visibility = View.GONE
    }

    private fun hideRecycler(){
        binding?.constraintRecyclerInstitute?.visibility = View.GONE
        binding?.searchContent?.visibility = View.VISIBLE
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






