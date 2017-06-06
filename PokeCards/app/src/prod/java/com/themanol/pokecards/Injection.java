package com.themanol.pokecards;

import com.themanol.pokesdk.datasource.CardsRepository;
import com.themanol.pokesdk.datasource.CardsRepositoryImpl;
import com.themanol.pokesdk.datasource.retrofit.CardsRetrofitDatasource;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class Injection {

	public static CardsRepository provideCardsRepository() {
		return CardsRepositoryImpl.getInstance(CardsRetrofitDatasource.INSTANCE);
	}

}
