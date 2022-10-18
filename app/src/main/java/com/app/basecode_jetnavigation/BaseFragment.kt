package com.app.basecode_jetnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<B :ViewDataBinding> (@LayoutRes private val layoutId : Int) : Fragment() {

    private var _binding : B? = null
    protected val binding get() = _binding!!
    protected lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId ,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        navController = Navigation.findNavController(view)

        initView(view)
        setEvent()
    }

    protected abstract fun initView(view : View)
    protected abstract fun setEvent()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}