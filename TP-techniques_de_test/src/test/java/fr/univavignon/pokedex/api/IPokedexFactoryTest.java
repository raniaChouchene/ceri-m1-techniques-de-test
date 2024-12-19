package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IPokedexFactoryTest {
    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    IPokedexFactory iPokedexFactory;


    @BeforeEach
    void setup() {
        iPokedexFactory=new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider pokemonMetadataProvider=Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory=Mockito.mock(IPokemonFactory.class);
        IPokedex pokedex=iPokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}
