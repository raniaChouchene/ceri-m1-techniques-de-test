package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    @Test
    void testGetMetadata() throws PokedexException {
        // Create a mock for IPokemonMetadataProvider
        IPokemonMetadataProvider provider = Mockito.mock(IPokemonMetadataProvider.class);

        // Create a sample PokemonMetadata object
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);

        // Define behavior for the mock when getPokemonMetadata is called
        Mockito.when(provider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);

        // Call the method and store the result
        PokemonMetadata result = provider.getPokemonMetadata(0);

        // Assert that the returned metadata is as expected
        assertEquals("Bulbizarre", result.getName());
        assertEquals(126, result.getAttack());
        assertEquals(126, result.getDefense());
        assertEquals(90, result.getStamina());
    }
}
