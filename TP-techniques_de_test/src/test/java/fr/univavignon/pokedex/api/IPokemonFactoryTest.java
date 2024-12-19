package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokemonFactoryTest {

	@Test
	void testCreatePokemon() {
		IPokemonFactory factory = new PokemonFactory();
		Pokemon result = factory.createPokemon(0, 613, 64, 4000, 4, 0.56);
		assertEquals("Bulbizarre", result.getName(), "The name of the Pokémon should be Bulbizarre.");
		assertEquals(613, result.getCp(), "The CP should be 613.");
		assertEquals(64, result.getHp(), "The HP should be 64.");
		assertEquals(4000, result.getDust(), "The Dust should be 4000.");
		assertEquals(4, result.getCandy(), "The Candy should be 4.");
		assertEquals(0.56, result.getIv(), "The IV should be 0.56.");
	}
}
