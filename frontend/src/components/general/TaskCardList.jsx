import { Typography } from '@mui/material'
import React from 'react'
import TaskCard from './TaskCard'
import { Box } from '@mui/system'

const TaskCardList = ({ tasks, heading = 'Tasks', error, success }) => {
  return (
    <Box mb={2}>
      <Typography variant='h6' mb={1}>{ heading }</Typography>
      {
        tasks.map(({ id, name, deadline, subject, points }) => (
          <TaskCard
            key={id}
            name={name}
            deadline={deadline}
            subject={subject}
            points={points}
            id={id}
            error={error}
            success={success}
          />
        ))
      }
    </Box>
  )
}

export default TaskCardList