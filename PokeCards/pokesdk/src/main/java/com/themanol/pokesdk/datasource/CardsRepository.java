package com.themanol.pokesdk.datasource;

/**
 * Created by manuelgarcia on 15/11/16.
 */

import android.arch.lifecycle.LiveData;

import com.themanol.pokesdk.models.PokeCard;

import java.util.List;

public interface CardsRepository {

	LiveData<List<PokeCard>> getPokeCards();

	LiveData<PokeCard> getPokeCard(String id);


}
