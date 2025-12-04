package com.medicalstore.app.domain.repositories

import com.medicalstore.app.domain.models.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun addToCart(productId: String, quantity: Int = 1): Result<Unit>
    suspend fun removeFromCart(productId: String): Result<Unit>
    suspend fun updateQuantity(productId: String, quantity: Int): Result<Unit>
    suspend fun clearCart(): Result<Unit>
    fun getCartItems(): Flow<List<CartItem>>
    fun getCartItemCount(): Flow<Int>
    suspend fun getCartTotal(): Flow<Double>
}
