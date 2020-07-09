package com.example.module_12

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment (R.layout.fragment_main) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button1.setOnClickListener {
            (activity as MainActivity).showFoodFragment()
        }
        button2.setOnClickListener {
            (activity as MainActivity).showLinearLayoutFragment()
        }
        button3.setOnClickListener {
            (activity as MainActivity).showGridFragment()
        }
        button4.setOnClickListener {
            (activity as MainActivity).showStuggeredFragment()
        }
    }
}