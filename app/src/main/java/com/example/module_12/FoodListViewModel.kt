package com.example.module_12

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.module_12.adapters.FoodAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import kotlin.random.Random

class FoodListViewModel: ViewModel() {
    private val repository = FoodRepository()

     private val foodLiveData = MutableLiveData<List<Food>>(
        repository.generateFoods(7)
    )

    private val showToastLiveData = SingleLiveEvent<Unit>()

    val foods: LiveData<List<Food>>
    get() = foodLiveData

    val showToast: LiveData<Unit>
    get() = showToastLiveData

    fun addFood() {
    val newFood = repository.createFood()
        val updatedList = listOf(newFood) + foodLiveData.value.orEmpty()
        foodLiveData.postValue(updatedList)
}
    fun deleteFood( id: Int) {
        foodLiveData.postValue(
            repository.deleteFood(foodLiveData.value.orEmpty(), id)
        )
    }
}

