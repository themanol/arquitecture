package com.themanol.pokesdk.datasource.retrofit;

import com.themanol.pokesdk.models.PokeCard;
import com.themanol.pokesdk.models.PokeCards;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public interface CardsService {

	@GET("cards")
	Call<PokeCards> getCards();

	@GET("cards/{id}")
	Call<PokeCard> getCard(@Path("id") String id);
}
