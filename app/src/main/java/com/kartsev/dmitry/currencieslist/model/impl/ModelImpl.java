package com.kartsev.dmitry.currencieslist.model.impl;

import com.kartsev.dmitry.currencieslist.model.dto.CurrenciesListDTO;
import com.kartsev.dmitry.currencieslist.model.interfaces.ApiInterface;
import com.kartsev.dmitry.currencieslist.model.interfaces.IModel;

import retrofit2.Call;

public class ModelImpl implements IModel {

    ApiInterface apiInterface = ApiModule.getApiInterface();

    @Override
    public Call<CurrenciesListDTO> getCurrencies() {
        return apiInterface.getCurrencies();
    }
}
