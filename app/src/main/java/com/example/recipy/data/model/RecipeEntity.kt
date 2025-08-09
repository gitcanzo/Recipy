package com.example.recipy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// RecipeEntity.kt
@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val instructions: String,
    val prepTime: Int
)
