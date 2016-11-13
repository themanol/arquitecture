package com.themanol.pokecards.cards;

import com.themanol.pokesdk.datasource.CardsDataSource;
import com.themanol.pokesdk.models.PokeCard;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardsInteractorImpl implements CardsInteractor {

	private CardsDataSource mRepository;

	public CardsInteractorImpl(CardsDataSource repository) {
		mRepository = repository;
	}

	@Override
	public void getCards(OnFinishedListener listener) {
		CardsAsyncTasks cardsAsynctasks = new CardsAsyncTasks(mRepository, listener);
		cardsAsynctasks.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	}

	private static class CardsAsyncTasks extends AsyncTask<Void, Void, List<PokeCard>> {

		private CardsDataSource mRepository;
		private OnFinishedListener mListener;


		CardsAsyncTasks(CardsDataSource repository, OnFinishedListener listener) {
			mRepository = repository;
			mListener = listener;
		}

		@Override
		protected List<PokeCard> doInBackground(Void... voids) {
			return mRepository.getPokeCards();
		}

		@Override
		protected void onPostExecute(List<PokeCard> pokeCards) {
			if (pokeCards != null) {
				mListener.onSuccess(pokeCards);
			} else {
				mListener.onError();
			}
		}
	}
}
