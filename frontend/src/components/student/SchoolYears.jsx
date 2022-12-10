import React, { Fragment } from 'react'
import { Box, Tabs, Tab } from '@mui/material'
import a11yProps from '../../utils/a11pros'
import Typography from '@mui/material/Typography';
import SchoolYearCard from './SchoolYearCard';

const SCHOOL_YEARS = [
  {
    id: 1,
    name: '2021/2022',
    subjects: [
      {
        id: 1,
        name: 'Linear algebra',
      },
      {
        id: 2,
        name: 'Design patterns',
      },
      {
        id: 3,
        name: 'Business English II',
      },
      {
        id: 4,
        name: 'Cloud architecture',
      }
    ]
  },
  {
    id: 2,
    name: '2020/2021',
    subjects: [
      {
        id: 5,
        name: 'Mathematics',
      },
      {
        id: 6,
        name: 'Introduction to programming',
      },
      {
        id: 7,
        name: 'Business English I',
      },
      {
        id: 8,
        name: 'Project management',
      }
    ]
  }
]

const SchoolYears = () => {
  const [value, setValue] = React.useState(1);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const TabPanel = (props) => {
    const { children, value, index, ...other } = props;

    return (
      <div
        role="tabpanel"
        hidden={value !== index}
        id={`simple-tabpanel-${index}`}
        aria-labelledby={`simple-tab-${index}`}
        {...other}
      >
        {value === index && (
          <Box sx={{ py: 1 }}>
            {children}
          </Box>
        )}
      </div>
    );
  }

  return (
    <Fragment>
      <Typography variant='h6'>School year</Typography>
      <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
        <Tabs value={value} onChange={handleChange} aria-label="basic tabs example">
          {
            SCHOOL_YEARS.map(({ id, name }, index) => (
              <Tab label={name} {...a11yProps(id)} key={id}/>
            ))
          }
        </Tabs>
      </Box>
      {
        SCHOOL_YEARS.map(({ id, name, subjects }, index) => (
          <TabPanel value={value} index={index} key={id}>
            {
              subjects.map(({ name, id}) => (
                <SchoolYearCard
                  key={id}
                  name={name}
                  id={id}
                />
              ))
            }
          </TabPanel>
        ))
      }
    </Fragment>
  )
}

export default SchoolYears