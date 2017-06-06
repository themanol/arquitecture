package com.themanol.pokecards.cards.displays;

import com.themanol.pokecards.BR;
import com.themanol.pokesdk.models.PokeCard;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.util.List;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardItemDisplay extends BaseObservable {

	@SuppressWarnings("WrongConstant")
	public CardItemDisplay(PokeCard pokeCard) {
		setImageUrl(pokeCard.getImageUrl());
		setName(pokeCard.getName());
		setTypes(pokeCard.getTypes());
		setSuperType(pokeCard.getSuperType());
		setCardId(pokeCard.getId());
	}

	@Retention(SOURCE)
	@StringDef({
			POKEMON,
			TRAINER,
			ENERGY
	})
	public @interface SuperType {
	}
	static final String POKEMON = "Pokémon";
	static final String TRAINER = "Trainer";
	static final String ENERGY = "Energy";

	private String mImageUrl;
	private String mName;
	private List<String> mTypes;
	private String mCardId;
	private @SuperType String mSuperType;

	public void setName(String name) {
		this.mName = name;
		notifyPropertyChanged(BR.viewModel);
	}

	public void setImageUrl(String url) {
		mImageUrl = url;
		notifyPropertyChanged(BR.viewModel);
	}

	public void setTypes(List<String> types) {
		this.mTypes = types;
		notifyPropertyChanged(BR.viewModel);
	}

	public void setSuperType(@SuperType String superType) {
		mSuperType = superType;
		notifyPropertyChanged(BR.viewModel);
	}

	@Bindable
	public String getType() {

		if (POKEMON.equalsIgnoreCase(mSuperType)) {

			if (mTypes == null || mTypes.size() == 0) {
				return POKEMON;
			}
			StringBuilder typesBuilder = new StringBuilder(POKEMON);
			typesBuilder.append(": ");
			for (String type : mTypes) {
				typesBuilder.append(type);
				typesBuilder.append(" | ");
			}
			return typesBuilder.substring(0, typesBuilder.length() - 3);
		} else {
			return mSuperType;
		}
	}

	public String getCardId() {
		return mCardId;
	}

	public void setCardId(String cardId) {
		this.mCardId = cardId;
	}

	@Bindable
	public String getImageUrl() {
		return mImageUrl;
	}

	@Bindable
	public String getName() {
		return mName;
	}
}
