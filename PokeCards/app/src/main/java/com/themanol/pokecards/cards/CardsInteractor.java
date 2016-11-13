package com.themanol.pokecards.cards;

import com.themanol.pokesdk.models.PokeCard;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public interface CardsInteractor {

	void getCards(@NonNull OnFinishedListener listener);

	interface OnFinishedListener {
		void onSuccess(List<PokeCard> pokeCards);

		void onError();
	}
}
