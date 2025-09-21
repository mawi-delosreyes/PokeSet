import React from "react";
import '../styles/pokemoncard.css';

type PokemonCardProps = {
    hasPokemon?: boolean;
}

const PokemonCard: React.FC<PokemonCardProps> = ({ hasPokemon }) => (
    <div>
        {hasPokemon ? (
                <div className="pokemon-card">
                    <p>Pokémon here</p>
                </div>
            ) : (
                <div id="empty-pokemon-card" className="pokemon-card">
                    <p>+ Add Pokémon</p>
                </div>
            )
        }
    </div>

);

export default PokemonCard;