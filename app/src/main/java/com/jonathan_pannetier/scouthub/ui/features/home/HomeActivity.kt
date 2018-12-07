package com.jonathan_pannetier.scouthub.ui.features.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.jonathan_pannetier.scouthub.R
import com.jonathan_pannetier.scouthub.ScouthubApplication
import com.jonathan_pannetier.scouthub.base.interfaces.OnClickListener
import com.jonathan_pannetier.scouthub.data.models.Repository
import com.jonathan_pannetier.scouthub.extensions.invisible
import com.jonathan_pannetier.scouthub.extensions.toast
import com.jonathan_pannetier.scouthub.extensions.visible
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeContract.View, OnClickListener<Repository> {

    private lateinit var presenter: HomePresenter
    private lateinit var repositoriesAdapter: HomeRecyclerAdapter

    companion object {
        private const val TAG = "HomeActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initAdapter()
        // Need to improve dependency injection
        if (application is ScouthubApplication) {
            presenter = HomePresenter((application as ScouthubApplication).githubService)
            presenter.view = this
            presenter.getData()
        }
    }

    override fun displayData(value: List<Repository>) {
        Log.d(TAG, "${value.size}")
        repositoriesAdapter.setItems(value)
        recycler.visible()
        progress.invisible()
        error.invisible()
    }

    override fun displayProgress(value: Boolean) {
        if (value)
            progress.visible()
        else
            progress.invisible()
    }

    override fun displayError(message: String) {
        progress.invisible()
        recycler.invisible()
        error.apply {
            visible()
            text = message
        }
    }

    override fun onItemClicked(data: Repository) {
        toast("${data.name} clicked!")
    }

    private fun initAdapter() {
        repositoriesAdapter = HomeRecyclerAdapter(this).apply {
            onClickListener = this@HomeActivity
        }

        val layoutManager = GridLayoutManager(this, 2)

        recycler.apply {
            adapter = repositoriesAdapter
            this.layoutManager = layoutManager
        }
    }
}
