package com.pedrosoares.injectionmvvmlib.activities

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import tassks.agap2.com.common_core.viewModels.BaseViewModel
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel>(private val layoutId: Int, private val viewModelVariable: Int, private val viewModelClass: Class<V>) : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewDataBinding: T
    protected lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        this.viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
        this.viewDataBinding.setVariable(viewModelVariable, this.viewModel)
        this.viewModel.onNavigation(intent.extras)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        this.viewModel.onReturnResult(intent?.extras)
    }
}