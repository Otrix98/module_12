package com.example.module_12

import android.app.AlertDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.weight_fragment.*


class WeightDialogFragment: DialogFragment() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return  AlertDialog.Builder(requireActivity())
            .setView(R.layout.weight_fragment)
            .setTitle("Введите вес")
            .setPositiveButton("Применить", {_, _ ->
                showElement(editText.text.toString())
                        Log.d("weight","${editText.text.toString()}")})
            .setNegativeButton("Отмена", {_, _ -> })
            .create()
    }



    fun showElement(weight: String){
        parentFragment.let { it as ListFragment }.editWeight(weight)}
}