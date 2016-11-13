package com.themanol.pokecards.details;

import com.themanol.pokecards.BasePresenter;
import com.themanol.pokecards.BaseView;
import com.themanol.pokecards.details.viewmodels.CardDetailsViewModel;
import com.themanol.pokesdk.models.PokeCard;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

interface CardDetailsContract {

	interface View extends BaseView<Presenter> {

		void showCard(CardDetailsViewModel card);

		void showError();
	}

	interface Presenter extends BasePresenter {
	}
}
