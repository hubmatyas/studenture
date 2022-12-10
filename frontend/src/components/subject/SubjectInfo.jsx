import React from 'react'
import { Card, Typography, useTheme } from '@mui/material'

const SubjectInfo = ({ name, lecturer, description }) => {
  const theme = useTheme()

  return (  
    <Card sx={{ p: theme.spacing(1), height: '100%' }} >
      <Typography variant='h6'>{ name }</Typography>
      <Typography variant='body1' mb={1}>{ lecturer }</Typography>
      <Typography>{ description }</Typography>
    </Card>
  )
}

export default SubjectInfo