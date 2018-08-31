package com.kartsev.dmitry.currencieslist.presentation.presenter.blank

import com.kartsev.dmitry.currencieslist.presentation.view.blank.MainView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.kartsev.dmitry.currencieslist.model.dto.CurrenciesListDTO
import com.kartsev.dmitry.currencieslist.model.impl.ModelImpl
import com.kartsev.dmitry.currencieslist.model.interfaces.IModel
import com.kartsev.dmitry.currencieslist.presentation.presenter.mappers.CurrenciesListMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.fixedRateTimer


@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    private val mModel: IModel
    private var callForCurrencies: Call<CurrenciesListDTO>? = null
    private var mView: MainView? = null
    private var mCurrencyMapper: CurrenciesListMapper
    private var fixedRateTimer: Timer? = null

    init {
        this.mModel = ModelImpl()
        this.mCurrencyMapper = CurrenciesListMapper()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        mView = viewState
    }

    override fun onDestroy() {
        super.onDestroy()
        this.fixedRateTimer?.cancel()
        this.fixedRateTimer?.purge()
    }

    private fun askForCurrencies() {
        requestCurrencies()
        fixedRateTimer = fixedRateTimer(name = "update-timer",
                initialDelay = TimeUnit.SECONDS.toMillis(15), period = TimeUnit.SECONDS.toMillis(15)) {
            requestCurrencies()
        }
    }

    private fun requestCurrencies() {
        if (callForCurrencies == null)
            callForCurrencies = mModel.currencies

        callForCurrencies?.clone()?.enqueue(object : Callback<CurrenciesListDTO> {
            override fun onFailure(call: Call<CurrenciesListDTO>?, t: Throwable?) {
                mView?.showError(t?.message)
            }

            override fun onResponse(call: Call<CurrenciesListDTO>?, response: Response<CurrenciesListDTO>?) {
                if (response != null && response.isSuccessful) {
                    viewState.updateCurrenciesList(mCurrencyMapper.getCurrenciesList(response.body()))
                }
            }

        })
    }

    override fun attachView(view: MainView?) {
        super.attachView(view)
        askForCurrencies()
    }

    override fun detachView(view: MainView?) {
        super.detachView(view)
        fixedRateTimer?.cancel()
    }

    fun refreshButtonClicked() {
        askForCurrencies()
    }
}
