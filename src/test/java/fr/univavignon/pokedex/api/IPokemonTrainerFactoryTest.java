package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    @Test
    void testCreateTrainer() {
        IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
        IPokemonTrainerFactory trainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        PokemonTrainer expectedTrainer = new PokemonTrainer("Ash", Team.INSTINCT, pokedex);
        when(trainerFactory.createTrainer("Ash", Team.INSTINCT, pokedexFactory)).thenReturn(expectedTrainer);
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.INSTINCT, pokedexFactory);

        assertEquals("Ash", trainer.getName(), "Trainer's name should be 'Ash'");
        assertEquals(Team.INSTINCT, trainer.getTeam(), "Trainer's team should be Team.INSTINCT");
        assertEquals(pokedex, trainer.getPokedex(), "Trainer's pokedex should match the expected pokedex");


        verify(pokedexFactory, times(1)).createPokedex(metadataProvider, pokemonFactory);
    }
}
