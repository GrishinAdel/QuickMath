package com.adelvanchik.quickmath.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.adelvanchik.quickmath.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class Setting : Fragment() {

    private val vm by viewModel<SettingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onStart() {
        super.onStart()

        val btn_go_home = view?.findViewById<ImageButton>(R.id.btn_setting_go_to_home)
        btn_go_home?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_setting_to_mainMenu)
        }
    }

}