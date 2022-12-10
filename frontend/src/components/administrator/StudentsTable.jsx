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
    { id: 1, name: 'Carmen', surname: 'Farmer', email: 'geohotz@example.com' },
    { id: 2, name: 'Hector', surname: 'Lawrance', email: 'janedoe@example.com' },
    { id: 3, name: 'Atmos', surname: 'Tucker', email: 'atmostucker@example.com' },
    { id: 4, name: 'Ruben', surname: 'Mitchell', email: 'rubenmitchell@example.com' },
    { id: 5, name: 'Judy', surname: 'Stanley', email: 'judystanley@example.com' },
    { id: 6, name: 'Susie', surname: 'Morrison', email: 'suskiemorrison@example.com' },
    { id: 7, name: 'Lauren', surname: 'Medina', email: 'laurenmedina@example.com' },
    { id: 8, name: 'Maria', surname: 'Bailey', email: 'mariabailey@example.com' },
    { id: 9, name: 'Ramona', surname: 'Hunt', email: 'ramonahunt@example.com' },
    { id: 10, name: 'Derek', surname: 'Valdez', email: 'derekvaldez@example.com' },
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