import '../styles/home.css';
import { useNavigate } from 'react-router-dom';
import { Button } from '../components/Buttons';

function HomePage() {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      <div>
        <h1 className="home-header">Build Your Ultimate Pokemon Team</h1>
        <h3 className="home-subtext">Analyze stats, perfect your strategy, and dominate the competition!</h3>
      </div>

      <div className="button-alignment">
        <Button className='home-button' onClick={() => navigate('/teambuilder')}>Start building a team now!</Button>
        <Button className='home-button' onClick={() => navigate('/pokedex')}>Explore the Pokedex</Button>
      </div>

    </div>
  );
}

export default HomePage;