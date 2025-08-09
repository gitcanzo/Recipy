package com.example.recipy.data.dao

// RecipeDao.kt
@Dao
interface RecipeDao {
    @Transaction
    @Query("SELECT * FROM recipes ORDER BY title")
    fun getAllRecipes(): Flow<List<RecipeWithIngredients>>

    @Transaction
    @Query(
        """
    SELECT * FROM recipes
    WHERE title LIKE '%' || :query || '%'
    ORDER BY title
    """
    )
    fun searchRecipes(query: String): Flow<List<RecipeWithIngredients>>

    @Insert suspend fun insert(recipe: RecipeEntity): Long
    @Update suspend fun update(recipe: RecipeEntity)
    @Delete suspend fun delete(recipe: RecipeEntity)
}