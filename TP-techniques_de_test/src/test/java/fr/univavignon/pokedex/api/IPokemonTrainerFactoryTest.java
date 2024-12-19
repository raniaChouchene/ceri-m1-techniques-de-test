package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class IPokemonTrainerFactoryTest {

    @Test
    void testCreateTrainer() {
        IPokedexFactory pokedexFactory = new PokedexFactory();
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
        IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.INSTINCT, pokedexFactory);
        assertEquals("Ash", trainer.getName(), "Le nom du dresseur devrait être 'Ash'.");
        assertEquals(Team.INSTINCT, trainer.getTeam(), "L'équipe du dresseur devrait être 'INSTINCT'.");
        assertEquals(Pokedex.class, trainer.getPokedex().getClass(), "Le pokedex devrait être une instance de 'Pokedex'.");
    }
}
