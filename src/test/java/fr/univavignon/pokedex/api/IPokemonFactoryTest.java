package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

	@Test
	void testCreatePokemone() {
		IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);
		PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "bulbizarre", 126, 126, 90);
		Pokemon bulbizarre = new Pokemon(613, 64, 4000, 4, 0.56, bulbizarreMetadata);

		Mockito.when(factory.testCreatePokemone(Mockito.any(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(),
				Mockito.anyInt(), Mockito.anyDouble()).thenReturn(bulbizarre));
		Pokemon result = factory.testCreatePokemone(bulbizarreMetadata, 613, 64, 4000, 4, 0.56);
		assertEquals(613, result.getCp());
		assertEquals("Bulbizarre", result.getMetadata().getName());
	}
}