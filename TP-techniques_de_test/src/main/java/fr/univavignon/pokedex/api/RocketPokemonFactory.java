package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Collections;

/**
 * A factory for creating Pokemon objects using Team Rocket's logic.
 */
public class RocketPokemonFactory implements IPokemonFactory {

    private static final Map<Integer, String> index2name;

    static {
        Map<Integer, String> aMap = new HashMap<>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        aMap.put(2, "Ivysaur");
        aMap.put(3, "Venusaur");

        index2name = Collections.unmodifiableMap(aMap);
    }

    /**
     * Generates a random stat between 0 and 15.
     *
     * @return A random stat value.
     */
    public static int generateRandomStat() {
        Random random = new Random();
        return random.nextInt(16);
    }

    /**
     * Creates a Pokemon object based on the given parameters and Team Rocket's logic.
     *
     * @param index The Pokémon index.
     * @param cp    The combat power of the Pokémon.
     * @param hp    The hit points of the Pokémon.
     * @param dust  The stardust cost for powering up the Pokémon.
     * @param candy The candy cost for evolving the Pokémon.
     * @return A new Pokémon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name = index2name.getOrDefault(index, "MISSINGNO");

        int attack, defense, stamina;
        double iv;

        if (index < 0) {
            // Special case for invalid Pokémon index
            attack = 1000;
            defense = 1000;
            stamina = 1000;
            iv = 0.0;
        } else {
            attack = generateRandomStat();
            defense = generateRandomStat();
            stamina = generateRandomStat();
            iv = (attack + defense + stamina) / 45.0;
        }

        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }


    /**
     * Creates a Pokemon object based on the given metadata and additional parameters, including a specific IV.
     *
     * @param metadata Metadata containing Pokémon stats.
     * @param cp       The combat power of the Pokémon.
     * @param hp       The hit points of the Pokémon.
     * @param dust     The stardust cost for powering up the Pokémon.
     * @param candy    The candy cost for evolving the Pokémon.
     * @param iv       The individual value (IV) of the Pokémon.
     * @return A new Pokémon instance.
     */
    @Override
    public Pokemon createPokemon(PokemonMetadata metadata, int cp, int hp, int dust, int candy, double iv) {
        if (metadata == null) {
            throw new IllegalArgumentException("PokemonMetadata cannot be null");
        }

        return new Pokemon(
                metadata.getIndex(),
                metadata.getName(),
                metadata.getAttack(),
                metadata.getDefense(),
                metadata.getStamina(),
                cp,
                hp,
                dust,
                candy,
                iv
        );
    }
}
