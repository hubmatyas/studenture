import { Button, IconButton, useTheme } from '@mui/material'
import { DataGrid } from '@mui/x-data-grid'
import { Delete, Edit } from '@mui/icons-material'
import React, {useContext} from 'react'
import { Box } from '@mui/system'
import DialogContext from '../../context/DialogContext';

const SubjectsTable = () => {

  const { setShow, setTaskId } = useContext(DialogContext)

  const theme = useTheme()

  const displayTask = (id) => {
    setShow(true)
    setTaskId(id)
  }

  const COLUMNS = [
    { field: 'id', headerName: 'ID'},
    { field: 'name', headerName: 'Name', flex: 1 },
    { field: 'edit', headerName: 'Edit', width: 100, renderCell: () => <IconButton onClick={displayTask}><Edit /></IconButton> },
    { field: 'delete', headerName: 'Delete', width: 100, renderCell: () => <IconButton><Delete /></IconButton> },
  ]

  const ROWS = [
    { id: 1, name: 'Linear algebra' },
    { id: 2, name: 'Mathematical analysis' },
    { id: 3, name: 'Data science' },
    { id: 4, name: 'Python for data analysis' },
    { id: 5, name: 'Design patterns' },
    { id: 6, name: 'Business english' },
    { id: 7, name: 'Cloud architecture' },
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

export default SubjectsTable