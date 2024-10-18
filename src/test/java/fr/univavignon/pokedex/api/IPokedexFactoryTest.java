package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest{
    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedex pokedex;

    @BeforeEach
    public void setUp() {

        pokedexFactory = Mockito.mock(IPokedexFactory.class);


        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);


        pokedex = Mockito.mock(IPokedex.class);


        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void testCreatePokedex() {

        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);


        assertNotNull(createdPokedex, "Created pokedex should not be null.");
        assertEquals(pokedex, createdPokedex, "The created pokedex should match the expected instance.");


        verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);
    }
}