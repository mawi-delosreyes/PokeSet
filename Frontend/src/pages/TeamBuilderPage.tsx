import '../styles/teambuilder.css';
import { useEffect, useState } from 'react';
import { getTeamList, getTeamData } from '../api/teamList';
import PokemonCard from '../components/PokemonCard';

function TeamBuilderPage() {
  const [team, setTeam] = useState<any>([]);
  const [loading, setLoading] = useState(true);
  const [selectedTeamId, setSelectedTeamId] = useState<number | null>(null);
  const [teamInfo, setTeamInfo] = useState<any>(null);
  const [loadingInfo, setLoadingInfo] = useState(false);
  const [searchQuery, setSearchQuery] = useState('');
  const [hasPokemonTeam, setHasPokemonTeam] = useState([false, false, false, false, false, false]);



  const userId = 1; // Placeholder user ID
  const access = true;

  useEffect(() => {
    getTeamList(userId, access)
      .then(data => {
        if (Array.isArray(data.list) && data.list.length > 0) {
          setTeam(data.list[0]);
        }
        setLoading(false);
      })
      .catch(err => {
        console.error("Fetch error:", err);
        setLoading(false);
      });
  }, []);

  const getSelectedTeamData = async (teamId: number, userId: number, access: boolean) => {
    setSelectedTeamId(teamId);
    setLoadingInfo(true);
    try {
      const info = await getTeamData(teamId, userId, access);
      console.log(info);
      if (info.message === "Team found") {
        setTeamInfo(info.teamInfo);
        Object.values(info.pokemonTeamPresetsModel)
          .forEach((team_preset: any) => {
            if (team_preset != null) {
              hasPokemonTeam[team_preset.presetId - 1] = true;
            }
          });
      }
    } catch (err) {
      console.error("Error fetching stats:", err);
    } finally {
      setLoadingInfo(false);
    }
  };

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
              key={index}
              hasPokemon={hasPokemonTeam[index]}
            />
          ))}
        </div>
      </div>

      <div id='search-team'>
        <input 
          id="search-box-team"
          placeholder="Search a team..."
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
        {loading ? (
          <p>Loading...</p>
        ) : team.length > 0 ? (
          <div id="team-list-container">
            <ul id="team-list">
              {team
                .filter((t: any) =>
                  t.teamName.toLowerCase().includes(searchQuery.toLowerCase())
                )
                .map((t: any, index: number) => (
                  <li
                    key={index}
                    className="team-box"
                    onClick={() => {getSelectedTeamData(t.teamId, userId, access)}}
                  >
                    {t.teamName.toUpperCase()}
                  </li>
                ))}
            </ul>
          </div>
        ) : (
          <p>No team found.</p>
        )}
      </div>
    </div>
    
  );
}

export default TeamBuilderPage;