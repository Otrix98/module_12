package com.example.module_12

sealed class Food {
    data class Product (
        val id: Long,
        val name: String,
        val weight: String,
        val avatarLink: String
    ): Food()
    data class Dish (
        val id: Long,
        val name: String,
        val weight: String,
        val avatarLink: String,
        val structure: String
    ): Food()
}