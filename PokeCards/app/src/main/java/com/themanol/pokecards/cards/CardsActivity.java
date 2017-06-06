package com.themanol.pokecards.cards;

import com.themanol.pokecards.Injection;
import com.themanol.pokecards.R;
import com.themanol.pokecards.cards.adapter.CardsAdapter;
import com.themanol.pokecards.cards.displays.CardItemDisplay;
import com.themanol.pokecards.cards.viewmodels.CardsViewModel;
import com.themanol.pokecards.databinding.CardsActivityBinding;
import com.themanol.pokecards.databinding.CardsItemBinding;
import com.themanol.pokecards.card_details.CardDetailsActivity;
import com.themanol.pokecards.utils.PokeCardsViewModelFactory;
import com.themanol.pokesdk.models.PokeCard;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.List;

public class CardsActivity extends LifecycleActivity implements CardsAdapter.OnCardClickListener {

    private CardsViewModel cardsViewModel;
    private CardsActivityBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.cards_activity);
        initViews();
        cardsViewModel = ViewModelProviders.of(this, new PokeCardsViewModelFactory()).get(CardsViewModel.class);
        setLoadingIndicator(true);
        cardsViewModel.getPokeCards().observe(this, new Observer<List<CardItemDisplay>>() {
            @Override
            public void onChanged(@Nullable List<CardItemDisplay> pokeCards) {
                setLoadingIndicator(false);
                mBinding.recyclerView.setAdapter(new CardsAdapter(pokeCards, CardsActivity.this));
            }
        });
    }

    private void initViews() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setLoadingIndicator(boolean active) {
        if (active) {
            mBinding.progressBar.show();
        } else {
            mBinding.progressBar.hide();
        }

    }

    @Override
    public void onCardClick(String cardId, CardsItemBinding binding) {
        CardDetailsActivity.startActivity(cardId, this, binding.image, binding.name);
    }

}
