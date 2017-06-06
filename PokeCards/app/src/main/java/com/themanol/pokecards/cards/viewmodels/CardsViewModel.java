package com.themanol.pokecards.cards.viewmodels;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.themanol.pokecards.Injection;
import com.themanol.pokecards.cards.displays.CardItemDisplay;
import com.themanol.pokesdk.datasource.CardsRepository;
import com.themanol.pokesdk.models.PokeCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manuelgarcia on 14/11/16.
 */

public class CardsViewModel extends ViewModel{

	private CardsRepository mRepository;

	private LiveData<List<PokeCard>> mCards;

	public CardsViewModel() {
		mRepository = Injection.provideCardsRepository();
		loadPokeCards();
	}

	private void loadPokeCards(){
		if (mCards == null) {
			mCards = mRepository.getPokeCards();
		}
	}

	public LiveData<List<CardItemDisplay>> getPokeCards(){
		return Transformations.map(mCards, new Function<List<PokeCard>, List<CardItemDisplay>>() {
			@Override
			public List<CardItemDisplay> apply(List<PokeCard> input) {
				List<CardItemDisplay> cardItemDisplays = new ArrayList<>();
				for (PokeCard pokeCard : input) {
					cardItemDisplays.add(new CardItemDisplay(pokeCard));
				}
				return cardItemDisplays;
			}
		});
	}
}
