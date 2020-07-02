package com.example.module_12

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoodAdapter(
    private val onItemClicked: (position: Int ) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder >() {

    private var foods: List<Food> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_PRODUCT ->  ProductHolder(parent.inflate(R.layout.item_product), onItemClicked)
            TYPE_DISH ->  DishHolder(parent.inflate(R.layout.item_dish), onItemClicked)
            else -> error("incorrect viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (foods[position]) {
            is Food.Product -> TYPE_PRODUCT
            is Food.Dish -> TYPE_DISH
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ProductHolder -> {
                val food = foods[position].let { it as? Food.Product }
                    ?: error("Food is not a product!")
                holder.bind(food)
            }
            is DishHolder -> {
                val food = foods[position].let { it as? Food.Dish }
                    ?: error("Food is not a dish!")
                holder.bind(food)
            }
            else -> error("incorrect viewHolder")
        }
    }

    override fun getItemCount(): Int = foods.size


    fun updateFoods(newFoods: List<Food>) {
        foods = newFoods
    }

    abstract class BasePersonHolder (
        view: View,
        onItemClicked: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(view) {

        private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        private val weightTextView: TextView = view.findViewById(R.id.weightTextView)
        private val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)

        init {
            view.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }

        protected fun bindMainInfo(
            name: String,
            avatarLink: String,
            weight: String
        ) {
            nameTextView.text = name
            weightTextView.text = "Вес: ${weight}"

            Glide.with(itemView)
                .load(avatarLink)
                .error(R.drawable.ic_baseline_error)
                .into(avatarImageView)
        }
    }
    class ProductHolder(
        view: View,
    onItemClicked: (position: Int) -> Unit
    ): BasePersonHolder(view, onItemClicked) {
        init {
            view.findViewById<TextView>(R.id.structureTextView).isVisible = false
        }

        fun bind(food: Food.Product) {
            bindMainInfo(food.name, food.avatarLink, food.weight )
        }

    }

    class DishHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit
    ): BasePersonHolder(view, onItemClicked) {
        private val structureItemView: TextView = view.findViewById(R.id.structureTextView)

        fun bind(food: Food.Dish) {
            bindMainInfo(food.name, food.avatarLink, food.weight )
            structureItemView.text = "Состав: ${food.structure}"
        }
    }

   companion object {
       private const val TYPE_PRODUCT = 1
       private const val TYPE_DISH = 2

   }


}