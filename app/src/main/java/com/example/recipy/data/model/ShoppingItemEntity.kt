package com.example.recipy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


// ShoppingItemEntity.kt
@Entity(tableName = "shopping_items")
data class ShoppingItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val quantity: String
)