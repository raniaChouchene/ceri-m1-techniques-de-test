package fr.univavignon.pokedex.api;

import java.util.*;

public class Pokedex implements IPokedex  {

    private final Map<Integer, Pokemon> pokemonList = new HashMap<>();
    private final IPokemonFactory pokemonFactory;
    private final IPokemonMetadataProvider metadataProvider;

    public Pokedex(IPokemonFactory pokemonFactory, IPokemonMetadataProvider metadataProvider) {
        this.pokemonFactory = pokemonFactory;
        this.metadataProvider = metadataProvider;
    }

    @Override
    public int size() {
        return pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        int id = size();
        pokemonList.put(id, pokemon);
        return id;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (!pokemonList.containsKey(id)) {
            throw new PokedexException("Pokemon not found");
        }
        return pokemonList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemonList.values());
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemonList = new ArrayList<>(pokemonList.values());
        sortedPokemonList.sort(order);
        return sortedPokemonList;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public Pokemon createPokemon(PokemonMetadata metadata, int cp, int hp, int dust, int candy, double iv) {
        return pokemonFactory.createPokemon(metadata, cp, hp, dust, candy, iv);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
