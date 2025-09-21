import '../styles/teambuilder.css';
import PokemonCard from '../components/PokemonCard';

function TeamBuilderPage() {
  return (
    <div id="page-body">

      <div id="team-container">
        <div id="heading">
          <input id="teamname-input" placeholder="Enter Team Name" />
          <div id="heading-buttons">
            <button id="save-button">Save</button>
            <button id="delete-button">Delete</button>
          </div>
        </div>

        <div id="pokemon-card-grid">        
          {Array.from({ length: 6 }).map((_, index) => (
            <PokemonCard
              hasPokemon={false}
            />
          ))}
        </div>
      </div>

      <div id='search-team'>
        <input 
          id="search-box-team"
          placeholder="Search a team..."
        />
      </div>
    </div>
    
  );
}

export default TeamBuilderPage;