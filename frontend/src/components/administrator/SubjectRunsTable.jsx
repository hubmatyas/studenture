import { Button, IconButton } from '@mui/material'
import { DataGrid } from '@mui/x-data-grid'
import { Delete, Edit } from '@mui/icons-material'
import React from 'react'
import { Box } from '@mui/system'

const SubjectRunsTable = () => {
  const COLUMNS = [
    { field: 'id', headerName: 'ID'},
    { field: 'name', headerName: 'Name', flex: 1 },
    { field: 'subject', headerName: 'Subject', flex: 1 },
    { field: 'epoch', headerName: 'Epochj', flex: 1 },
    { field: 'edit', headerName: 'Edit', width: 100, renderCell: () => <IconButton><Edit /></IconButton> },
    { field: 'delete', headerName: 'Delete', width: 100, renderCell: () => <IconButton><Delete /></IconButton> },
  ]

  const ROWS = [
    { id: 1, name: 'LA-2020/2021', epoch: '2020/2021', subject: 'Linear algebra',  },
    { id: 2, name: 'MA-2020/2021', epoch: '2020/2021', subject: 'Mathematical analysis' },
    { id: 3, name: 'DS-2020/2021', epoch: '2020/2021', subject: 'Data science' },
    { id: 4, name: 'PFDA-2020/2021', epoch: '2020/2021', subject: 'Python for data analysis' },
    { id: 5, name: 'DP-2020/2021', epoch: '2020/2021', subject: 'Design patterns' },
    { id: 6, name: 'BE-2020/2021', epoch: '2020/2021', subject: 'Business english' },
    { id: 7, name: 'CA-2020/2021', epoch: '2020/2021', subject: 'Cloud architecture' },
  ]

  return (
    <Box display='flex' flexDirection='column' height='100%' flexGrow={1}>
      <Box>
        <Button variant="contained" sx={{ mb: 2 }}>Add new</Button>
      </Box>
      <Box flex={1}>
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
    </Box>    
  )
}

export default SubjectRunsTable