package com.themanol.pokecards.cards;

import com.themanol.pokecards.Injection;
import com.themanol.pokecards.R;
import com.themanol.pokesdk.datasource.CardsRepository;
import com.themanol.pokesdk.models.PokeCard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class CardsActivity extends AppCompatActivity implements CardsContract.View {

	private CardsContract.Presenter mPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cards_activity);
		new CardsPresenter(this, Injection.provideCardsInteractor());
		initViews();
		mPresenter.start();
	}

	private void initViews() {

	}

	@Override
	public void setLoadingIndicator(boolean active) {

	}

	@Override
	public void showCards(List<PokeCard> cards) {
		for (PokeCard card : cards) {
			Log.d("TheManol", card.getName());
		}
	}

	@Override
	public void goToCardDetails(PokeCard card) {

	}

	@Override
	public void showError() {
		Log.d("TheManol", "Get cards error");
	}

	@Override
	public void setPresenter(CardsContract.Presenter presenter) {
		mPresenter = presenter;
	}
}
