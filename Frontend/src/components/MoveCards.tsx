import React from 'react';
import '../styles/movecard.css';

type MoveCardsProps = {
  name: string;
  power: number | string;
  accuracy: number | string;
  category: string;
  pp: number | string;
  description: string;
  type: string;
};

const MoveCards: React.FC<MoveCardsProps> = ({
  name,
  power,
  accuracy,
  category,
  pp,
  description,
  type,
}) => (
  <div className="move-card">
    <div className="move-card-header">
      {/* <div
        className="move-type-icon"
        style={{ backgroundColor: type?.toLowerCase() === 'grass' ? 'green' : '#a6bcf0ff' }}
      /> */}
      <h3>{name}</h3>
      <div className="stats">
        <p>Power: {power}</p>{' '}
        <p>Accuracy: {accuracy}</p>{' '}
        <p>Category: {category}</p>{' '}
        <p>PP: {pp}</p>
      </div>
    </div>
    <p>{description}</p>
  </div>
);

export default MoveCards;