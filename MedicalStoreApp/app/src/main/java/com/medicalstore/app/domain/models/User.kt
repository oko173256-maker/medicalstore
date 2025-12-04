package com.medicalstore.app.domain.models

data class User(
    val userId: String,
    val fullName: String,
    val email: String,
    val phone: String,
    val dateOfBirth: String? = null,
    val gender: String? = null,
    val bloodType: String? = null,
    val allergies: List<String> = emptyList(),
    val createdAt: Long,
    val updatedAt: Long
) {
    fun getAge(): Int? {
        return dateOfBirth?.let {
            // Implementation to calculate age from date string
            null // Placeholder
        }
    }
}
