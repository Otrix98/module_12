package com.example.module_12

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.weight_fragment.*
import kotlinx.android.synthetic.main.weight_fragment.view.*


class WeightDialogFragment: DialogFragment() {
//    private lateinit var dialogView: View
////
////    override fun onCreateView(
////        inflater: LayoutInflater,
////        container: ViewGroup?,
////        savedInstanceState: Bundle?
////    ): View? {
////        super.onCreateView(inflater, container, savedInstanceState)
////        dialogView = activity!!.layoutInflater.inflate(R.layout.weight_fragment, null)
//////        dialogView = inflater.inflate(R.layout.weight_fragment, container)
////        return dialogView
////    }
////
////    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
////        dialogView = activity!!.layoutInflater.inflate(R.layout.weight_fragment, null)
////        val editText  = dialogView.findViewById<EditText>(R.id.editText)
////        return AlertDialog.Builder(requireContext())
////            .setView(dialogView)
////            .setTitle("Введите вес")
////            .setPositiveButton("Применить", object : DialogInterface.OnClickListener {
////                override fun onClick(p0: DialogInterface?, p1: Int) {
//////                    Toast.makeText(context, "EditText is " + editText.text.toString(), Toast.LENGTH_SHORT).show()
////                    showElement(editText.text.toString())
////                    p0?.dismiss()
////                }
////            })
////            .setNegativeButton("Отмена", object : DialogInterface.OnClickListener {
////                override fun onClick(p0: DialogInterface?, p1: Int) {
////                    p0?.dismiss()
////                }
////            })
////            .create()
////    }
////
////
////    fun showElement(weight: String){
////        parentFragment.let { it as ListFragment }.editWeight(weight)}
}