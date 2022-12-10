import React from 'react'
import { Card, Grid, Typography, IconButton, useTheme } from '@mui/material';
import CallMade from '@mui/icons-material/CallMade';
import { useHref, useNavigate } from 'react-router-dom'

const SchoolYearCard = ({ name, id }) => {
  const theme = useTheme()

  const navigate = useNavigate();
  const href = useHref()

  const handleOnClick = () => {
    navigate(`${href}/subject/${id}`)
  }

  return (
    <Card elevation={1} sx={{ marginBottom: theme.spacing(1) }}>
      <Grid container alignItems='center' px={2} py={1}>
        <Grid item xs={10}>
          <Typography variant="body1">
            { name }  
          </Typography>
        </Grid>
        <Grid item xs={2} display='flex' justifyContent='flex-end'>
          <IconButton onClick={handleOnClick}> 
            <CallMade />
          </IconButton>
        </Grid>
      </Grid>
    </Card>
  )
}

export default SchoolYearCard