package com.ustl.ifi.tp.pokemon_type_api.service;
import com.ustl.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ustl.ifi.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.ustl.ifi.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    PokemonTypeRepository pokemonTypeRepository;
    TranslationRepository translationRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository repository){
        this.pokemonTypeRepository = repository;
    }

    public PokemonTypeServiceImpl(TranslationRepository repository) {
        this.translationRepository = repository;
    }

    @Autowired
    public PokemonTypeServiceImpl(PokemonTypeRepository repository, TranslationRepository transRepository){
        this.pokemonTypeRepository = repository;
        this.translationRepository = transRepository;
    }

    public PokemonTypeServiceImpl() {

    }

    @Override
    public PokemonType getPokemonType(int id) {
        PokemonType pokemon = pokemonTypeRepository.findPokemonTypeById(id);
        pokemon.setName(translationRepository.getPokemonName(pokemon.getId(), LocaleContextHolder.getLocale()));
        return pokemon;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        return pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        
        return pokemonTypeRepository.findAllPokemonType();
    }

    @Override
    public List<PokemonType> findPokemonTypeByTypes(String types) {
        return pokemonTypeRepository.findPokemonTypeByTypes(types);
    }

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }
}
