import { NavLink } from 'react-router-dom';
import '../styles/navbar.css';

function NavBar() {
  return (
    <nav className="navbar">
      <div className="navbar-inner">
        <div className="navbar-left">
          <div className="navbar-logo">PokeSet</div>
        </div>

        <ul className="navbar-links">
          <li><NavLink to="/" className={({ isActive }) => isActive ? 'active-link' : 'inactive-link'}>Home</NavLink></li>
          <li><NavLink to="/pokedex" className={({ isActive }) => isActive ? 'active-link' : 'inactive-link'}>Pokedex</NavLink></li>
          <li><NavLink to="/teambuilder" className={({ isActive }) => isActive ? 'active-link' : 'inactive-link'}>Team Builder</NavLink></li>
          <li><NavLink to="/pokepresets" className={({ isActive }) => isActive ? 'active-link' : 'inactive-link'}>Poke Presets</NavLink></li>
        </ul>

        <div className="navbar-right">
          <div className="navbar-login">Login</div>
        </div>
      </div>
    </nav>
  );
}

export default NavBar;