package com.themanol.pokesdk.datasource.retrofit;

import com.themanol.pokesdk.datasource.CardsDataSource;
import com.themanol.pokesdk.models.PokeCard;
import com.themanol.pokesdk.models.PokeCards;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public enum CardsRetrofitDatasource implements CardsDataSource {

	INSTANCE;

	@Override
	public List<PokeCard> getPokeCards() {
		CardsService cardsService = ServiceGenerator.createService(CardsService.class);
		Call<PokeCards> call = cardsService.getCards();
		Response response;
		try {
			response = call.execute();
			if (response.isSuccessful()) {
				return ((PokeCards)response.body()).getCards();
			}
		} catch (IOException e) {
		}
		return null;
	}

	@Override
	public PokeCard getPokeCard(String id) {
		CardsService cardsService = ServiceGenerator.createService(CardsService.class);
		Call<PokeCard> call = cardsService.getCard(id);
		Response response;
		try {
			response = call.execute();
			if (response.isSuccessful()) {
				return (PokeCard)response.body();
			}
		} catch (IOException e) {
		}
		return null;
	}
}
