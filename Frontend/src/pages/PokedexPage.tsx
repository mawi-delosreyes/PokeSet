import '../styles/pokedex.css'
import '../styles/movecard.css';
import { useEffect, useState } from 'react';
import { getPokemonList, getPokemonData } from '../api/pokemonlist';
import PokemonRadar from '../components/StatsRadar';
import MoveCards from '../components/MoveCards';

function PokedexPage() {
  const [pokemon, setPokemon] = useState<any>([]);
  const [loading, setLoading] = useState(true);
  const [selectedPokemon, setSelectedPokemon] = useState<number | null>(null);
  const [pokemonInfo, setPokemonInfo] = useState<any>(null);
  const [loadingInfo, setLoadingInfo] = useState(false);
  const [searchQuery, setSearchQuery] = useState('');

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
    setLoadingInfo(true);
    try {
      const info = await getPokemonData(pokemonId);
      console.log(info);
      setPokemonInfo(info.pokemonInfo);
    } catch (err) {
      console.error("Error fetching stats:", err);
    } finally {
      setLoadingInfo(false);
    }
  };

  return (
    <>
      <div id="pokemon-stats">
        <div id="pokemon-row1">
          <div id="pokemon-sprite-wrapper">
            {loadingInfo ? (
              <div className="pokemon-sprite-box">Loading sprite...</div>
            ) : pokemonInfo?.spriteUrl ? (
              <img
                className="pokemon-sprite"
                src={pokemonInfo.spriteUrl}
                alt={pokemon.find((p: any) => p.pokemonId === selectedPokemon)?.pokemonName}
              />
            ) : (
              <p>No Sprite </p>
            )}
          </div>

          <div id="pokemon-info">
            <h2>{selectedPokemon ? `#${selectedPokemon} ${pokemon.find((p: any) => p.pokemonId === selectedPokemon)?.pokemonName.toUpperCase()}` : "Select a Pokémon"}</h2>
            <p>{loadingInfo ? "Loading description..." : (pokemonInfo?.description || "No Description Available")}</p>
            <p>Type: {loadingInfo ? "Loading..." : `${pokemonInfo?.type1}${pokemonInfo?.type2 ? `, ${pokemonInfo.type2}` : ''}`}</p>
            <p>Weaknesses: {loadingInfo ? "Loading..." : (pokemonInfo?.weaknesses?.length ? pokemonInfo.weaknesses.join(', ') : 'None')}</p>            
            <p>Abilities:</p>
            {loadingInfo ? (
              <p>Loading abilities...</p>
            ) : (
              <div id="pokemon-abilities">
                {pokemonInfo?.abilities?.map((ability: any, index: number) => {
                  const name = Object.keys(ability)[0];
                  return (
                    <p key={index}>
                      <strong>{name}</strong> - {ability[name]}
                    </p>
                  );
                })}
              </div>
            )}            
          </div>
        </div>

        <div id="pokemon-row2">
          <div id="stats-radar">
            <h2>Base Stats</h2>
            <PokemonRadar stats={loadingInfo ? {} : (pokemonInfo?.statList || {})} />          
          </div>

          <div id="pokemon-moves">
            <h2>Moves</h2>
            <div id="move-list">
              {loadingInfo ? (
                <MoveCards
                  name="Loading..."
                  power="..."
                  accuracy="..."
                  category="..."
                  pp="..."
                  description=""
                  // type={null}
                />
              ) : selectedPokemon && pokemonInfo?.moveList?.length > 0 ? (
                pokemonInfo.moveList.map((move: any, index: number) => (
                  <MoveCards
                    key={index}
                    name={move.name}
                    power={move.power}
                    accuracy={move.accuracy}
                    category={move.category}
                    pp={move.pp}
                    description={move.description}
                    // type={move.type}
                  />
                ))
              ) : (
                <MoveCards
                  name="Move Name"
                  power=""
                  accuracy=""
                  category=""
                  pp=""
                  description=""
                  // type={null}
                />
              )}
            </div>
          </div>
        </div>

      </div>

      <div className="search-pokemon">
        <input
          id="search-box-pokedex"
          placeholder="Search Pokemon"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
        {loading ? (
          <p>Loading...</p>
        ) : pokemon.length > 0 ? (
          <div id="pokemon-list-container">
            <ul>
              {pokemon
                .filter((p: any) =>
                  p.pokemonName.toLowerCase().includes(searchQuery.toLowerCase())
                )
                .map((p: any, index: number) => (
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