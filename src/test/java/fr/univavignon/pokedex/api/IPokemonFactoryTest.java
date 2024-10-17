package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

	@Test
	void testCreatePokemon() {
		// Mock the IPokemonFactory interface
		IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);

		// Create a sample PokemonMetadata object
		PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);

		// Create a sample Pokemon object
		Pokemon bulbizarre = new Pokemon(bulbizarreMetadata, 613, 64, 4000, 4, 0.56);


		// Define the behavior for the mock when createPokemon is called
		Mockito.when(factory.createPokemon(Mockito.any(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyDouble()))
				.thenReturn(bulbizarre);

		// Call the mocked method and store the result
		Pokemon result;
        result = factory.createPokemon(bulbizarreMetadata, 613, 64, 4000, 4, 0.56);

        // Assert that the created Pokemon has the expected attributes
		assertEquals(613, result.getCp());
		assertEquals("Bulbizarre", result.getName()); // Corrected parenthesis here
		assertEquals(64, result.getHp());
		assertEquals(4000, result.getDust());
		assertEquals(4, result.getCandy());
		assertEquals(0.56, result.getIv());
	}
}
