package com.themanol.pokecards.cards.adapter;

import com.themanol.pokecards.R;
import com.themanol.pokecards.cards.viewmodels.CardItemViewModel;
import com.themanol.pokecards.databinding.CardsItemBinding;
import com.themanol.pokesdk.models.PokeCard;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

	private List<PokeCard> mCards;
	private OnCardClickListener mListener;

	public CardsAdapter(@NonNull List<PokeCard> cards, @NonNull OnCardClickListener cardClickListener) {
		mCards = cards;
		mListener = cardClickListener;
	}

	@Override
	public CardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		CardsItemBinding binding = DataBindingUtil.inflate(
				LayoutInflater.from(parent.getContext()),
				R.layout.cards_item,
				parent,
				false);
		return new CardsViewHolder(binding, mListener);
	}

	@Override
	public void onBindViewHolder(CardsViewHolder holder, int position) {
		holder.bindCardItem(mCards.get(position));
	}

	@Override
	public int getItemCount() {
		return mCards.size();
	}

	static class CardsViewHolder extends RecyclerView.ViewHolder {

		private PokeCard mCard;
		private CardsItemBinding mBinding;

		CardsViewHolder(CardsItemBinding binding, final OnCardClickListener mListener) {
			super(binding.getRoot());
			mBinding = binding;
			binding.getRoot().setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					mListener.onCardClick(mCard);
				}
			});
		}

		@SuppressWarnings("WrongConstant")
		void bindCardItem(PokeCard card) {
			CardItemViewModel viewModel = new CardItemViewModel();
			mBinding.setViewModel(viewModel);
			mCard = card;
			viewModel.setImageUrl(card.getImageUrl());
			viewModel.setName(card.getName());
			viewModel.setTypes(card.getTypes());
			viewModel.setSuperType(card.getSuperType());
			mBinding.executePendingBindings();
		}
	}

	public interface OnCardClickListener {
		void onCardClick(PokeCard card);
	}
}
