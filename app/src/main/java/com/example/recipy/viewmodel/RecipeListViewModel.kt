package com.example.recipy.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

// RecipeListViewModel.kt
class RecipeListViewModel(context: Context) : ViewModel() {
    private val repo = RecipeRepository(context)
    var query by mutableStateOf("")
    val recipes = derivedStateOf {
        // In real code you'd collect Flows with viewModelScope, but for simplicity:
        repo.getRecipes(query)
    }
}