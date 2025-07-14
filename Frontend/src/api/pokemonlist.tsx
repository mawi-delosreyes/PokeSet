export const getPokemonList = async () => {
    const res = await fetch(`http://localhost:8080/pokemon/getList`);
    if (!res.ok) {
      throw new Error('Failed to fetch Pokémon');
    }
    return await res.json();
  };