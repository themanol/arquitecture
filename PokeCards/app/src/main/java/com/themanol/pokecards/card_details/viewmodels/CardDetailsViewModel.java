package com.themanol.pokecards.card_details.viewmodels;

import com.themanol.pokecards.BR;
import com.themanol.pokecards.Injection;
import com.themanol.pokecards.card_details.displays.PokeCardDetailsDisplay;
import com.themanol.pokecards.utils.NullLiveData;
import com.themanol.pokesdk.datasource.CardsRepository;
import com.themanol.pokesdk.models.PokeCard;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class CardDetailsViewModel extends ViewModel {

    private CardsRepository mRepository;
    private LiveData<PokeCard> mCard;
    private MutableLiveData<String> mCardId;

    public CardDetailsViewModel(CardsRepository repository) {
        this.mRepository = repository;
        mCardId = new MutableLiveData<>();
        mCard = Transformations.switchMap(mCardId, new Function<String, LiveData<PokeCard>>() {
            @Override
            public LiveData<PokeCard> apply(String input) {
                if (input.isEmpty()) {
                    return NullLiveData.create();
                } else {
                    return mRepository.getPokeCard(input);
                }
            }
        });
    }

    public LiveData<PokeCardDetailsDisplay> getPokeCard(String id){
        mCardId.setValue(id);
        return Transformations.map(mCard, new Function<PokeCard, PokeCardDetailsDisplay>() {
            @Override
            public PokeCardDetailsDisplay apply(PokeCard input) {
                return new PokeCardDetailsDisplay(input);
            }
        });
    }

}
