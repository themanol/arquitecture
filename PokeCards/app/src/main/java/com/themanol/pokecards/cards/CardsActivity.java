package com.themanol.pokecards.cards;

import com.themanol.pokecards.R;
import com.themanol.pokesdk.models.PokeCard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class CardsActivity extends AppCompatActivity implements CardsContract.View {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
	}

	@Override
	public void setLoadingIndicator(boolean active) {

	}

	@Override
	public void showCards(List<PokeCard> cards) {

	}

	@Override
	public void setPresenter(CardsContract.Presenter presenter) {

	}
}
