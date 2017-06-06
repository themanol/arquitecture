package com.themanol.pokesdk.datasource;

import android.arch.core.util.Function;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.support.annotation.Nullable;

import com.themanol.pokesdk.models.PokeCard;

import java.util.ArrayList;
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
	public LiveData<List<PokeCard>> getPokeCards() {
		MutableLiveData<List<PokeCard>> cards = new MutableLiveData<>();
		if (!cache.isEmpty()) {
            cards.setValue(new ArrayList<>(cache.values()));
            return cards;
		} else {
			LiveData<List<PokeCard>> cardsData = dataSource.getPokeCards();
			return Transformations.map(cardsData, new Function<List<PokeCard>, List<PokeCard>>() {
				@Override
				public List<PokeCard> apply(List<PokeCard> input) {
					cacheResults(input);
					return input;
				}
			});
		}
	}

	@Override
	public LiveData<PokeCard> getPokeCard(final String id) {
        MutableLiveData<PokeCard> pokeCardMutableLiveData = new MutableLiveData<>();
		if (cache.containsKey(id)) {
            pokeCardMutableLiveData.setValue(cache.get(id));
			return pokeCardMutableLiveData;
		}else {
			LiveData<PokeCard> pokeCard = dataSource.getPokeCard(id);
			return Transformations.map(pokeCard, new Function<PokeCard, PokeCard>() {
				@Override
				public PokeCard apply(PokeCard input) {
					cache.put(id, input);
					return input;
				}
			});
		}
	}

	private void cacheResults(List<PokeCard> cards) {
		if (cards != null) {
			for (PokeCard card : cards) {
				cache.put(card.getId(), card);
			}
		}
	}

}
