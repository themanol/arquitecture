package com.themanol.pokesdk.datasource;

import com.themanol.pokesdk.models.PokeCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardsRepositoryImpl implements CardsRepository {

	private static CardsRepositoryImpl sInstance;

	private CardsDataSource dataSource;
	private final Map<String, PokeCard> cache;

	public static CardsRepositoryImpl getInstance(CardsDataSource dataSource) {
		if (sInstance == null) {
			sInstance = new CardsRepositoryImpl(dataSource);
		}
		return sInstance;
	}

	private CardsRepositoryImpl(CardsDataSource dataSource) {
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
