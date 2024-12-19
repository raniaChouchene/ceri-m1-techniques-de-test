package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @BeforeEach
    public void setUp() {

        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);


        pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokemon2 = new Pokemon(2, "Ivysaur", 156, 158, 120, 1000, 100, 5000, 9, 120);


        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size(), "Pokedex size should be 2.");
    }

    @Test
    public void testAddPokemon() {
        Pokemon newPokemon = new Pokemon(3, "Venusaur", 198, 200, 160, 2000, 200, 10000, 15, 240);
        int index = pokedex.addPokemon(newPokemon);
        assertEquals(2, index, "The index of the added Pokemon should be 2.");
        assertEquals(3, pokedex.size(), "Pokedex size should be 3 after adding a new Pokemon.");
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon result = pokedex.getPokemon(0);
        assertEquals(pokemon1, result, "The retrieved Pokemon should be Bulbasaur.");
    }

    @Test
    public void testGetPokemonInvalidId() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(999), "Should throw PokedexException for invalid ID.");
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> result = pokedex.getPokemons();
        assertEquals(2, result.size(), "The list should contain 2 pokemons.");
        assertTrue(result.contains(pokemon1), "The list should contain Bulbasaur.");
        assertTrue(result.contains(pokemon2), "The list should contain Ivysaur.");
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> result = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));
        assertEquals(2, result.size(), "The list should contain 2 pokemons.");
        assertEquals("Bulbasaur", result.get(0).getName(), "The first Pokemon should be Bulbasaur.");
        assertEquals("Ivysaur", result.get(1).getName(), "The second Pokemon should be Ivysaur.");
    }

    @Test
    public void testGetPokemonsSortedEmptyList() {
        IPokedex emptyPokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
        List<Pokemon> result = emptyPokedex.getPokemons(Comparator.comparing(Pokemon::getCp));
        assertTrue(result.isEmpty(), "The sorted list should be empty.");
    }

    @Test
    public void testCreatePokemon() {
        Pokemon result = pokedex.createPokemon(1, 613, 64, 4000, 4);
        assertNotNull(result, "The created Pokemon should not be null.");
        assertEquals("Bulbasaur", result.getName(), "The created Pokemon should be Bulbasaur.");
        assertEquals(613, result.getCp(), "The CP should be 613.");
    }
}
