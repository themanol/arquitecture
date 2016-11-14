package com.themanol.pokecards.cards.adapter;

import com.themanol.pokecards.R;
import com.themanol.pokecards.cards.viewmodels.CardItemViewModel;
import com.themanol.pokecards.cards.viewmodels.CardsViewModel;
import com.themanol.pokecards.databinding.CardsItemBinding;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

	private CardsViewModel mViewModel;
	private OnCardClickListener mListener;

	public CardsAdapter(@NonNull CardsViewModel cardsViewModel, @NonNull OnCardClickListener cardClickListener) {
		mListener = cardClickListener;
		mViewModel = cardsViewModel;
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
		holder.bindCardItem(mViewModel.getItemViewModel(position));
	}

	@Override
	public int getItemCount() {
		return mViewModel.getCount();
	}

	static class CardsViewHolder extends RecyclerView.ViewHolder {

		private CardItemViewModel mItemViewModel;
		private CardsItemBinding mBinding;

		CardsViewHolder(CardsItemBinding binding, final OnCardClickListener mListener) {
			super(binding.getRoot());
			mBinding = binding;
			binding.getRoot().setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					mListener.onCardClick(mItemViewModel.getCardId(), mBinding);
				}
			});
		}

		void bindCardItem(CardItemViewModel viewModel) {
			mItemViewModel = viewModel;
			mBinding.setViewModel(viewModel);
			mBinding.executePendingBindings();
		}
	}

	public interface OnCardClickListener {
		void onCardClick(String cardId, CardsItemBinding view);
	}
}
