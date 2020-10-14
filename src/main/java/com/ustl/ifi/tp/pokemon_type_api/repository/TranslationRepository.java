package com.ustl.ifi.tp.pokemon_type_api.repository;

import java.util.Locale;

public interface TranslationRepository {
    String getPokemonName(int id, Locale locale);
}