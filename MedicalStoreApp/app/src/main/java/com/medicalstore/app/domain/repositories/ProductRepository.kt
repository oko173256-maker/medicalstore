package com.medicalstore.app.domain.repositories

import com.medicalstore.app.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Result<List<Product>>
    suspend fun getProduct(productId: String): Result<Product>
    suspend fun getSpecialOffers(): Result<List<Product>>
    suspend fun getRecommendedProducts(): Result<List<Product>>
    suspend fun searchProducts(query: String): Result<List<Product>>
    fun getProductsStream(): Flow<List<Product>>
}
