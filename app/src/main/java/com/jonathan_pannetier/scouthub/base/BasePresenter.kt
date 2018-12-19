package com.jonathan_pannetier.scouthub.base

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking


abstract class BasePresenter<V : BaseContract.View<T>, T> : BaseContract.Presenter {

    private var job: Deferred<T>? = null
    var view: V? = null

    companion object {
        private const val TAG = "BasePresenter"
    }

    fun getData(data: Deferred<T>) = runBlocking {
        job = data
        view?.displayProgress(true)
        val value: T? = job?.await()
        view?.displayProgress(false)

        if (value != null) {
            view?.also {
                it.displayData(value)
            }
        } else {
            view?.also {
                it.displayError("Error on fetching data")
            }
        }
    }

    override fun onDestroy() {
        job?.cancel()
    }
}