package com.themanol.pokesdk.datasource.retrofit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.themanol.pokesdk.datasource.CardsDataSource;
import com.themanol.pokesdk.models.PokeCard;
import com.themanol.pokesdk.models.PokeCards;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public enum CardsRetrofitDatasource implements CardsDataSource {

    INSTANCE;

    @Override
    public LiveData<List<PokeCard>> getPokeCards() {
        final MutableLiveData<List<PokeCard>> pokecards = new MutableLiveData<>();
        CardsService cardsService = ServiceGenerator.createService(CardsService.class);
        cardsService.getCards().enqueue(new Callback<PokeCards>() {
            @Override
            public void onResponse(Call<PokeCards> call, Response<PokeCards> response) {
                if (response.isSuccessful()) {
                    pokecards.setValue(response.body().getCards());
                }
            }

            @Override
            public void onFailure(Call<PokeCards> call, Throwable t) {

            }
        });

        return pokecards;
    }

    @Override
    public LiveData<PokeCard> getPokeCard(String id) {
        CardsService cardsService = ServiceGenerator.createService(CardsService.class);
        Call<PokeCard> call = cardsService.getCard(id);
        Response response;
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                MutableLiveData<PokeCard> pokeCardMutableLiveData = new MutableLiveData<>();
                pokeCardMutableLiveData.setValue((PokeCard) response.body());
                return pokeCardMutableLiveData;
            }
        } catch (IOException e) {
        }
        return null;
    }
}
