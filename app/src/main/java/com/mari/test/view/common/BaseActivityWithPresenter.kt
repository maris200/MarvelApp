package com.mari.test.view.common

import android.support.v7.app.AppCompatActivity
import com.mari.test.presenter.Presenter

abstract class BaseActivityWithPresenter : BaseActivity() {

    abstract val presenter: Presenter

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}
