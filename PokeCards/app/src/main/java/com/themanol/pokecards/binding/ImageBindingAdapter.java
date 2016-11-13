package com.themanol.pokecards.binding;

import com.bumptech.glide.Glide;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class ImageBindingAdapter {

	@BindingAdapter("imageUrl")
	public static void setImageUrl(ImageView imageView, String url) {
		Glide.with(imageView.getContext()).load(url).into(imageView);
	}
}
