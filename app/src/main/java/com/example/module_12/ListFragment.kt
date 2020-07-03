package com.example.module_12

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.item_product.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ListFragment: Fragment (R.layout.fragment_list) {



    fun editWeight (weight: String) {
        currentWeight = weight
        foodUpdate()
        addFood()
//        Toast.makeText(context, "current weight = " + currentWeight, Toast.LENGTH_LONG).show()


    }

    private var currentWeight: String = "0"


    private var currentFood: List<Food> = emptyList()

    fun foodUpdate(){
        foods = listOf(
            Food.Dish (
                name = "Карбонара",
                weight = currentWeight,
                avatarLink = "https://domos.ru/images/blog/15944/Carbonara.jpg",
                structure = "Спагетти, бекон, яйцо, сливки"
            ),
            Food.Dish (
                name = "Винегрет́",
                weight = currentWeight,
                avatarLink = "https://avatars.mds.yandex.net/get-pdb/245485/10b9d137-9069-4ebc-a993-82a6076689f0/s1200?webp=false",
                structure = "свёкла, картофель, фасоль, морковь, огурцы"
            ),
            Food.Dish (
                name = "Ризотто",
                weight = currentWeight,
                avatarLink = "https://avatars.mds.yandex.net/get-pdb/1757027/4aa3f258-d4d7-4f0f-815d-a2aaa912c062/s1200?webp=false",
                structure = "Рис, масло, лук, чеснок, креветки"
            ),
            Food.Product (
                name = "Рыба",
                weight = currentWeight,
                avatarLink = "https://avatars.mds.yandex.net/get-pdb/1535406/32215f6e-737d-4229-8a4f-60c553984775/s1200?webp=false"
            ),
            Food.Product (
                name = "Рис",
                weight = currentWeight,
                avatarLink = "https://attuale.ru/wp-content/uploads/2019/01/Sollana-paella-rice-new-website.jpg"
            ),
            Food.Product (
                name = "Курица",
                weight = currentWeight,
                avatarLink = "https://i.baraholka.com.ru/files/1/8/1819452.jpg"
            )
        )
    }

    var foods = listOf(
        Food.Dish (
            name = "Карбонара",
            weight = currentWeight,
            avatarLink = "https://domos.ru/images/blog/15944/Carbonara.jpg",
            structure = "Спагетти, бекон, яйцо, сливки"
        ),
        Food.Dish (
            name = "Винегрет́",
            weight = currentWeight,
            avatarLink = "https://avatars.mds.yandex.net/get-pdb/245485/10b9d137-9069-4ebc-a993-82a6076689f0/s1200?webp=false",
            structure = "свёкла, картофель, фасоль, морковь, огурцы"
        ),
        Food.Dish (
            name = "Ризотто",
            weight = currentWeight,
            avatarLink = "https://avatars.mds.yandex.net/get-pdb/1757027/4aa3f258-d4d7-4f0f-815d-a2aaa912c062/s1200?webp=false",
            structure = "Рис, масло, лук, чеснок, креветки"
        ),
        Food.Product (
            name = "Рыба",
            weight = currentWeight,
            avatarLink = "https://avatars.mds.yandex.net/get-pdb/1535406/32215f6e-737d-4229-8a4f-60c553984775/s1200?webp=false"
        ),
        Food.Product (
            name = "Рис",
            weight = currentWeight,
            avatarLink = "https://attuale.ru/wp-content/uploads/2019/01/Sollana-paella-rice-new-website.jpg"
        ),
        Food.Product (
            name = "Курица",
            weight = currentWeight,
            avatarLink = "https://i.baraholka.com.ru/files/1/8/1819452.jpg"
        )
    )


    private var foodAdapter: FoodAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTextVisiable()
        initList()
        addFab.setOnClickListener { WeightDialogFragment().show(childFragmentManager, "Tag") }
        foodAdapter?.updateFoods(currentFood)
        foodAdapter?.notifyDataSetChanged()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        foodAdapter = null
    }

    override fun onDestroy() {
        super.onDestroy()
        childFragmentManager.findFragmentByTag("Tag")
            ?.let { it as? WeightDialogFragment }
            ?.dismiss()
    }

    fun isTextVisiable(){
        if (currentFood.isEmpty()) {
            textEmpty.visibility = View.VISIBLE
        } else if (currentFood.isNotEmpty()){
            textEmpty.visibility = View.GONE
        }
    }



//
//    private fun textEmpty() {
//        if (currentFood.isEmpty()) {
//            container.removeAllViews()
//            container.addView(textEmpty.apply {
//                layoutParams = LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT
//                ).apply {
//                    gravity = Gravity.CENTER
//                    text = "Список персон пуст"
//                }
//            })
//
//        }
//    }


    private fun initList() {
        foodAdapter = FoodAdapter { position -> deleteFood(position) }
        with(foodList) {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }



    private fun deleteFood( position: Int) {

        currentFood = currentFood.filterIndexed { index, food -> index != position }
        foodAdapter?.updateFoods(currentFood)
        foodAdapter?.notifyItemRemoved(position)
        isTextVisiable()
    }

    private fun addFood() {

        val newFood = foods.random()
        currentFood = listOf(newFood) + currentFood
        foodAdapter?.updateFoods(currentFood)
        foodAdapter?.notifyItemInserted(0 )
        isTextVisiable()
        foodList.scrollToPosition(0)
    }





}