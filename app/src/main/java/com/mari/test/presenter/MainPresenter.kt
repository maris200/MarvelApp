package com.mari.test.presenter

import com.mari.test.data.MarvelRepository
import com.mari.test.data.applySchedulers
import com.mari.test.data.plusAssign
import com.mari.test.data.subscribeBy
import com.mari.test.view.main.MainView

class MainPresenter(val view: MainView, val repository: MarvelRepository) : BasePresenter() {

    fun onViewCreated() {
        loadCharacters()
    }

    fun onRefresh() {
        loadCharacters()
    }

    fun onSearchChanged(newText: String) {
        loadCharacters(newText)
    }

    private fun loadCharacters(search: String? = null) {
        val qualifiedSearchQuery = if (search.isNullOrBlank()) null else search
        subscriptions += repository
                .getAllCharacters(qualifiedSearchQuery)
                .applySchedulers()
                .doOnSubscribe { view.refresh = true }
                .doFinally { view.refresh = false }
                .subscribeBy(
                        onSuccess = view::show,
                        onError = view::showError
                )
    }
}