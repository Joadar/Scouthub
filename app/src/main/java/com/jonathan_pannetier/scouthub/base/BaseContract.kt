package com.jonathan_pannetier.scouthub.base

interface BaseContract {
    interface View<T>  {
        fun displayData(value: T)
        fun displayProgress(value: Boolean)
        fun displayError(message: String = "")
    }

    interface Presenter {
        fun getData()
        fun onDestroy()
    }
}