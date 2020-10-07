package com.ustl.ifi.tp.pokemon_type_api.controller;

import com.ustl.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ustl.ifi.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    PokemonTypeService pokemonTypeService;

    public PokemonTypeController(PokemonTypeService service) {
        this.pokemonTypeService = service;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id){
        return pokemonTypeService.getPokemonType(id);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeService.getAllPokemonTypes();
    }

    @GetMapping(path = "/", params = "name")
    PokemonType getPokemonTypeByName(String name){
        return pokemonTypeService.findPokemonTypeByName(name);
    }

    @GetMapping(path = "/", params = "types")
    List<PokemonType> getPokemonTypeByTypes(String types){
        return pokemonTypeService.findPokemonTypeByTypes(types);
    }
}