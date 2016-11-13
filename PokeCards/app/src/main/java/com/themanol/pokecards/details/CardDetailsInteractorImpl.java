package com.themanol.pokecards.details;

import com.themanol.pokesdk.datasource.CardsDataSource;
import com.themanol.pokesdk.models.PokeCard;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardDetailsInteractorImpl implements CardDetailsInteractor {

	private CardsDataSource mRepository;

	public CardDetailsInteractorImpl(CardsDataSource repository) {
		mRepository = repository;
	}

	@Override
	public void getCard(@NonNull String id, @NonNull CardDetailsInteractor.OnFinishedListener listener) {
		CardDetailsAsyncTasks cardAsynctasks = new CardDetailsAsyncTasks(id, mRepository, listener);
		cardAsynctasks.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	}

	private static class CardDetailsAsyncTasks extends AsyncTask<Void, Void, PokeCard> {

		private String mId;
		private CardsDataSource mRepository;
		private CardDetailsInteractor.OnFinishedListener mListener;


		CardDetailsAsyncTasks(String id, CardsDataSource repository, CardDetailsInteractor.OnFinishedListener listener) {
			mRepository = repository;
			mListener = listener;
			mId = id;
		}

		@Override
		protected PokeCard doInBackground(Void... voids) {
			return mRepository.getPokeCard(mId);
		}

		@Override
		protected void onPostExecute(PokeCard pokeCard) {
			if (pokeCard != null) {
				mListener.onSuccess(pokeCard);
			} else {
				mListener.onError();
			}
		}
	}
}
