package com.themanol.pokecards.cards.adapter;

import com.themanol.pokecards.R;
import com.themanol.pokecards.cards.displays.CardItemDisplay;
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

    private List<CardItemDisplay> mCards;
    private OnCardClickListener mListener;

    public CardsAdapter(@NonNull List<CardItemDisplay> cards, @NonNull OnCardClickListener cardClickListener) {
        mListener = cardClickListener;
        mCards = cards;
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

        private CardItemDisplay mCardItemDisplay;
        private CardsItemBinding mBinding;

        CardsViewHolder(CardsItemBinding binding, final OnCardClickListener mListener) {
            super(binding.getRoot());
            mBinding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onCardClick(mCardItemDisplay.getCardId(), mBinding);
                }
            });
        }

        void bindCardItem(CardItemDisplay pokeCard) {
            mCardItemDisplay = pokeCard;
            mBinding.setViewModel(mCardItemDisplay);
            mBinding.executePendingBindings();
        }
    }

    public interface OnCardClickListener {
        void onCardClick(String cardId, CardsItemBinding view);
    }
}
