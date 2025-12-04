package com.medicalstore.app.domain.models

data class Cart(
    val cartId: String,
    val userId: String,
    val items: List<CartItem> = emptyList(),
    val createdAt: Long,
    val updatedAt: Long
) {
    val totalItems: Int
        get() = items.sumOf { it.quantity }

    val subtotal: Double
        get() = items.sumOf { it.totalPrice }

    val totalAmount: Double
        get() = subtotal

    fun isEmpty(): Boolean = items.isEmpty()
}

data class CartItem(
    val product: Product,
    val quantity: Int,
    val addedAt: Long
) {
    val totalPrice: Double
        get() = product.getFinalPrice() * quantity
}
