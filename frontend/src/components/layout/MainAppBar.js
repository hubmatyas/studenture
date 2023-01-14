import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import Container from '@mui/material/Container';
import { ReactComponent as Logo } from "./logo.svg";
import { Link } from 'react-router-dom';

export default function MainAppBar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Container maxWidth="xl">
          <Toolbar>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
              <Link to="/">
                <Logo />
              </Link>
            </Typography>
            <Button color="secondary" variant="contained" href="/">Logout</Button>
          </Toolbar>
        </Container>
      </AppBar>
    </Box>
  );
}