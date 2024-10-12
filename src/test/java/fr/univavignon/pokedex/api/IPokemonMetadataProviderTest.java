package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
    @Test 
    void testGetMetadata(){ 
         IPokemonMetadataProvider provider = Mockito.mock(IPokemonMetadataProvider.class); 

        PokemonMetadata bulbizzareMetadata = new PokemonMetadata(0 , "bulbizzare",126,126,90); 
        Mockito.when(provider.testGetMetadata(0)).thenReturn (bulbizzareMetadata); 
        PokemonMetadata result = provider.getMetadata(0) ; 
        assertEquals("Bulbizarre", result.getName()) ; 
        assertEquals(126, result.getAttack()); 
    }

   
}
