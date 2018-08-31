package com.kartsev.dmitry.currencieslist.presentation.presenter.mappers

import com.kartsev.dmitry.currencieslist.model.dto.CurrenciesListDTO
import com.kartsev.dmitry.currencieslist.presentation.presenter.vo.CurrencyVO

class CurrenciesListMapper {
    fun getCurrenciesList(serverAnswer: CurrenciesListDTO): MutableList<CurrencyVO> {
        var currencies: MutableList<CurrencyVO> = ArrayList()
        serverAnswer.stock.forEach {
            currencies.add(CurrencyVO(it.name, it.price.amount, it.volume))
        }

        return currencies
    }
}