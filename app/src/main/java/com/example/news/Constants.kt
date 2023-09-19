package com.example.news

import androidx.compose.ui.graphics.Color
import com.example.news.api.model.Category


object Constants {
    val categories = listOf(
        Category(
            "sports", R.drawable.ball,
            R.string.sports,R.color.red,
            R.color.red
        ),
        Category(
            "technology", R.drawable.politics,
            R.string.technology,  R.color.blue,
            R.color.blue
        ),
        Category(
            "health", R.drawable.health,
            R.string.health, R.color.pink,
            R.color.pink
        ),
        Category(
            "business", R.drawable.bussines,
            R.string.business, R.color.brown_orange,
            R.color.brown_orange
        ),
        Category(
            "general", R.drawable.environment,
            R.string.general,R.color.baby_blue,
            R.color.baby_blue
        ),
        Category(
            "science", R.drawable.science,
            R.string.science, R.color.yellow,
            R.color.yellow
        ),
    )
}