package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        if (name != null && !name.isEmpty() && team != null && pokedexFactory != null) {
            IPokedex pokedex = pokedexFactory.createPokedex(
                    new PokemonMetadataProvider(),
                    new PokemonFactory(new PokemonMetadataProvider())
            );
            return new PokemonTrainer(name, team, pokedex);
        }
        return null;
    }

}
