package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
	IPokemonFactory iPokemonFactory;
	IPokemonMetadataProvider metadataProvider;

	@BeforeEach
	void setup() {
		metadataProvider=Mockito.mock(IPokemonMetadataProvider.class);
		iPokemonFactory=new PokemonFactory(metadataProvider);

	}

	@Test
	public void testCreatePokemon() throws PokedexException {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		Mockito.when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiData);
		Pokemon aquali=iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
		assertNotNull(aquali);
		assertEquals(133,aquali.getIndex());
		assertEquals("Aquali",aquali.getName());
		assertEquals(186,aquali.getAttack());
		assertEquals(168,aquali.getDefense());
		assertEquals(260,aquali.getStamina());
		assertEquals(2729,aquali.getCp());
		assertEquals(202,aquali.getHp());
		assertEquals(5000,aquali.getDust());
		assertEquals(4,aquali.getCandy());
		assertEquals(73,aquali.getIv());
	}


	@Test
	public void testCreatePokemonInvalidParameter() throws PokedexException{
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		Mockito.when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiData);
		Pokemon bulbi=iPokemonFactory.createPokemon(-133, 2729, 202, 5000, 4);
		assertNull(bulbi);
		Pokemon bulbi1=iPokemonFactory.createPokemon(133, -2729, 202, 5000, 4);
		assertNull(bulbi1);
		Pokemon bulbi2=iPokemonFactory.createPokemon(133, 2729, -202, 5000, 4);
		assertNull(bulbi2);
		Pokemon bulbi3=iPokemonFactory.createPokemon(133, 2729, 202, -5000, 4);
		assertNull(bulbi3);
		Pokemon bulbi4=iPokemonFactory.createPokemon(133, 2729, 202, 5000, -4);
		assertNull(bulbi4);
	}
}