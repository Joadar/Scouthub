package com.jonathan_pannetier.scouthub.ui.features.home

import com.jonathan_pannetier.scouthub.base.BasePresenter
import com.jonathan_pannetier.scouthub.data.models.Repository
import com.jonathan_pannetier.scouthub.data.remote.GithubService

class HomePresenter(private val githubService: GithubService) : BasePresenter<HomeContract.View, List<Repository>>(),
    HomeContract.Presenter {
    override fun getData() {
        super.getData(githubService.getRepositories("google", 20, 1))
    }
}