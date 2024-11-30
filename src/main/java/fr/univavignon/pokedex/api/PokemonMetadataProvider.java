package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    static List<PokemonMetadata> pokemonMetadata=new ArrayList<>();;


    static {
        pokemonMetadata.add(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        if(index<0 || index>=pokemonMetadata.size())
            throw new PokedexException("index invalide");
        PokemonMetadata pokemon=pokemonMetadata.get(index);
        return pokemon;
    }


}