package com.ustl.ifi.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ustl.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);
        for (PokemonType p : pokemons) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);
        for (PokemonType p : pokemons) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return pokemons;
    }

    @Override
    public List<PokemonType> findPokemonTypeByTypes(String types) {
        System.out.println("Loading Pokemon information for Pokemon types " + types);
        String[] type = types.split(",");
        List<PokemonType> pokemonList = new ArrayList<>();
        for (PokemonType p : pokemons) {
            if (p.getTypes().contains(type[0])) {
                pokemonList.add(p);
            }
        }
        if (type.length == 2) {
            for (PokemonType p : pokemonList) {
                if (!p.getTypes().contains(type[1])) {
                    pokemonList.remove(p);
                }
            }
        }
        return pokemonList;
    }
}
