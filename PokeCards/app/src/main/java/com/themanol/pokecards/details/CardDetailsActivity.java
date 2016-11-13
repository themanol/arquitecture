package com.themanol.pokecards.details;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.themanol.pokecards.Injection;
import com.themanol.pokecards.R;
import com.themanol.pokecards.databinding.CardDetailsActivityBinding;
import com.themanol.pokecards.details.viewmodels.CardDetailsViewModel;

import android.app.Activity;
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

public class CardDetailsActivity extends AppCompatActivity implements CardDetailsContract.View {

	private static final String CARD_ID = "card_id";
	private CardDetailsActivityBinding mBinding;

	public static void startActivity(String cardId, Activity activity, View image, View title) {
		Intent intent = new Intent(activity, CardDetailsActivity.class);
		intent.putExtra(CARD_ID, cardId);
		Pair<View, String> p1 = Pair.create(image, "image");
		Pair<View, String> p2 = Pair.create(title, "title");
		ActivityOptionsCompat options = ActivityOptionsCompat.
				makeSceneTransitionAnimation(activity, p1, p2);
		activity.startActivity(intent, options.toBundle());
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.card_details_activity);
		new CardDetailsPresenter(getIntent().getStringExtra(CARD_ID), this, Injection.provideCardDetailsInteractor());
	}

	@Override
	public void showCard(CardDetailsViewModel card) {
		mBinding.setViewModel(card);
	}

	@Override
	public void showError() {

	}

	@Override
	public void setPresenter(CardDetailsContract.Presenter presenter) {

	}
}
