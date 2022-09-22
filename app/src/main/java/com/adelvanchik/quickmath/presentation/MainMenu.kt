package com.adelvanchik.quickmath.presentation

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView


import com.adelvanchik.quickmath.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMenu : Fragment() {

    private val vm by viewModel<MainViewModel>()
    private var sound = false
    private var logoMusicPlay: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onStart() {
        super.onStart()

        vm.start()

        val logo = view?.findViewById<ImageButton>(R.id.logo)

        val logoMusic = getResources().getIdentifier(R.raw.logo_music.toString(),
            "raw", activity?.packageName)
        val logoMusic2 = getResources().getIdentifier(R.raw.logo_music2.toString(),
            "raw", activity?.packageName)
        val logoMusic3 = getResources().getIdentifier(R.raw.logo_music3.toString(),
            "raw", activity?.packageName)
        logoMusicPlay = MediaPlayer.create(context, logoMusic)

        logo?.setOnClickListener {
            if (sound) {
                if (logoMusicPlay?.isPlaying == true) logoMusicPlay?.stop()
                val randomSound = (0..2).shuffled().first()
                when(randomSound) {
                    0 -> logoMusicPlay = MediaPlayer.create(context, logoMusic)
                    1 -> logoMusicPlay = MediaPlayer.create(context, logoMusic2)
                    2 -> logoMusicPlay = MediaPlayer.create(context, logoMusic3)
                }
                logoMusicPlay?.start()
            }
            val randomRotate = (0..1).shuffled().first()
            var anim = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate)
            if(randomRotate==1) anim = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_left)
            logo.startAnimation(anim)

        }


        val Btn_go_to_menu_mode = view?.findViewById<ImageButton>(R.id.Btn_go_to_menu_mode)
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

        val namePerson = view?.findViewById<TextView>(R.id.namePerson_main_menu)
        vm.get_namePerson().observe(viewLifecycleOwner, {
            if (!it.equals("0")) namePerson?.text = it
        })

        vm.get_soundMode().observe(viewLifecycleOwner, {
            if (it.equals("off")) sound = false
            else sound = true
        })
    }

    override fun onStop() {
        super.onStop()

        logoMusicPlay?.stop()
    }

}