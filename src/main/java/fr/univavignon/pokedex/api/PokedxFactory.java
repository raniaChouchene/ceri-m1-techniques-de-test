package fr.univavignon.pokedex.api;

public class PokedxFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        try {
            // Create and return a new instance of Pokedex, passing the dependencies
            return new Pokedex(pokemonFactory, metadataProvider);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Pokedex instance", e);
        }
    }
}
