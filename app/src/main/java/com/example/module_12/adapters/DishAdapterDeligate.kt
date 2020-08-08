package com.example.module_12.adapters

import android.view.View
import android.view.ViewGroup
import com.example.module_12.Food
import com.example.module_12.R
import com.example.module_12.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.synthetic.main.item_product.*

class DishAdapterDeligate( private val clickListener: FoodAdapter.OnItemClicked): AbsListItemAdapterDelegate<Food.Dish, Food, DishAdapterDeligate.DishHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): DishHolder {
        return  DishHolder(
            parent.inflate(R.layout.item_dish),
            clickListener
        )
    }

    override fun isForViewType(item: Food, items: MutableList<Food>, position: Int): Boolean {
       return item is Food.Dish
    }

    override fun onBindViewHolder(item: Food.Dish, holder: DishHolder, payloads: MutableList<Any>) {
       holder.bind(item, clickListener)
    }
    class DishHolder(
        view: View,
        onItemClicked: FoodAdapter.OnItemClicked
    ): BaseFoodHolder(view, onItemClicked) {

        fun bind(food: Food.Dish, clickListener: FoodAdapter.OnItemClicked) {
            bindMainInfo(food.id, food.name, food.avatarLink, food.weight )
            structureTextView.text = "Состав: ${food.structure}"
            itemView.setOnClickListener { clickListener.onClick(food) }
            itemView.setOnLongClickListener { clickListener.onLongClick(adapterPosition);true}
        }
    }

}