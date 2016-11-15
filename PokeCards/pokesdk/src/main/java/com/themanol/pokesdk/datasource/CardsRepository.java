package com.themanol.pokesdk.datasource;

/**
 * Created by manuelgarcia on 15/11/16.
 */

import com.themanol.pokesdk.models.PokeCard;

import java.util.List;

public interface CardsRepository {

	List<PokeCard> getPokeCards();

	PokeCard getPokeCard(String id);
}
