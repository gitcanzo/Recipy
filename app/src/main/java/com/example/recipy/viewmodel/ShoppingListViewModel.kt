package com.example.recipy.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

// ShoppingListViewModel.kt
class ShoppingListViewModel(context: Context) : ViewModel() {
    private val repo = RecipeRepository(context)
    val items = derivedStateOf { repo.getShoppingList() }

    suspend fun add(item: ShoppingItemEntity) = repo.addShoppingItem(item)
    suspend fun remove(item: ShoppingItemEntity) = repo.removeShoppingItem(item)
}