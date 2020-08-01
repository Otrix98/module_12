package com.example.module_12

import kotlin.random.Random

class FoodRepository {
    fun generateFoods(count: Int): List<Food> {

        val avatars = listOf(
            "https://domos.ru/images/blog/15944/Carbonara.jpg",
            "https://avatars.mds.yandex.net/get-pdb/245485/10b9d137-9069-4ebc-a993-82a6076689f0/s1200?webp=false",
            "https://avatars.mds.yandex.net/get-pdb/1757027/4aa3f258-d4d7-4f0f-815d-a2aaa912c062/s1200?webp=false",
            "https://avatars.mds.yandex.net/get-pdb/1535406/32215f6e-737d-4229-8a4f-60c553984775/s1200?webp=false",
            "https://attuale.ru/wp-content/uploads/2019/01/Sollana-paella-rice-new-website.jpg",
            "https://i.baraholka.com.ru/files/1/8/1819452.jpg"
        )

        val names = listOf(
            "Карбонара",
            "Винегрет́",
            "Ризотто",
            "Рыба",
            "Рис",
            "Курица"
        )

        val structures = listOf(
            "Спагетти, бекон, яйцо, сливки",
            "Свёкла, картофель, фасоль, морковь, огурцы",
            "Рис, масло, лук, чеснок, креветки"
        )
        return (0..count).map {
            val id = it.toLong()
            val name = names.random()
            val avatar = avatars.random()
            val structure = structures.random()
            val isDish = Random.nextBoolean()
            val weight = Random.nextInt(100, 1000).toString()


            if (isDish) {
                Food.Dish(
                    id = id,
                    name = name,
                    weight = weight,
                    avatarLink = avatar,
                    structure = structure
                )
            } else {
                Food.Product(
                    id = id,
                    name = name,
                    weight = weight,
                    avatarLink = avatar
                )
            }

        }
    }

    fun createFood(): Food {
        return  generateFoods(1).first().let {
            when (it) {
                is Food.Product -> it.copy(id = Random.nextLong())
                is Food.Dish -> it.copy(id = Random.nextLong())
            }
        }
    }

    fun deleteFood(foods: List<Food>, id: Int): List<Food> {
        return foods.filterIndexed { index, food -> index != id }
    }
}