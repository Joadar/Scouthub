package com.jonathan_pannetier.scouthub.ui

import com.jonathan_pannetier.scouthub.base.BaseContract
import com.jonathan_pannetier.scouthub.data.models.Repository

interface HomeContract: BaseContract {
    interface View : BaseContract.View<List<Repository>>
    interface Presenter: BaseContract.Presenter
}