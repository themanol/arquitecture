package com.themanol.pokecards.card_details;

import com.themanol.pokecards.Injection;
import com.themanol.pokecards.R;
import com.themanol.pokecards.card_details.displays.PokeCardDetailsDisplay;
import com.themanol.pokecards.cards.viewmodels.CardsViewModel;
import com.themanol.pokecards.databinding.CardDetailsActivityBinding;
import com.themanol.pokecards.card_details.viewmodels.CardDetailsViewModel;
import com.themanol.pokecards.utils.PokeCardsViewModelFactory;

import android.app.Activity;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardDetailsActivity extends LifecycleActivity{

	private static final String CARD_ID = "card_id";
	private CardDetailsActivityBinding mBinding;
	private CardDetailsViewModel cardDetailsViewModel;


	public static void startActivity(String cardId, Activity activity, View image, View title) {
		Intent intent = new Intent(activity, CardDetailsActivity.class);
		intent.putExtra(CARD_ID, cardId);
		Pair<View, String> p1 = Pair.create(image, "image");
		Pair<View, String> p2 = Pair.create(title, "title");
		//noinspection unchecked
		ActivityOptionsCompat options = ActivityOptionsCompat.
				makeSceneTransitionAnimation(activity, p1, p2);
		activity.startActivity(intent, options.toBundle());
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.card_details_activity);
		cardDetailsViewModel = ViewModelProviders.of(this, new PokeCardsViewModelFactory()).get(CardDetailsViewModel.class);
		cardDetailsViewModel.getPokeCard(getIntent().getStringExtra(CARD_ID)).observe(this, new Observer<PokeCardDetailsDisplay>() {
			@Override
			public void onChanged(@Nullable PokeCardDetailsDisplay pokeCardDetailsDisplay) {
				showCard(pokeCardDetailsDisplay);
			}
		});

	}

	private void showCard(PokeCardDetailsDisplay card) {
		mBinding.setViewModel(card);
	}

}
