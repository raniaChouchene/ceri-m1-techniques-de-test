package fr.univavignon.pokedex.api;

import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    //test de l'invalidité d'un index
    public void testGetPokemonMetadataInvalidIndex()throws PokedexException {
        assertThrows(PokedexException.class,()->{
            iPokemonMetadataProvider.getPokemonMetadata(155);
        });
        assertThrows(PokedexException.class,()->{
            iPokemonMetadataProvider.getPokemonMetadata(-155);
        });

    }



}