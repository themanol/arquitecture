package com.themanol.pokecards;

import com.themanol.pokecards.cards.CardsInteractor;
import com.themanol.pokecards.cards.CardsInteractorImpl;
import com.themanol.pokesdk.datasource.CardsRepository;
import com.themanol.pokesdk.datasource.retrofit.CardsRetrofitDatasource;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class Injection {

	private static CardsRepository provideCardsRepository() {
		return CardsRepository.getInstance(CardsRetrofitDatasource.getInstance());
	}

	public static CardsInteractor provideCardsInteractor() {
		return new CardsInteractorImpl(Injection.provideCardsRepository());
	}


}