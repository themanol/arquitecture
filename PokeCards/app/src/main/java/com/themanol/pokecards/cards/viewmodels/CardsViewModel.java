package com.themanol.pokecards.cards.viewmodels;

import com.themanol.pokesdk.models.PokeCard;

import java.util.List;

/**
 * Created by manuelgarcia on 14/11/16.
 */

public class CardsViewModel {

	private List<PokeCard> mCards;

	public CardsViewModel(List<PokeCard> cards) {
		mCards = cards;
	}

	@SuppressWarnings("WrongConstant")
	public CardItemViewModel getItemViewModel(int position) {
		CardItemViewModel viewModel = new CardItemViewModel();
		viewModel.setImageUrl(mCards.get(position).getImageUrl());
		viewModel.setName(mCards.get(position).getName());
		viewModel.setTypes(mCards.get(position).getTypes());
		viewModel.setSuperType(mCards.get(position).getSuperType());
		viewModel.setCardId(mCards.get(position).getId());
		return viewModel;
	}

	public int getCount() {
		return mCards.size();
	}
}
