package com.jonathan_pannetier.scouthub.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.jonathan_pannetier.scouthub.R
import com.jonathan_pannetier.scouthub.ScouthubApplication
import com.jonathan_pannetier.scouthub.data.models.Repository

class HomeActivity : AppCompatActivity(), HomeContract.View {

    private lateinit var presenter: HomePresenter

    companion object {
        private const val TAG = "HomeActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        // Need to improve dependency injection
        if (application is ScouthubApplication) {
            presenter = HomePresenter((application as ScouthubApplication).githubService)
            presenter.view = this
            presenter.getData()
        }
    }

    override fun displayData(value: List<Repository>) {
        Log.d(TAG, "${value.size}")
    }

    override fun displayProgress(value: Boolean) {
        Log.d(TAG, "progress = $value")
    }

    override fun displayError(message: String) {
        Log.e(TAG, "error = $message")
    }
}
