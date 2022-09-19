package com.adelvanchik.quickmath.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.adelvanchik.quickmath.R

class Info_app : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_app, container, false)
    }

    override fun onStart() {
        super.onStart()

        val btn_go_home = view?.findViewById<ImageButton>(R.id.btn_infoApp_go_to_home)
        btn_go_home?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_info_app_to_mainMenu)
        }

        val btn_go_telegram = view?.findViewById<Button>(R.id.btn_go_telegram)
        btn_go_telegram?.setOnClickListener {
            val url = "https://t.me/adelvanchik"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

    }

}