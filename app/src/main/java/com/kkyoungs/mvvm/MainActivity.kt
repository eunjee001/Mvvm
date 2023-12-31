package com.kkyoungs.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kkyoungs.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var viewModel :ViewModel ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        viewModel = ViewModel(Database().getInstance()!!)
        mBinding.viewModel = viewModel

        mBinding.btn.setOnClickListener {
            viewModel!!.getUser()
        }
    }
}