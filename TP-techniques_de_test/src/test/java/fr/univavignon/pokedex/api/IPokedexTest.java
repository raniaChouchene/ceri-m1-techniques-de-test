package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @BeforeEach
    public void setUp() {
        // Mock the IPokedex interface
        pokedex = Mockito.mock(IPokedex.class);

        // Create sample Pokemon objects for testing
        pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokemon2 = new Pokemon(2, "Ivysaur", 156, 158, 120, 1000, 100, 5000, 9, 120);
    }

    @Test
    public void testSize() {
        when(pokedex.size()).thenReturn(2);
        assertEquals(2, pokedex.size(), "Pokedex size should be 2.");
    }

    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(pokemon1)).thenReturn(1);
        int index = pokedex.addPokemon(pokemon1);
        assertEquals(1, index, "The index of the added Pokemon should be 1.");
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(1)).thenReturn(pokemon1);
        Pokemon result = pokedex.getPokemon(1);
        assertEquals(pokemon1, result, "The retrieved Pokemon should be Bulbasaur.");
    }

    @Test
    public void testGetPokemonInvalidId() throws PokedexException {
        when(pokedex.getPokemon(999)).thenThrow(new PokedexException("Invalid ID"));
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(999), "Should throw PokedexException for invalid ID.");
    }

    @Test
    public void testGetPokemons() {
        // Mock the getPokemons() method
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        when(pokedex.getPokemons()).thenReturn(pokemons);

        List<Pokemon> result = pokedex.getPokemons();
        assertEquals(2, result.size(), "The list should contain 2 pokemons.");
        assertTrue(result.contains(pokemon1), "The list should contain Bulbasaur.");
        assertTrue(result.contains(pokemon2), "The list should contain Ivysaur.");
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);

        when(pokedex.getPokemons(any(Comparator.class))).thenReturn(pokemons);

        List<Pokemon> result = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));
        assertEquals(2, result.size(), "The list should contain 2 pokemons.");
        assertEquals("Bulbasaur", result.get(0).getName(), "The first Pokemon should be Bulbasaur.");
    }

    @Test
    public void testGetPokemonsSortedEmptyList() {
        when(pokedex.getPokemons(any(Comparator.class))).thenReturn(new ArrayList<>());

        List<Pokemon> result = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));
        assertTrue(result.isEmpty(), "The sorted list should be empty.");
    }

    @Test
    public void testGetPokemonsSortedSinglePokemon() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon1);

        when(pokedex.getPokemons(any(Comparator.class))).thenReturn(pokemons);

        List<Pokemon> result = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));
        assertEquals(1, result.size(), "The list should contain only one Pokemon.");
        assertEquals("Bulbasaur", result.get(0).getName(), "The only Pokemon should be Bulbasaur.");
    }

    @Test
    public void testCreatePokemon() {
        when(pokedex.createPokemon(1, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56));

        Pokemon result = pokedex.createPokemon(1, 613, 64, 4000, 4);
        assertNotNull(result, "The created Pokemon should not be null.");
        assertEquals("Bulbasaur", result.getName(), "The created Pokemon should be Bulbasaur.");
        assertEquals(613, result.getCp(), "The CP should be 613.");
    }
}
