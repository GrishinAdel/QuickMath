package com.adelvanchik.quickmath.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toolbar

import com.adelvanchik.quickmath.R

class MainMenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onStart() {
        super.onStart()


        val Btn_go_to_menu_mode = view?.findViewById<Button>(R.id.Btn_go_to_menu_mode)
        Btn_go_to_menu_mode?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mainMenu_to_menu_mode)
        }

        val Btn_go_to_profile = view?.findViewById<ImageButton>(R.id.btn_go_to_profile)
        Btn_go_to_profile?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mainMenu_to_profile)
        }

        val Btn_go_to_achievements = view?.findViewById<ImageButton>(R.id.btn_go_to_achievements)
        Btn_go_to_achievements?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mainMenu_to_achievements)
        }

        val Btn_go_to_setting = view?.findViewById<ImageButton>(R.id.btn_go_to_setting)
        Btn_go_to_setting?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mainMenu_to_setting)
        }

        val Btn_go_to_info = view?.findViewById<ImageButton>(R.id.btn_go_to_info)
        Btn_go_to_info?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mainMenu_to_info_app)
        }
    }
}