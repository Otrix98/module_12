package com.example.module_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
        showMainFragment()}
    }
    private fun showMainFragment(){
        supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment())
                .addToBackStack(null)
                .commit()
    }
     fun showFoodFragment(){
       supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListFragment())
           .addToBackStack(null)
            .commit()
    }

    fun showLinearLayoutFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LinearLayoutFragment())
            .addToBackStack(null)
            .commit()
    }

    fun showGridFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, GridLayoutFragment())
            .addToBackStack(null)
            .commit()
    }
    fun showStuggeredFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, StaggeredGridFragment())
            .addToBackStack(null)
            .commit()
    }
}