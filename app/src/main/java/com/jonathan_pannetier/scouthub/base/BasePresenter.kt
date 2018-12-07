package com.jonathan_pannetier.scouthub.base

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


abstract class BasePresenter<V : BaseContract.View<T>, T> : BaseContract.Presenter {

    private var disposable: Disposable? = null
    var view: V? = null

    companion object {
        private const val TAG = "BasePresenter"
    }

    fun getData(data: Single<T>) {
        view?.displayProgress(true)

        disposable = data
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                view?.displayProgress(false)
                view?.displayData(it)
            }, {
                Log.e(TAG, "getData() for $data -> ${it.message}")
                view?.displayProgress(false)
                view?.displayError(it.message ?: "")
            })
    }

    override fun onDestroy() {
        disposable?.dispose()
    }
}