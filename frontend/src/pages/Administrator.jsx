import * as React from 'react';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Box from '@mui/material/Box';
import a11yProps from '../utils/a11pros';
import SubjectsTable from '../components/administrator/SubjectsTable';
import AdministratorsTable from '../components/administrator/AdministratorsTable';
import SubjectRunsTable from '../components/administrator/SubjectRunsTable';
import StudentsTable from '../components/administrator/StudentsTable';
import ProfessorsTable from '../components/administrator/ProfessorsTable';


const Administrator = () => {
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const TabPanel = (props) => {
    const { children, value, index, ...other } = props;

    return (
      <Box
        flex={1}
        role="tabpanel"
        hidden={value !== index}
        id={`simple-tabpanel-${index}`}
        aria-labelledby={`simple-tab-${index}`}
        {...other}
      >
        {value === index && (
          <Box sx={{ py: 1, height: '100%' }}>
            {children}
          </Box>
        )}
      </Box>
    );
  }

  return (
    <Box width='100%' display='flex' flexDirection='column' height='100%'>
      <Box sx={{ borderBottom: 1, borderColor: 'divider', flex: 0 }}>
        <Tabs value={value} onChange={handleChange} aria-label="basic tabs example">
          <Tab label="Subjects" {...a11yProps(0)} />
          <Tab label="Subject runs" {...a11yProps(1)} />
          <Tab label="Students" {...a11yProps(2)} />
          <Tab label="Professors" {...a11yProps(3)} />
          <Tab label="Administrators" {...a11yProps(4)} />
        </Tabs>
      </Box>
      <TabPanel value={value} index={0}>
        <SubjectsTable />
      </TabPanel>
      <TabPanel value={value} index={1}>
        <SubjectRunsTable />
      </TabPanel>
      <TabPanel value={value} index={2}>
        <StudentsTable />
      </TabPanel>
      <TabPanel value={value} index={3}>
        <ProfessorsTable />
      </TabPanel>
      <TabPanel value={value} index={4}>
        <AdministratorsTable />
      </TabPanel>
    </Box>
  );
}

export default Administrator;