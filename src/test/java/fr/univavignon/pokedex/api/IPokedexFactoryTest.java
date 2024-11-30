package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IPokedexFactoryTest {
    IPokedexFactory iPokedexFactory;
    @BeforeEach
    void setup() {
        iPokedexFactory=new PokedxFactory();
    }

    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider pokemonMetadataProvider=Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory=Mockito.mock(IPokemonFactory.class);

        IPokedex pokedex=iPokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}