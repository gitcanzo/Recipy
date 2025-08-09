package com.example.recipy.data.dao

// ShoppingListDao.kt
@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM shopping_items")
    fun allItems(): Flow<List<ShoppingItemEntity>>

    @Insert suspend fun add(item: ShoppingItemEntity)
    @Delete suspend fun remove(item: ShoppingItemEntity)
}