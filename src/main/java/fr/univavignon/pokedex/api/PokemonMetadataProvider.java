package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    private static final Map<Integer, PokemonMetadata> metadataMap = new HashMap<>();
    @Override
    public  PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        try {
            PokemonMetadata metadata = metadataMap.get(index);

            if (metadata == null) {
                throw new PokedexException("No metadata found for Pokémon with index: " + index);
            }

            return metadata;
        } catch (Exception e) {
            throw new PokedexException("Error retrieving Pokémon metadata");
        }
    }}
