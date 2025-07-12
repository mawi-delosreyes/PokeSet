import { Routes, Route } from 'react-router-dom';
import NavBar from './components/NavBar';
import HomePage from './pages/HomePage';
import PokedexPage from './pages/PokedexPage';
import TeamBuilderPage from './pages/TeamBuilderPage';
import PokePresetsPage from './pages/PokePresetsPage';

function App() {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', minHeight: '100vh' }}>
      <NavBar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/pokedex" element={<PokedexPage />} />
        <Route path="/teambuilder" element={<TeamBuilderPage />} />
        <Route path="/pokepresets" element={<PokePresetsPage />} />
      </Routes>
    </div>
  );
}

export default App;