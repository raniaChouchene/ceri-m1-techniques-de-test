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
        Pokemon pokemon = rocketFactory.createPokemon(1, 500, 100, 2000, 50);
        assertEquals("Bulbasaur", pokemon.getName(), "Le Pokémon à l'index 1 devrait être 'Bulbasaur'.");
    }

    @Test
    public void testCreatePokemonWithUnmappedIndex() {
        Pokemon pokemon = rocketFactory.createPokemon(999, 500, 100, 2000, 50);
        assertEquals("MISSINGNO", pokemon.getName(), "Un index non mappé devrait renvoyer 'MISSINGNO'.");
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        Pokemon pokemon = rocketFactory.createPokemon(-1, 500, 100, 2000, 50);
        assertEquals("Ash's Pikachu", pokemon.getName(), "Un index négatif devrait renvoyer 'Ash's Pikachu'.");
        assertEquals(1000, pokemon.getAttack(), "L'attaque de 'Ash's Pikachu' devrait être 1000.");
        assertEquals(1000, pokemon.getDefense(), "La défense de 'Ash's Pikachu' devrait être 1000.");
        assertEquals(1000, pokemon.getStamina(), "L'endurance de 'Ash's Pikachu' devrait être 1000.");
        assertEquals(0.0, pokemon.getIv(), 0.001, "Le IV de 'Ash's Pikachu' devrait être 0.");
    }

    @Test
    public void testRandomStatGeneration() {
        int stat = RocketPokemonFactory.generateRandomStat();
        assertTrue(stat >= 0 && stat <= 15, "Une statistique générée devrait être entre 0 et 15.");
    }

    @Test
    public void testIvCalculation() {
        Pokemon pokemon = rocketFactory.createPokemon(1, 500, 100, 2000, 50);
        double expectedIv = (pokemon.getAttack() + pokemon.getDefense() + pokemon.getStamina()) / 45.0;
        assertEquals(expectedIv, pokemon.getIv(), 0.001, "Le calcul du IV devrait être correct.");
    }
}
