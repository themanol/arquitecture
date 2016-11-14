package com.themanol.pokecards.cards;

import com.themanol.pokecards.cards.viewmodels.CardsViewModel;
import com.themanol.pokesdk.models.PokeCard;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

class CardsPresenter implements CardsContract.Presenter, CardsInteractor.OnFinishedListener {

	private CardsContract.View mView;
	private CardsInteractor mInteractor;

	CardsPresenter(@NonNull CardsContract.View view, @NonNull CardsInteractor interactor) {
		mView = view;
		mInteractor = interactor;
		mView.setPresenter(this);
	}

	@Override
	public void start() {
		mView.setLoadingIndicator(true);
		mInteractor.getCards(this);
	}

	@Override
	public void onSuccess(List<PokeCard> pokeCards) {
		CardsViewModel cardsViewModel = new CardsViewModel(pokeCards);
		mView.setLoadingIndicator(false);
		mView.showCards(cardsViewModel);
	}

	@Override
	public void onError() {
		mView.setLoadingIndicator(false);
		mView.showError();
	}
}
