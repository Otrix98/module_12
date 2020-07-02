package com.example.module_12

sealed class Food {
    data class Product (
        val name: String,
        val weight: String,
        val avatarLink: String
    ): Food()
    data class Dish (
        val name: String,
        val weight: String,
        val avatarLink: String,
        val structure: String
    ): Food()
}