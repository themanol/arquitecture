package com.themanol.pokesdk.models;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public class PokeCard {

	private String id;
	private String name;
	private String nationalPokedexNumber;
	private String imageUrl;
	private String subtype;
	private String supertype;
	private Ability ability;
	private String hp;
	private List<String> retreatCost;
	private String number;
	private String artist;
	private String rarity;
	private String series;
	private String set;
	private String setCode;
	private List<String> types;
	private List<Attack> attacks;
	private List<Weakness> weaknesses;
	private List<Resistance> resistances;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
