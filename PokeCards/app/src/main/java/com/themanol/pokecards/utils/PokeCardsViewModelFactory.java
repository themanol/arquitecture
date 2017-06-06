package com.themanol.pokecards.utils;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.themanol.pokecards.Injection;
import com.themanol.pokecards.card_details.viewmodels.CardDetailsViewModel;
import com.themanol.pokecards.cards.viewmodels.CardsViewModel;

/**
 * Created by m.garcia.rebollo on 07/06/2017.
 */

public class PokeCardsViewModelFactory implements ViewModelProvider.Factory  {


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass == CardsViewModel.class) {
            return (T) new CardsViewModel(Injection.provideCardsRepository());
        }else if (modelClass == CardDetailsViewModel.class){
            return (T) new CardDetailsViewModel(Injection.provideCardsRepository());
        }
        return null;
    }
}
