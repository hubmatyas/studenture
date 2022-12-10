import { Dialog, Stack, DialogContent, DialogTitle, Typography } from '@mui/material'
import React from 'react'
import { IconButton } from '@mui/material'
import { Close } from '@mui/icons-material'

const TASK = {
  id: 1,
  name: 'Matrix multiplication excercise',
  place: 'Onsite/remote',
  deadline: '4/12/2022',
  lecturer: 'John Doe',
  description: 'Excercise containing 5 tasks for matrix multiplication.'
}

const StudentTaskDetailDialog = ({ open, onClose, id }) => {
  // TODO: Use id for data fetching when backend is ready

  return (
    <Dialog
      maxWidth='lg'
      fullWidth
      open={open}
    >
      <DialogTitle>
        <Stack justifyContent='space-between' direction='row'>
          { TASK.name }
          {/* Create IconButton with close icon */}
          <IconButton
            onClick={onClose}
          >
            <Close />
          </IconButton>
        </Stack>
      </DialogTitle>
      <DialogContent>
        <Typography>Deadline: { TASK.deadline }</Typography>
        <Typography>Place: { TASK.place }</Typography>
        <Typography mb={4}>Lecturer: { TASK.lecturer }</Typography>
        <Typography>{ TASK.description }</Typography>
      </DialogContent>
    </Dialog>
  )
}

export default StudentTaskDetailDialog
