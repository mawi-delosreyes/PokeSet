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

function StatsRadar() {
  const data = {
    labels: ['HP', 'Attack', 'Defense', 'Sp. Atk', 'Sp. Def', 'Speed'],
    datasets: [
      {
        data: [45, 49, 49, 65, 65, 45], 
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