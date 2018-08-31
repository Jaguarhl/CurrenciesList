package com.kartsev.dmitry.currencieslist.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.kartsev.dmitry.currencieslist.R
import com.kartsev.dmitry.currencieslist.presentation.presenter.vo.CurrencyVO

class CurrenciesListAdapter : RecyclerView.Adapter<CurrenciesListAdapter.ViewHolder>() {
    private var mCurrenciesList: List<CurrencyVO> = emptyList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.recycler_currency_item, p0, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currency = mCurrenciesList[position]

        viewHolder.textCurrencyName!!.text = currency.currencyName
        viewHolder.textCurrencyAmount!!.text = currency.currencyAmount.toString()
        viewHolder.textCurrencyVolume!!.text = currency.currencyVolume
    }

    override fun getItemCount(): Int {
        return mCurrenciesList.size
    }

    fun setCurrenciesList(list: List<CurrencyVO>) {
        this.mCurrenciesList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textCurrencyName: TextView? = null
        internal var textCurrencyVolume: TextView? = null
        internal var textCurrencyAmount: TextView? = null

        init {
            textCurrencyName = itemView.findViewById(R.id.textCurrencyName)
            textCurrencyVolume = itemView.findViewById(R.id.textCurrencyValue)
            textCurrencyAmount = itemView.findViewById(R.id.textCurrencyAmount)
        }
    }
}
