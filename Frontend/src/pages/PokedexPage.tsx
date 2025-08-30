import '../styles/pokedex.css'
import { useEffect, useState } from 'react';
import { getPokemonList, getPokemonData } from '../api/pokemonlist';
import PokemonRadar from '../components/StatsRadar';

function PokedexPage() {
  const [pokemon, setPokemon] = useState<any>([]);
  const [loading, setLoading] = useState(true);
  const [selectedPokemon, setSelectedPokemon] = useState<number | null>(null);
  const [pokemonInfo, setPokemonInfo] = useState<any>(null);

  useEffect(() => {
    getPokemonList()
      .then(data => {
        if (Array.isArray(data.pokemonList) && data.pokemonList.length > 0) {
          setPokemon(data.pokemonList[0]);
        }
        setLoading(false);
      })
      .catch(err => {
        console.error("Fetch error:", err);
        setLoading(false);
      });
  }, []);

  const getSelectedPokemonData = async (pokemonId: number) => {
    setSelectedPokemon(pokemonId);
    try {
      const info = await getPokemonData(pokemonId);
      setPokemonInfo(info.pokemonInfo);
    } catch (err) {
      console.error("Error fetching stats:", err);
    }
  };

  return (
    <>
      <div id="pokemon-stats">
        <div id="pokemon-row1">
          <img className="pokemon-sprite"
            src={pokemonInfo?.spriteUrl || null}
            alt={pokemon.find((p: any) => p.pokemonId === selectedPokemon)?.pokemonName}
          />

          <div id="pokemon-info">
            <h2>{selectedPokemon ? `#${selectedPokemon} ${pokemon.find((p: any) => p.pokemonId === selectedPokemon)?.pokemonName.toUpperCase()}` : "Select a Pokémon"}</h2>
            <p>{pokemonInfo?.description || "No Description Available"}</p>
            <p>Type: {pokemonInfo?.type1}{pokemonInfo?.type2 ? `, ${pokemonInfo.type2}` : ''}</p>
            <p>Weaknesses: {pokemonInfo?.weaknesses?.length ? pokemonInfo.weaknesses.join(', ') : 'None'}</p>            
            <p>Abilities:</p>
            <ul>
              {pokemonInfo?.abilities?.map((ability: any, index: number) => {
                const name = Object.keys(ability)[0];
                return (
                  <li key={index}>
                    {name}: {ability[name]}
                  </li>
                );
              })}
            </ul>            
          </div>
        </div>

        <div id="pokemon-row2">
          <div id="stats-radar">
            <h2>Base Stats</h2>
            <PokemonRadar/>
          </div>

          <div id="pokemon-evolution">
            <h2>Evolution</h2>
          </div>
        </div>

        <div id="pokemon-row3">
          <h2>Moves</h2>
        </div>
      </div>

      <div className="search-outline">
        <input id="search-box" placeholder="Search Pokemon" />
        {loading ? (
          <p>Loading...</p>
        ) : pokemon.length > 0 ? (
          <div id="pokemon-list-container">
            <ul>
              {pokemon.map((p, index) => (
                <li
                  key={index}
                  className="pokemon-box"
                  onClick={() => getSelectedPokemonData(p.pokemonId)}
                >
                  #{p.pokemonId} {p.pokemonName.toUpperCase()}
                </li>
              ))}
            </ul>
          </div>
        ) : (
          <p>No Pokémon found.</p>
        )}
      </div>

    </>
  );
}

export default PokedexPage;