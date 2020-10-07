package com.ustl.ifi.tp.pokemon_type_api.service;
import com.ustl.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ustl.ifi.tp.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    PokemonTypeRepository pokemonTypeRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository repository){
        this.pokemonTypeRepository = repository;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        return pokemonTypeRepository.findPokemonTypeById(id);
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
}
