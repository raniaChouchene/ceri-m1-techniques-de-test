package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;
    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            double iv = calculateIV(cp, hp, dust);
            return new Pokemon(
                    index,
                    "Aquali",
                    186,
                    168,
                    260,
                    cp,
                    hp,
                    dust,
                    candy,
                    iv
            );
        } catch (PokedexException e) {
            e.printStackTrace();
            return null;
        }
    }
    private double calculateIV(int cp, int hp, int dust) {
        return (cp + hp + dust ) / 45;
    }

    @Override
    public Pokemon createPokemon(PokemonMetadata metadata, int cp, int hp, int dust, int candy, double iv) {
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
