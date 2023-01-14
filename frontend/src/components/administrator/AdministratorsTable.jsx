import { Button, IconButton } from '@mui/material'
import { DataGrid } from '@mui/x-data-grid'
import { Delete, Edit } from '@mui/icons-material'
import React from 'react'
import { Box } from '@mui/system'

const AdministratorsTable = () => {
  const COLUMNS = [
    { field: 'id', headerName: 'ID'},
    { field: 'name', headerName: 'Name', flex: 1 },
    { field: 'surname', headerName: 'Surname', flex: 1},
    { field: 'email', headerName: 'Email', flex: 1 },
    { field: 'edit', headerName: 'Edit', width: 100, renderCell: () => <IconButton><Edit /></IconButton> },
    { field: 'delete', headerName: 'Delete', width: 100, renderCell: () => <IconButton><Delete /></IconButton> },
  ]

  const ROWS = [
    { id: 1, name: 'John', surname: 'Doe', email: 'johndoe@example.com' },
    { id: 2, name: 'Jane', surname: 'Doe', email: 'janedoe@example.com' },
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

export default AdministratorsTable