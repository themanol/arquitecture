package com.themanol.pokecards.cards;

import com.themanol.pokecards.Injection;
import com.themanol.pokecards.R;
import com.themanol.pokecards.cards.adapter.CardsAdapter;
import com.themanol.pokecards.databinding.CardsActivityBinding;
import com.themanol.pokecards.databinding.CardsItemBinding;
import com.themanol.pokecards.details.CardDetailsActivity;
import com.themanol.pokesdk.datasource.CardsRepository;
import com.themanol.pokesdk.models.PokeCard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.List;

public class CardsActivity extends AppCompatActivity implements CardsContract.View, CardsAdapter.OnCardClickListener {

	private CardsContract.Presenter mPresenter;
	private CardsActivityBinding mBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.cards_activity);
		initViews();
		new CardsPresenter(this, Injection.provideCardsInteractor());
		mPresenter.start();
	}

	private void initViews() {
		mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

	}

	@Override
	public void setLoadingIndicator(boolean active) {
		if (active) {
			mBinding.progressBar.show();
		} else {
			mBinding.progressBar.hide();
		}

	}

	@Override
	public void showCards(List<PokeCard> cards) {
		mBinding.recyclerView.setAdapter(new CardsAdapter(cards, this));
	}

	@Override
	public void showError() {
		Log.d("TheManol", "Get cards error");
	}

	@Override
	public void setPresenter(CardsContract.Presenter presenter) {
		mPresenter = presenter;
	}

	@Override
	public void onCardClick(PokeCard card, CardsItemBinding binding) {
		CardDetailsActivity.startActivity(card.getId(), this, binding.image, binding.name);
	}
}
