import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { SaleSucces } from 'types/sale';
import { round } from 'utils/fomart';
import { BASE_URL } from 'utils/requests';

type SeriesData = {
    name: string;
    data: number[];
}

type ChartData = {
    labels: {
        categories: string[];
    },
    series: SeriesData[];
}



function BarChart() {

    const [chartData, setChartData] = useState<ChartData>(
        {
            labels: {
                categories: []
            },
            series: [
                {
                    name: "",
                    data: []
                }
            ]
        }
    )

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/succes-by-seller`)
            .then(response => {
                const data = response.data as SaleSucces[];
                const myLabels = data.map(x => x.sellerName)
                const mySeries = data.map(x => round(x.deals / x.visited * 100, 1));

                setChartData({
                    labels: {
                        categories: myLabels
                    },
                    series: [
                        {
                            name: "% Succes",
                            data: mySeries
                        }
                    ]
                });
            });
    }, []);

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <Chart
            options={{ ...options, xaxis: chartData.labels }}
            series={chartData.series}
            type="bar"
            height="240"
        />
    );
}

export default BarChart;
