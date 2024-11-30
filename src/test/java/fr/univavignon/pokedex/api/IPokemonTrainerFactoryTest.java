package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory iPokemonTrainerFactory;


    @BeforeEach
    void setup() {

        iPokemonTrainerFactory=new PokemonTrainerFactory();
    }

    @Test
    void testCreateTrainer() {
        IPokedexFactory ipokedexFactory=Mockito.mock(IPokedexFactory.class);
        IPokedex  iPokedex=Mockito.mock(IPokedex.class);
        Mockito.when(ipokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(iPokedex);

        PokemonTrainer trainerResult=iPokemonTrainerFactory.createTrainer("Ash",Team.INSTINCT,ipokedexFactory);

        assertEquals("Ash",trainerResult.getName());
        assertEquals(Team.INSTINCT,trainerResult.getTeam());
        assertEquals(iPokedex,trainerResult.getPokedex());

    }

    @Test
    void testCreateTrainerWithEmptyName() {
        //création d'un entraineur sans nom
        IPokedexFactory ipokedexFactory=Mockito.mock(IPokedexFactory.class);
        IPokedex  iPokedex=Mockito.mock(IPokedex.class);
        //création d'un PokemonTrainer
        //Mockito.when(iPokemonTrainerFactory.createTrainer("", Team.MYSTIC, ipokedexFactory)).thenReturn(null);
        Mockito.when(ipokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(iPokedex);

        PokemonTrainer trainerResult=iPokemonTrainerFactory.createTrainer("",Team.MYSTIC,ipokedexFactory);

        assertEquals(null,trainerResult);

    }

    @Test
    void testCreateTrainerWithNullTeam() {
        //création d'un entraineur sans équipe
        IPokedexFactory ipokedexFactory=Mockito.mock(IPokedexFactory.class);
        IPokedex  iPokedex=Mockito.mock(IPokedex.class);
        Mockito.when(ipokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(iPokedex);

        PokemonTrainer trainerResult=iPokemonTrainerFactory.createTrainer("Ash",null,ipokedexFactory);

        assertNull(trainerResult);

    }

    @Test
    void testCreateTrainerWithNullPokedex() {
        //création d'un entraineur sans pokedex
        PokemonTrainer trainerResult=iPokemonTrainerFactory.createTrainer("Ash",Team.MYSTIC,null);

        assertNull(trainerResult);

    }

}