package fr.univavignon.pokedex.api;

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
        // Testing with a mapped index (Bulbasaur)
        Pokemon pokemon = rocketFactory.createPokemon(1, 500, 100, 2000, 50);
        assertEquals("Bulbasaur", pokemon.getName());
    }

    @Test
    public void testCreatePokemonWithUnmappedIndex() {
        // Testing with an unmapped index (MISSINGNO)
        Pokemon pokemon = rocketFactory.createPokemon(999, 500, 100, 2000, 50);
        assertEquals("MISSINGNO", pokemon.getName());
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        // Testing with a negative index (Ash's Pikachu)
        Pokemon pokemon = rocketFactory.createPokemon(-1, 500, 100, 2000, 50);
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0.0, pokemon.getIv(), 0.001); // Checking IV
    }

    @Test
    public void testRandomStatGeneration() {
        // Testing if the random stat is between 0 and 15
        int stat = RocketPokemonFactory.generateRandomStat();
        assertTrue(stat >= 0 && stat <= 15, "Stat should be between 0 and 15");
    }

    @Test
    public void testIvCalculation() {
        // Testing IV calculation (attack + defense + stamina) / 45.0
        Pokemon pokemon = rocketFactory.createPokemon(1, 500, 100, 2000, 50);
        double iv = (pokemon.getAttack() + pokemon.getDefense() + pokemon.getStamina()) / 45.0;
        assertEquals(iv, pokemon.getIv(), 0.001);
    }

    @Test
    public void testCreatePokemonWithValidMetadata() {
        // Creating valid PokemonMetadata
        PokemonMetadata metadata = new PokemonMetadata(1, "Bulbasaur", 20, 25, 30); // Example values for stats

        // Create a Pokemon with valid metadata
        Pokemon pokemon = rocketFactory.createPokemon(metadata, 500, 100, 2000, 50, 0.85);

        // Validate the created Pokemon
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(20, pokemon.getAttack());
        assertEquals(25, pokemon.getDefense());
        assertEquals(30, pokemon.getStamina());
        assertEquals(500, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(2000, pokemon.getDust());
        assertEquals(50, pokemon.getCandy());
        assertEquals(0.85, pokemon.getIv(), 0.001);
    }
}
