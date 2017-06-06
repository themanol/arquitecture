package com.themanol.pokesdk.datasource;

import android.arch.lifecycle.LiveData;

import com.themanol.pokesdk.models.PokeCard;

import java.io.IOException;
import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public interface CardsDataSource {

	LiveData<List<PokeCard>> getPokeCards();

	LiveData<PokeCard> getPokeCard(String id);
}
