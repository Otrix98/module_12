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

//    fun editWeight (weight: String) {
//        currentWeight = weight
//        foodUpdate()
//        addFood()
//    }
//
//
//    private var currentWeight: String = "0"
//
//
//    private var currentFood: List<Food> = emptyList()
//
//    fun foodUpdate(){
//        foods = listOf(
//            Food.Dish (
//                id = 1,
//                name = "Карбонара",
//                weight = currentWeight,
//                avatarLink = "https://domos.ru/images/blog/15944/Carbonara.jpg",
//                structure = "Спагетти, бекон, яйцо, сливки"
//            ),
//            Food.Dish (
//                id = 2,
//                name = "Винегрет́",
//                weight = currentWeight,
//                avatarLink = "https://avatars.mds.yandex.net/get-pdb/245485/10b9d137-9069-4ebc-a993-82a6076689f0/s1200?webp=false",
//                structure = "свёкла, картофель, фасоль, морковь, огурцы"
//            ),
//            Food.Dish (
//                id = 3,
//                name = "Ризотто",
//                weight = currentWeight,
//                avatarLink = "https://avatars.mds.yandex.net/get-pdb/1757027/4aa3f258-d4d7-4f0f-815d-a2aaa912c062/s1200?webp=false",
//                structure = "Рис, масло, лук, чеснок, креветки"
//            ),
//            Food.Product (
//                id = 4,
//                name = "Рыба",
//                weight = currentWeight,
//                avatarLink = "https://avatars.mds.yandex.net/get-pdb/1535406/32215f6e-737d-4229-8a4f-60c553984775/s1200?webp=false"
//            ),
//            Food.Product (
//                id = 5,
//                name = "Рис",
//                weight = currentWeight,
//                avatarLink = "https://attuale.ru/wp-content/uploads/2019/01/Sollana-paella-rice-new-website.jpg"
//            ),
//            Food.Product (
//                id = 6,
//                name = "Курица",
//                weight = currentWeight,
//                avatarLink = "https://i.baraholka.com.ru/files/1/8/1819452.jpg"
//            )
//        )
//    }
//
//    var foods = listOf(
//        Food.Dish (
//            id = 1,
//            name = "Карбонара",
//            weight = currentWeight,
//            avatarLink = "https://domos.ru/images/blog/15944/Carbonara.jpg",
//            structure = "Спагетти, бекон, яйцо, сливки"
//        ),
//        Food.Dish (
//            id = 2,
//            name = "Винегрет́",
//            weight = currentWeight,
//            avatarLink = "https://avatars.mds.yandex.net/get-pdb/245485/10b9d137-9069-4ebc-a993-82a6076689f0/s1200?webp=false",
//            structure = "свёкла, картофель, фасоль, морковь, огурцы"
//        ),
//        Food.Dish (
//            id = 3,
//            name = "Ризотто",
//            weight = currentWeight,
//            avatarLink = "https://avatars.mds.yandex.net/get-pdb/1757027/4aa3f258-d4d7-4f0f-815d-a2aaa912c062/s1200?webp=false",
//            structure = "Рис, масло, лук, чеснок, креветки"
//        ),
//        Food.Product (
//            id = 4,
//            name = "Рыба",
//            weight = currentWeight,
//            avatarLink = "https://avatars.mds.yandex.net/get-pdb/1535406/32215f6e-737d-4229-8a4f-60c553984775/s1200?webp=false"
//        ),
//        Food.Product (
//            id = 5,
//            name = "Рис",
//            weight = currentWeight,
//            avatarLink = "https://attuale.ru/wp-content/uploads/2019/01/Sollana-paella-rice-new-website.jpg"
//        ),
//        Food.Product (
//            id = 6,
//            name = "Курица",
//            weight = currentWeight,
//            avatarLink = "https://i.baraholka.com.ru/files/1/8/1819452.jpg"
//        )
//    )
//
//
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
        foodAdapter = FoodAdapter { id ->

            val action = ListFragmentDirections.actionListFragmentToDetailsFragment(id)

            findNavController().navigate(action)
//            findNavController().popBackStack()
        }
        with(foodList) {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            itemAnimator = FlipInLeftYAnimator()
        }
    }

     fun deleteFood(id: Int) {
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
                Toast.makeText(requireContext(), "Элемент добавлен", Toast.LENGTH_SHORT).show()
            }
    }



//    fun isTextVisiable(){
//        if (foodList.isEmpty()) {
//            textEmpty.visibility = View.VISIBLE
//        } else if (foodList.isNotEmpty()){
//            textEmpty.visibility = View.GONE
//        }
//    }
//
//
//
//    private fun deleteFood( position: Int) {
//
//        currentFood = currentFood.filterIndexed { index, food -> index != position }
//        foodAdapter?.items = (currentFood)
//        isTextVisiable()
//    }
//
//    private fun addFood() {
//
//        val newFood = foods.random().let {
//            when(it) {
//                is Food.Product -> it.copy(id = Random.nextLong())
//                is Food.Dish -> it.copy(id = Random.nextLong())
//            }
//        }
//        currentFood = listOf(newFood) + currentFood
//        foodAdapter?.items = (currentFood)
//        isTextVisiable()
//        foodList.scrollToPosition(0)
//    }



}