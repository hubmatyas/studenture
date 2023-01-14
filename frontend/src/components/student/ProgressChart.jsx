import React from 'react'
import { Card, Typography, useTheme } from '@mui/material';
import { PieChart, Pie, Tooltip, Cell, Legend, ResponsiveContainer } from 'recharts';

const data = [
  { name: 'Points', value: 64 },
  { name: 'Available points', value: 36 }
];

const ProgressChart = () => {

  const theme = useTheme()

  return (
    <Card sx={{ height: 280, p: theme.spacing(1) }}>
      <Typography>Pointes achieved: {data[0].value}/100</Typography>
      <ResponsiveContainer width="100%" height="100%">
        <PieChart height={240} width={500}>
          <Pie 
            startAngle={180}
            endAngle={0}
            innerRadius="55%"
            data={data}
            dataKey="value"
            nameKey="name"
            blendStroke
            isAnimationActive={false}
            cy={"60%"}
          >
            <Cell fill="#9c27b0" />
            <Cell fill="#9e9e9e" />
          </Pie>
          <Tooltip />
          <Legend verticalAlign="top" align="bottom" />
        </PieChart>
      </ResponsiveContainer>
    </Card>
  )
}

export default ProgressChart
