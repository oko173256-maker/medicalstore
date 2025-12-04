package com.medicalstore.app.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : Fragment() {

    protected lateinit var binding: VB
    private var _binding: VB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding = _binding!!
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        initializeUI()
        setupObservers()
        setupListeners()
        loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected open fun initializeUI() {}
    protected open fun setupObservers() {}
    protected open fun setupListeners() {}
    protected open fun loadData() {}

    protected fun showLoading(show: Boolean) {
        // Loading state implementation
    }

    protected fun showError(message: String) {
        // Error handling implementation
    }

    protected fun showMessage(message: String) {
        // Message display implementation
    }

    protected fun navigateTo(destinationId: Int, args: Bundle? = null) {
        // Navigation implementation
    }
}
