package com.example.module_12.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.module_12.Food
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import kotlinx.android.synthetic.main.item_product.weightTextView

class FoodAdapter(
    private val clickListener: OnItemClicked):
    AsyncListDifferDelegationAdapter<Food>(FoodDiffUtilCallback()) {


    init {
        delegatesManager.addDelegate(DishAdapterDeligate(clickListener))
            .addDelegate(ProductAdapterDeligate(clickListener))
    }
    class FoodDiffUtilCallback: DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return when {
                oldItem is Food.Dish && newItem is Food.Dish -> oldItem.id == newItem.id
                oldItem is Food.Product && newItem is Food.Product -> oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }

    }

    interface OnItemClicked {
        fun onClick(item:Food)
        fun onLongClick(position: Int)
    }



   companion object {
       private const val TYPE_PRODUCT = 1
       private const val TYPE_DISH = 2

   }


}