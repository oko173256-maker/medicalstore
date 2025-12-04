package com.medicalstore.app.domain.models

data class Product(
    val productId: String,
    val name: String,
    val description: String,
    val brand: String,
    val category: String,
    val price: Double,
    val discountPrice: Double? = null,
    val prescriptionRequired: Boolean = false,
    val stockQuantity: Int,
    val imageUrl: String,
    val rating: Double,
    val reviewCount: Int
) {
    fun getFinalPrice(): Double {
        return discountPrice ?: price
    }

    fun hasDiscount(): Boolean {
        return discountPrice != null
    }

    fun getDiscountPercentage(): Int {
        return if (hasDiscount()) {
            (((price - discountPrice!!) / price) * 100).toInt()
        } else {
            0
        }
    }

    fun isInStock(): Boolean {
        return stockQuantity > 0
    }
}
