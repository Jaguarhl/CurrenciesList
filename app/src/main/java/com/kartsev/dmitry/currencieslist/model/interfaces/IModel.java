package com.kartsev.dmitry.currencieslist.model.interfaces;

import com.kartsev.dmitry.currencieslist.model.dto.CurrenciesListDTO;

import retrofit2.Call;

public interface IModel {
    Call<CurrenciesListDTO> getCurrencies();
}
