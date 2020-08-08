package com.example.module_12.adapters

import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.module_12.Food
import com.example.module_12.R
import com.example.module_12.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.synthetic.main.item_product.*

class ProductAdapterDeligate( private val clickListener: FoodAdapter.OnItemClicked): AbsListItemAdapterDelegate<Food.Product, Food, ProductAdapterDeligate.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup): ProductHolder {
        return  ProductHolder(
            parent.inflate(R.layout.item_product),
            clickListener
        )
    }

    override fun isForViewType(item: Food, items: MutableList<Food>, position: Int): Boolean {
        return item is Food.Product
    }

    override fun onBindViewHolder(
        item: Food.Product,
        holder: ProductHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item, clickListener)
    }

    class ProductHolder(
        view: View,
        onItemClicked:  FoodAdapter.OnItemClicked
    ): BaseFoodHolder(view, onItemClicked) {
        init {
            structureTextView.isVisible = false
        }

        fun bind(food: Food.Product, clickListener: FoodAdapter.OnItemClicked) {
            bindMainInfo(food.id, food.name, food.avatarLink, food.weight )
            itemView.setOnClickListener { clickListener.onClick(food) }
            itemView.setOnLongClickListener { clickListener.onLongClick(adapterPosition);true}
        }

    }


}