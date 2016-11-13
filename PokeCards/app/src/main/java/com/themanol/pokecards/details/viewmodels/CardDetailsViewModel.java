package com.themanol.pokecards.details.viewmodels;

import com.themanol.pokecards.BR;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardDetailsViewModel extends BaseObservable {

	private String mImageUrl;
	private String mName;

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
