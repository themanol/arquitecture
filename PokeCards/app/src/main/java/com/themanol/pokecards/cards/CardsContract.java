package com.themanol.pokecards.cards;

import com.themanol.pokecards.BasePresenter;
import com.themanol.pokecards.BaseView;
import com.themanol.pokesdk.models.PokeCard;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

interface CardsContract {

	interface View extends BaseView<Presenter> {

		void setLoadingIndicator(boolean active);

		void showCards(List<PokeCard> cards);

		void showError();
	}

	interface Presenter extends BasePresenter {
	}
}
