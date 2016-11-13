package com.themanol.pokesdk.datasource.retrofit;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manuelgarcia on 13/11/16.
 */

class ServiceGenerator {

	private static final String API_BASE_URL = "https://api.pokemontcg.io/v1/";

	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

	private static Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

	private static Retrofit.Builder builder =
			new Retrofit.Builder()
					.baseUrl(API_BASE_URL)
					.addConverterFactory(GsonConverterFactory.create(gson));

	static <S> S createService(Class<S> serviceClass) {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BODY);
		Retrofit retrofit = builder.client(httpClient.addInterceptor(logging).build()).build();
		return retrofit.create(serviceClass);
	}
}