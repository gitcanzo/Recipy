package com.example.recipy.viewmodel


import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow


// EditRecipeViewModel.kt
class EditRecipeViewModel(context: Context) : ViewModel() {
    private val repo = RecipeRepository(context)
    var recipe by mutableStateOf(RecipeEntity(0, "", "", 0))
    var ingredients by mutableStateOf(listOf<IngredientEntity>())

    suspend fun save() {
        if (recipe.id == 0L) repo.saveRecipe(recipe, ingredients)
        else repo.updateRecipe(recipe, ingredients)
    }
}