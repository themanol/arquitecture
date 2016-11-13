package com.themanol.pokesdk.datasource;

import com.themanol.pokesdk.datasource.retrofit.CardsRetrofitDatasource;
import com.themanol.pokesdk.models.PokeCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardsRepository implements CardsDataSource {

	private static CardsRepository sInstance;

	private CardsDataSource dataSource;
	private final Map<String, PokeCard> cache;

	public static CardsRepository getInstance() {
		if (sInstance == null) {
			sInstance = new CardsRepository(CardsRetrofitDatasource.getInstance());
		}
		return sInstance;
	}

	private CardsRepository(CardsDataSource dataSource) {
		this.dataSource = dataSource;
		this.cache = new HashMap<>();
	}

	@Override
	public List<PokeCard> getPokeCards() {
		List<PokeCard> cards = dataSource.getPokeCards();
		if (cards != null) {
			for (PokeCard card : cards) {
				cache.put(card.getId(), card);
			}
		}
		return cards;
	}

	@Override
	public PokeCard getPokeCard(String id) {
		if (cache.containsKey(id)) {
			return cache.get(id);
		}
		PokeCard card = dataSource.getPokeCard(id);
		if (card != null) {
			cache.put(id, card);
		}
		return card;
	}
}
