package com.themanol.pokecards.utils;

import android.arch.lifecycle.LiveData;

/**
 * Created by m.garcia.rebollo on 07/06/2017.
 */

public class NullLiveData extends LiveData {

    private NullLiveData() {
        //noinspection unchecked
        postValue(null);
    }

    public static <T> LiveData<T> create() {
        //noinspection unchecked
        return new NullLiveData();
    }
}
