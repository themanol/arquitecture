package com.themanol.pokecards.details;

import com.themanol.pokecards.cards.CardsInteractor;
import com.themanol.pokesdk.models.PokeCard;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public interface CardDetailsInteractor {

	void getCard(@NonNull String id, @NonNull OnFinishedListener listener);

	interface OnFinishedListener {
		void onSuccess(PokeCard pokeCard);

		void onError();
	}
}
