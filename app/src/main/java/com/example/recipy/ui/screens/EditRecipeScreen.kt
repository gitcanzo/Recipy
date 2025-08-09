package com.example.recipy.ui.screens

@Composable
fun EditRecipeScreen(
    viewModel: EditRecipeViewModel = viewModel(factory = MyFactory),
    onDone: () -> Unit
) {
    // TextFields bound to viewModel.recipe and
    // a dynamic list for viewModel.ingredients.
    // Save button calls viewModel.save() and onDone()
}