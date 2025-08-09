package com.example.recipy.data.dao

// IngredientDao.kt
@Dao
interface IngredientDao {
    @Query("SELECT * FROM ingredients WHERE recipeId = :rid")
    fun getForRecipe(rid: Long): Flow<List<IngredientEntity>>

    @Insert suspend fun insert(vararg items: IngredientEntity)
    @Query("DELETE FROM ingredients WHERE recipeId = :rid")
    suspend fun deleteByRecipe(rid: Long)
}