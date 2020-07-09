package com.example.module_12

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module_12.adapters.FoodAdapter
import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator
import kotlinx.android.synthetic.main.fragment_list.*
import kotlin.random.Random

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
                id = 1,
                name = "Карбонара",
                weight = currentWeight,
                avatarLink = "https://domos.ru/images/blog/15944/Carbonara.jpg",
                structure = "Спагетти, бекон, яйцо, сливки"
            ),
            Food.Dish (
                id = 2,
                name = "Винегрет́",
                weight = currentWeight,
                avatarLink = "https://avatars.mds.yandex.net/get-pdb/245485/10b9d137-9069-4ebc-a993-82a6076689f0/s1200?webp=false",
                structure = "свёкла, картофель, фасоль, морковь, огурцы"
            ),
            Food.Dish (
                id = 3,
                name = "Ризотто",
                weight = currentWeight,
                avatarLink = "https://avatars.mds.yandex.net/get-pdb/1757027/4aa3f258-d4d7-4f0f-815d-a2aaa912c062/s1200?webp=false",
                structure = "Рис, масло, лук, чеснок, креветки"
            ),
            Food.Product (
                id = 4,
                name = "Рыба",
                weight = currentWeight,
                avatarLink = "https://avatars.mds.yandex.net/get-pdb/1535406/32215f6e-737d-4229-8a4f-60c553984775/s1200?webp=false"
            ),
            Food.Product (
                id = 5,
                name = "Рис",
                weight = currentWeight,
                avatarLink = "https://attuale.ru/wp-content/uploads/2019/01/Sollana-paella-rice-new-website.jpg"
            ),
            Food.Product (
                id = 6,
                name = "Курица",
                weight = currentWeight,
                avatarLink = "https://i.baraholka.com.ru/files/1/8/1819452.jpg"
            )
        )
    }

    var foods = listOf(
        Food.Dish (
            id = 1,
            name = "Карбонара",
            weight = currentWeight,
            avatarLink = "https://domos.ru/images/blog/15944/Carbonara.jpg",
            structure = "Спагетти, бекон, яйцо, сливки"
        ),
        Food.Dish (
            id = 2,
            name = "Винегрет́",
            weight = currentWeight,
            avatarLink = "https://avatars.mds.yandex.net/get-pdb/245485/10b9d137-9069-4ebc-a993-82a6076689f0/s1200?webp=false",
            structure = "свёкла, картофель, фасоль, морковь, огурцы"
        ),
        Food.Dish (
            id = 3,
            name = "Ризотто",
            weight = currentWeight,
            avatarLink = "https://avatars.mds.yandex.net/get-pdb/1757027/4aa3f258-d4d7-4f0f-815d-a2aaa912c062/s1200?webp=false",
            structure = "Рис, масло, лук, чеснок, креветки"
        ),
        Food.Product (
            id = 4,
            name = "Рыба",
            weight = currentWeight,
            avatarLink = "https://avatars.mds.yandex.net/get-pdb/1535406/32215f6e-737d-4229-8a4f-60c553984775/s1200?webp=false"
        ),
        Food.Product (
            id = 5,
            name = "Рис",
            weight = currentWeight,
            avatarLink = "https://attuale.ru/wp-content/uploads/2019/01/Sollana-paella-rice-new-website.jpg"
        ),
        Food.Product (
            id = 6,
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
        foodAdapter?.items = (currentFood)
//        foodAdapter?.notifyDataSetChanged()

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
        foodAdapter = FoodAdapter { position ->
            deleteFood(position)
        }
        with(foodList) {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            itemAnimator = FlipInLeftYAnimator()
        }
    }



    private fun deleteFood( position: Int) {

        currentFood = currentFood.filterIndexed { index, food -> index != position }
        foodAdapter?.items = (currentFood)
//        foodAdapter?.notifyItemRemoved(position)
        isTextVisiable()
    }

    private fun addFood() {

        val newFood = foods.random().let {
            when(it) {
                is Food.Product -> it.copy(id = Random.nextLong())
                is Food.Dish -> it.copy(id = Random.nextLong())
            }
        }
        currentFood = listOf(newFood) + currentFood
        foodAdapter?.items = (currentFood)
//        foodAdapter?.notifyItemInserted(0 )
        isTextVisiable()
        foodList.scrollToPosition(0)
    }



}