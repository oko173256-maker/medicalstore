package com.medicalstore.app.domain.repositories

import com.medicalstore.app.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getCurrentUser(): Result<User>
    suspend fun getUser(userId: String): Result<User>
    suspend fun updateUser(user: User): Result<User>
    suspend fun login(email: String, password: String): Result<User>
    suspend fun register(email: String, password: String, userData: User): Result<User>
    suspend fun logout(): Result<Unit>
    fun getUserStream(userId: String): Flow<User?>
}
