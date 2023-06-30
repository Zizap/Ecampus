package com.example.ecampus.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.ecampus.R
import com.example.ecampus.databinding.FragmentMainMenuBinding
import com.example.ecampus.presentation.scheduleFragments.Institute
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MainMenu : BottomSheetDialogFragment() {

    private var binding:FragmentMainMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainMenuBinding.inflate(inflater,container,false)

        binding?.mainMenuNav?.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.schedule -> {
                    (context as FragmentActivity).supportFragmentManager.beginTransaction().replace(
                        R.id.contentFragment, Institute()
                    ).commit()
                    dismiss()
                }

            }

            true
        }

        return binding?.root
    }


}