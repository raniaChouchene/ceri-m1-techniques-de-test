package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    @Test
    void testGetMetadata() throws PokedexException {
        IPokemonMetadataProvider provider = Mockito.mock(IPokemonMetadataProvider.class);
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        Mockito.when(provider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertEquals("Bulbizarre", result.getName(), "The Pokemon name should be 'Bulbizarre'");
        assertEquals(126, result.getAttack(), "The attack value should be 126");
        assertEquals(126, result.getDefense(), "The defense value should be 126");
        assertEquals(90, result.getStamina(), "The stamina value should be 90");
    }
}
