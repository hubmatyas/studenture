import React, { useContext, useEffect, useState } from 'react'
import { Card, Grid, Typography, IconButton, useTheme } from '@mui/material';
import VisibilityIcon from '@mui/icons-material/Visibility';
import DialogContext from '../../context/DialogContext';

const TaskCard = ({ id, name, deadline, points, pointsAchieved, subject }) => {

  const { setShow, setTaskId } = useContext(DialogContext)
  
  const [formattedPoints, setFormattedPoints] = useState('')
  const theme = useTheme()

  const displayTask = (id) => {
    setShow(true)
    setTaskId(id)
  }

  useEffect(() => {
    if (points && pointsAchieved) {
      setFormattedPoints(`${pointsAchieved} / ${points}p`)
    } else if (points) {
      setFormattedPoints(`${points}p`)
    }
  }, [points, pointsAchieved])

  
  return (
    <Card elevation={1} sx={{ marginBottom: theme.spacing(1) }}>
      <Grid container alignItems='center' px={2} py={1}>
        <Grid container item xs={10} alignItems="center">
          <Grid item xs={12} sm={6}>
            <Typography variant="body1">
              { name }
            </Typography>
          </Grid>
          <Grid item xs={12} sm={formattedPoints.length > 0 ? 3 : 6}>
            <Typography variant="body2" color="text.secondary">
              { deadline }
            </Typography>
          </Grid>
          <Grid item xs={12} sm={formattedPoints.length > 0 ? 3 : 6}>
            <Typography variant="body2" color="text.secondary">
              { subject }
            </Typography>
          </Grid>
          {
            formattedPoints.length > 0 
            ? (
            <Grid item xs={12} sm={3} >
              <Typography variant="body2" color="text.secondary">
                { formattedPoints }
              </Typography>
            </Grid>
            )
            : null
          }
        </Grid>
        <Grid item xs={2} display='flex' justifyContent='flex-end'>
          <IconButton onClick={displayTask}>
            <VisibilityIcon />
          </IconButton>
        </Grid>
      </Grid>
    </Card>
  )
}

export default TaskCard