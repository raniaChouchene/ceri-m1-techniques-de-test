package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IPokedexFactoryTest {
    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokedex() {
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(createdPokedex, "Created pokedex should not be null.");
        assertEquals(metadataProvider, createdPokedex.getMetadataProvider(),
                "The metadata provider should match the one provided.");
        assertEquals(pokemonFactory, createdPokedex.getPokemonFactory(),
                "The pokemon factory should match the one provided.");
    }
}
