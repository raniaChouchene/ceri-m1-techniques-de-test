package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.RocketPokemonFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RocketPokemonFactoryTest {

    private RocketPokemonFactory rocketFactory;

    @BeforeEach
    public void setUp() {
        rocketFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithMappedIndex() {
        Pokemon pokemon = rocketFactory.createPokemon(1, 500, 100, 2000, 50);
        assertEquals("Bulbasaur", pokemon.getName());
    }

    @Test
    public void testCreatePokemonWithUnmappedIndex() {
        Pokemon pokemon = rocketFactory.createPokemon(999, 500, 100, 2000, 50);
        assertEquals("MISSINGNO", pokemon.getName());
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        Pokemon pokemon = rocketFactory.createPokemon(-1, 500, 100, 2000, 50);
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0.0, pokemon.getIv(), 0.001); // Checking IV
    }

    @Test
    public void testRandomStatGeneration() {
        int stat = RocketPokemonFactory.generateRandomStat();
        assertTrue(stat >= 0 && stat <= 15, "Stat should be between 0 and 15");
    }

    @Test
    public void testIvCalculation() {
        Pokemon pokemon = rocketFactory.createPokemon(1, 500, 100, 2000, 50);
        double iv = (pokemon.getAttack() + pokemon.getDefense() + pokemon.getStamina()) / 45.0;
        assertEquals(iv, pokemon.getIv(), 0.001);
    }
}
