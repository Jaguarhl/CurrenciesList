package com.kartsev.dmitry.currencieslist.presentation.view.blank

import com.arellomobile.mvp.MvpView
import com.kartsev.dmitry.currencieslist.presentation.presenter.vo.CurrencyVO

interface MainView : MvpView {
    fun showError(message: String?)
    fun updateCurrenciesList(currenciesList: MutableList<CurrencyVO>)
}
