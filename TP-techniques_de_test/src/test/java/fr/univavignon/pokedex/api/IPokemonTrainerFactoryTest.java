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

        IPokemonTrainerFactory trainerFactory = new IPokemonTrainerFactory() {
            @Override
            public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
                return new PokemonTrainer(name, team, pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
            }
        };


        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.INSTINCT, pokedexFactory);


        assertEquals("Ash", trainer.getName());
        assertEquals(Team.INSTINCT, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());


        verify(pokedexFactory, times(1)).createPokedex(metadataProvider, pokemonFactory);
    }}

