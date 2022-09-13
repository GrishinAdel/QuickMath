package com.adelvanchik.quickmath.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.adelvanchik.quickmath.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class Profile : Fragment() {

    private val vm by viewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onStart() {
        super.onStart()

        val lvlInfoTextView = view?.findViewById<TextView>(R.id.lvlInfo_TextView)
        val lvlIntTextView = view?.findViewById<TextView>(R.id.lvlInt_textView)

        val btn_profile_go_to_home = view?.findViewById<ImageButton>(R.id.btn_profile_go_to_home)
        val btn_wath_stat= view?.findViewById<Button>(R.id.btn_watch_stat)

        vm.info()


        vm.get_lvlInfo().observe(viewLifecycleOwner, {
            if (it.equals("0")) lvlInfoTextView?.text = "Амеба"
            else lvlInfoTextView?.text = it
        })
        vm.get_lvlInt().observe(viewLifecycleOwner, {
            lvlIntTextView?.text = it.toString()
        })


        btn_profile_go_to_home?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_profile_to_mainMenu)
        }

        btn_wath_stat?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_profile_to_stat)
        }


    }

}