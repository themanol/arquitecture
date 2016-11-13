package com.themanol.pokesdk.datasource;

import com.themanol.pokesdk.models.PokeCard;

import java.io.IOException;
import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public interface CardsDataSource {

	List<PokeCard> getPokeCards();

	PokeCard getPokeCard(String id);
}
