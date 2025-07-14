import '../styles/pokedex.css'
import { useEffect, useState } from 'react';
import { getPokemonList } from '../api/pokemonlist';

function PokedexPage() {
  const [pokemon, setPokemon] = useState<any>([]);
  const [loading, setLoading] = useState(true);
  const [selectedPokemon, setSelectedPokemon] = useState<string | null>(null);

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

  return (
    <>
      <h1 className="home-title">  {selectedPokemon || "Welcome to PokeSet Pokedex Page"}</h1>

      <div className="search-outline">
        <input className="search-box" placeholder="Search Pokemon" />
        {loading ? (
          <p>Loading...</p>
        ) : pokemon.length > 0 ? (
          <div className="pokemon-list-container">
            <ul>
              {pokemon.map((p, index) => (
                <li
                  key={index}
                  className="pokemon-box"
                  onClick={() => setSelectedPokemon(p.pokemonId)}
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