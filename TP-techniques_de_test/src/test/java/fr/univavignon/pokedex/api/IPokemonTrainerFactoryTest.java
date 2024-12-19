package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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
        IPokedexFactory ipokedexFactory=Mockito.mock(IPokedexFactory.class);
        IPokedex  iPokedex=Mockito.mock(IPokedex.class);
        Mockito.when(ipokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(iPokedex);
        PokemonTrainer trainerResult=iPokemonTrainerFactory.createTrainer("",Team.MYSTIC,ipokedexFactory);
        assertEquals(null,trainerResult);

    }
    @Test
    void testCreateTrainerWithNullTeam() {
        IPokedexFactory ipokedexFactory=Mockito.mock(IPokedexFactory.class);
        IPokedex  iPokedex=Mockito.mock(IPokedex.class);
        Mockito.when(ipokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(iPokedex);
        PokemonTrainer trainerResult=iPokemonTrainerFactory.createTrainer("Ash",null,ipokedexFactory);
        assertNull(trainerResult);
    }

    @Test
    void testCreateTrainerWithNullPokedex() {
        PokemonTrainer trainerResult=iPokemonTrainerFactory.createTrainer("Ash",Team.MYSTIC,null);
        assertNull(trainerResult);

    }
