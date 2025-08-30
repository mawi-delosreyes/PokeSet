export const getPokemonList = async () => {
  const res = await fetch(`http://localhost:8080/pokemon/getList`);
  if (!res.ok) {
    throw new Error('Failed to fetch Pokémon');
  }
  return await res.json();
};

export const getPokemonData = async (pokemonId: number) => {
  const res = await fetch(`http://localhost:8080/pokemon/getPokemonInfo?pokemonId=${pokemonId}`);
  if (!res.ok) {
    throw new Error('Failed to fetch Pokémon Details');
  }
  return await res.json();
};
