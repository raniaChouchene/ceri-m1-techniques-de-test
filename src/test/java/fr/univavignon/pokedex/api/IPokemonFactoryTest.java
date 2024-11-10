package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

	@Test
	void testCreatePokemon() {
		IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);
		PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		Pokemon bulbizarre = new Pokemon(bulbizarreMetadata, 613, 64, 4000, 4, 0.56);
		Mockito.when(factory.createPokemon(bulbizarreMetadata, 613, 64, 4000, 4, 0.56)).thenReturn(bulbizarre);
		Pokemon result = factory.createPokemon(bulbizarreMetadata, 613, 64, 4000, 4, 0.56);
		assertEquals(613, result.getCp());
		assertEquals("Bulbizarre", result.getName());
		assertEquals(64, result.getHp());
		assertEquals(4000, result.getDust());
		assertEquals(4, result.getCandy());
		assertEquals(0.56, result.getIv(), 0.0001);
	}
}
