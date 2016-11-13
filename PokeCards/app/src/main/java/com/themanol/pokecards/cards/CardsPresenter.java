package com.themanol.pokecards.cards;

import com.themanol.pokesdk.datasource.CardsDataSource;
import com.themanol.pokesdk.models.PokeCard;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardsPresenter implements CardsContract.Presenter, CardsInteractor.OnFinishedListener {

	private CardsContract.View mView;
	private CardsInteractor mInteractor;

	public CardsPresenter(@NonNull CardsContract.View view, @NonNull CardsInteractor interactor) {
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
		mView.setLoadingIndicator(false);
		mView.showCards(pokeCards);
	}

	@Override
	public void onError() {
		mView.showError();
	}
}
