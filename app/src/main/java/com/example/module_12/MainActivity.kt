package com.example.module_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
        showListFragment()}
    }
    private fun showListFragment(){
        supportFragmentManager.beginTransaction()
                .add(R.id.container, ListFragment())
                .commit()
    }
}