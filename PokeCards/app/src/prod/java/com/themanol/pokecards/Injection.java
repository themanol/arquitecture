package com.themanol.pokecards;

import com.themanol.pokecards.cards.CardsInteractor;
import com.themanol.pokecards.cards.CardsInteractorImpl;
import com.themanol.pokecards.details.CardDetailsInteractor;
import com.themanol.pokecards.details.CardDetailsInteractorImpl;
import com.themanol.pokesdk.datasource.CardsRepository;
import com.themanol.pokesdk.datasource.CardsRepositoryImpl;
import com.themanol.pokesdk.datasource.retrofit.CardsRetrofitDatasource;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class Injection {

	private static CardsRepository provideCardsRepository() {
		return CardsRepositoryImpl.getInstance(CardsRetrofitDatasource.getInstance());
	}

	public static CardsInteractor provideCardsInteractor() {
		return new CardsInteractorImpl(Injection.provideCardsRepository());
	}


	public static CardDetailsInteractor provideCardDetailsInteractor() {
		return new CardDetailsInteractorImpl(Injection.provideCardsRepository()) {
		};
	}
}
