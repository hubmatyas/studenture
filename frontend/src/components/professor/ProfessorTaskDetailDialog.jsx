import { Button, Dialog, DialogActions, TextField, Stack, DialogContent, DialogTitle, Typography, Box } from '@mui/material'
import React from 'react'
import { IconButton } from '@mui/material'
import { Close } from '@mui/icons-material'
import { DataGrid } from '@mui/x-data-grid'

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

  // allow only numbers and control keys
  const regexNumbersOnly = new RegExp(/^[0-9\b\x7F]+$/)

  const COLUMNS = [
    {
      field: 'name',
      headerName: 'Name',
      width: 150,
      filterable: false,
      sortable: false,
      editable: false,
    },
    {
      field: 'achieved',
      headerName: 'Achieved points',
      flex: 1,
      headerAlign: 'right',
      filterable: false,
      sortable: false,
      editable: false,
      renderCell: (params) => (
        <Stack justifyContent='flex-end' direction='row' width='100%' px={1}>
          <TextField 
            sx={{
              maxWidth: 200
            }}
            onKeyDown={(event) => {
              if (!regexNumbersOnly.test(event.key)) {
                event.preventDefault();
              }
            }}
            type='number'
            size='small'
            id="standard-basic"
            label="Points"
            variant="standard" 
            />
        </Stack>
      )
    }
  ]

  const ROWS = [
    {
      id: 1,
      name: 'Ken Christensen',
    },
    {
      id: 2,
      name: 'Ethel Mason',
    },
    {
      id: 3,
      name: 'Easter Mcdonald',
    },
    {
      id: 4,
      name: 'John Doe',
    },
    {
      id: 5,
      name: 'Frank Peters',
    },
    {
      id: 6,
      name: 'Lorenzo Weaver',
    },
    {
      id: 7,
      name: 'Luther Garrett',
    },
    {
      id: 8,
      name: 'Keanu Reeves',
    },
  ]

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
        <Box mb={2}>
          <Typography>Deadline: { TASK.deadline }</Typography>
          <Typography>Place: { TASK.place }</Typography>
          <Typography>{ TASK.description }</Typography>
        </Box>
        <Typography variant='h6'>Students</Typography>
        <Box height={300}>
          <DataGrid 
            columns={COLUMNS}
            rows={ROWS}
            sx={{
              '& .MuiDataGrid-iconSeparator': {
                display: 'none',
              },
              maxHeight: '100%',
              border: 'none',
            }}
            disableColumnFilter
            disableColumnMenu
            disableSelectionOnClick
          />
        </Box>
      </DialogContent>
      <DialogActions>
        <Button variant='contained' color='primary'>Submit</Button>
      </DialogActions>
    </Dialog>
  )
}

export default StudentTaskDetailDialog