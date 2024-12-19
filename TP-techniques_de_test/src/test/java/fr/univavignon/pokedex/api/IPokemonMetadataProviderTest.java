package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;

    @BeforeEach
    void setup() {
        iPokemonMetadataProvider=new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadata()throws PokedexException {
        PokemonMetadata bulbizarre=iPokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(0,bulbizarre.getIndex());
        assertEquals("Bulbizarre",bulbizarre.getName());
        assertEquals(126,bulbizarre.getAttack());
        assertEquals(126,bulbizarre.getDefense());
        assertEquals(90,bulbizarre.getStamina());



    }

    @Test

    public void testGetPokemonMetadataInvalidIndex()throws PokedexException {
        assertThrows(PokedexException.class,()->{
            iPokemonMetadataProvider.getPokemonMetadata(155);
        });
        assertThrows(PokedexException.class,()->{
            iPokemonMetadataProvider.getPokemonMetadata(-155);
        });

    }

}
