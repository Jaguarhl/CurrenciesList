package com.kartsev.dmitry.currencieslist.ui.activity.blank

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import com.kartsev.dmitry.currencieslist.presentation.view.blank.MainView
import com.kartsev.dmitry.currencieslist.presentation.presenter.blank.MainPresenter

import com.arellomobile.mvp.MvpAppCompatActivity

import com.arellomobile.mvp.presenter.InjectPresenter
import com.kartsev.dmitry.currencieslist.R
import com.kartsev.dmitry.currencieslist.R.id.refresh
import com.kartsev.dmitry.currencieslist.presentation.presenter.vo.CurrencyVO
import com.kartsev.dmitry.currencieslist.ui.adapters.CurrenciesListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {
    @InjectPresenter
    lateinit var mMainPresenter: MainPresenter
    lateinit var mAdapter: CurrenciesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        mAdapter = CurrenciesListAdapter()
        var llm = LinearLayoutManager(applicationContext)
        recyclerCurrenciesList.layoutManager = llm
        recyclerCurrenciesList.itemAnimator = DefaultItemAnimator()
        recyclerCurrenciesList.adapter = mAdapter
    }

    override fun showError(message: String?) {
        makeToast(message)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            refresh -> {
                mMainPresenter.refreshButtonClicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun makeToast(message: String?) {
        message?.let {
            Snackbar.make(
                    container,
                    it,
                    Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun updateCurrenciesList(currenciesList: MutableList<CurrencyVO>) {
        mAdapter.setCurrenciesList(currenciesList)
    }

    companion object {
        val TAG = "MainActivity"

        fun getIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
