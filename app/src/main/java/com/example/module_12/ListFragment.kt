package com.example.module_12

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module_12.adapters.FoodAdapter
import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: Fragment (R.layout.fragment_list) {

private val foodListViewModel: FoodListViewModel by viewModels()


    private var foodAdapter: FoodAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initList()
        addFab.setOnClickListener {  addFood()}
        observeViewModelState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        foodAdapter = null

    }
    private fun initList() {
        foodAdapter = FoodAdapter(object : FoodAdapter.OnItemClicked{
            override fun onClick(item: Food) {

            val action = ListFragmentDirections.actionListFragmentToDetailsFragment(id.toLong())

            findNavController().navigate(action)
            }

            override fun onLongClick(position: Int) {
                deleteFood(position)
            }
        })

        with(foodList) {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            itemAnimator = FlipInLeftYAnimator()
        }
    }

     fun deleteFood (id: Int) {
        foodListViewModel.deleteFood(id)
        observeViewModelState()
    }

    private fun addFood() {
        foodListViewModel.addFood()
        observeViewModelState()
        foodList.scrollToPosition(0)
    }

    private fun observeViewModelState(){
        foodListViewModel.foods
            .observe(viewLifecycleOwner) {newFoods -> foodAdapter?.items = newFoods}

        foodListViewModel.showToast
            .observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), "Элемент удалён", Toast.LENGTH_SHORT).show()
            }
    }

}