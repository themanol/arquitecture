package com.themanol.pokecards.card_details.displays;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.themanol.pokecards.BR;
import com.themanol.pokesdk.models.PokeCard;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class PokeCardDetailsDisplay extends BaseObservable {

	private String mImageUrl;
	private String mName;

	public PokeCardDetailsDisplay(PokeCard input) {
		mImageUrl = input.getImageUrl();
		mName = input.getName();
	}

	@Bindable
	public String getImageUrl() {
		return mImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.mImageUrl = imageUrl;
		notifyPropertyChanged(BR.viewModel);
	}

	@Bindable
	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
		notifyPropertyChanged(BR.viewModel);
	}
}
