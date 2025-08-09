package com.example.recipy.data.repository

class RecipeRepository(context: Context) {
    private val db = AppDatabase.getInstance(context)
    private val rDao = db.recipeDao()
    private val iDao = db.ingredientDao()
    private val sDao = db.shoppingListDao()

    fun getRecipes(query: String) =
        if (query.isBlank()) rDao.getAllRecipes()
        else rDao.searchRecipes(query)

    suspend fun saveRecipe(
        recipe: RecipeEntity,
        ingredients: List<IngredientEntity>
    ) {
        val id = rDao.insert(recipe)
        iDao.insert(*ingredients.map { it.copy(recipeId = id) }.toTypedArray())
    }

    suspend fun updateRecipe(
        recipe: RecipeEntity,
        ingredients: List<IngredientEntity>
    ) {
        rDao.update(recipe)
        iDao.deleteByRecipe(recipe.id)
        iDao.insert(*ingredients.map { it.copy(recipeId = recipe.id) }.toTypedArray())
    }

    fun getShoppingList() = sDao.allItems()
    suspend fun addShoppingItem(item: ShoppingItemEntity) = sDao.add(item)
    suspend fun removeShoppingItem(item: ShoppingItemEntity) = sDao.remove(item)
}