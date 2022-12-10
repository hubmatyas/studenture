import React, { Fragment } from 'react'
import MainAppBar from './MainAppBar';
import Container from '@mui/material/Container';
import Box from '@mui/material/Box';

const Layout = ({ children }) => {
  return (
    <Fragment>
      <MainAppBar />
      <Container maxWidth="lg" sx={{ height: 'calc(100vh - 64px)'}}>
        <Box py={2} height="100%">
          { children }
        </Box>
      </Container>
    </Fragment>
  )
}

export default Layout