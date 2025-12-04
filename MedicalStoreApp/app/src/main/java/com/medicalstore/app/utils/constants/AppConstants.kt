package com.medicalstore.app.utils.constants

object AppConstants {
    const val DATABASE_NAME = "medical_store_database"
    const val PREFERENCES_NAME = "medical_store_preferences"
    const val BASE_URL = "https://api.medicalstore.com/"
    
    const val CACHE_TIMEOUT = 5 * 60 * 1000L // 5 minutes
    
    object PrefKeys {
        const val USER_ID = "user_id"
        const val ACCESS_TOKEN = "access_token"
        const val IS_LOGGED_IN = "is_logged_in"
        const val LANGUAGE = "language"
        const val THEME = "theme"
    }
    
    object Navigation {
        const val HOME = "home"
        const val CATEGORIES = "categories"
        const val CART = "cart"
        const val ORDERS = "orders"
        const val PROFILE = "profile"
    }
}
