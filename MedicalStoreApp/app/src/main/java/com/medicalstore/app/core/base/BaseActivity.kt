package com.medicalstore.app.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        
        initializeUI()
        setupObservers()
        setupListeners()
        loadData()
    }

    protected open fun initializeUI() {}
    protected open fun setupObservers() {}
    protected open fun setupListeners() {}
    protected open fun loadData() {}

    protected fun showLoading(show: Boolean) {
        // Implement loading state
    }

    protected fun showError(message: String) {
        // Implement error handling
    }

    protected fun showMessage(message: String) {
        // Implement message display
    }
}
