package com.kartsev.dmitry.currencieslist.model.interfaces;

import com.kartsev.dmitry.currencieslist.model.dto.CurrenciesListDTO;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("stocks.json")
    Call<CurrenciesListDTO> getCurrencies();
}
