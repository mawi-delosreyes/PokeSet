import { Radar } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  RadialLinearScale,
  PointElement,
  LineElement,
  Filler,
  Tooltip,
  Legend,
} from 'chart.js';
import { color } from 'chart.js/helpers';

ChartJS.register(
  RadialLinearScale,
  PointElement,
  LineElement,
  Filler,
  Tooltip,
  Legend
);

type StatsObject = {
  hp?: number;
  attack?: number;
  defense?: number;
  special_attack?: number;
  special_defense?: number;
  speed?: number;
};

type StatsRadarProps = {
  stats: StatsObject;
};

function StatsRadar({ stats }: StatsRadarProps) {
  const data = {
    labels: ['HP', 'Attack', 'Defense', 'Speed', 'Sp. Def', 'Sp. Atk'],
    datasets: [
      {
        data: [
          stats.hp || 0,
          stats.attack || 0,
          stats.defense || 0,
          stats.speed || 0,
          stats.special_defense || 0,
          stats.special_attack || 0,
        ],
        backgroundColor: 'rgba(59, 130, 246, 0.2)',
        borderColor: '#FFD70033',
        borderWidth: 2,
      },
    ],
  };

  const options = {
    plugins: {
        legend: {
        display: false,
        },
        tooltip: {
          callbacks: {
            label: function (context: any) {
              const statNames = ['HP', 'Attack', 'Defense', 'Speed', 'Sp. Def', 'Sp. Atk'];
              return `${statNames[context.dataIndex]}: ${context.raw}`;
            }
          }
        }
    },
    scales: {
      r: {
        angleLines: { display: true, color: '#FFD70033' },
        grid: { color: '#FFD70033' },
        suggestedMin: 0,
        suggestedMax: 100,
        ticks: { stepSize: 20, display: false},
      },
    },
  };

  return <Radar data={data} options={options} />;
}

export default StatsRadar;