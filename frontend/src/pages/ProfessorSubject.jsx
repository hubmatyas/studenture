import React from 'react'
import { Grid, Button } from '@mui/material';
import SubjectInfo from '../components/subject/SubjectInfo';
import TaskCardList from '../components/general/TaskCardList';

const SUBJECT = {
  name: 'Linear algebra',
  lecturer: 'John Doe',
  description: 'This subject is focused basics of linear algebra. You will learn about matrices, vectors, etc.',
  deadlines: [
    {
      id: 1,
      name: 'Matrix multiplication excercise',
      deadline: '4/12/2022',
      points: 10,
    },
    {
      id: 2,
      name: 'Final test',
      deadline: '4/12/2022',
      points: 20,
    }
  ],
  finishedTasks: [
    {
      id: 1,
      name: 'Vectors I',
      deadline: '4/12/2022',
      points: 10
    },
    {
      id: 2,
      name: 'Vectors II',
      deadline: '4/12/2022',
      points: 20
    },
    {
      id: 2,
      name: 'Vectors III',
      deadline: '4/12/2022',
      points: 20
    },
  ]
}

const StudentSubject = () => {
  // TODO: Use this for data fetching when backend is ready
	// const { id } = useParams();

  const goBack = () => {
    window.history.back();
  }

  return (
    <Grid container spacing={2}>
      <Grid item xs={12}>
        <Button variant='contained' color='primary' onClick={goBack}>
          Back
        </Button>
      </Grid>
      <Grid item xs={12}>
        <SubjectInfo
          name={SUBJECT.name}
          lecturer={SUBJECT.lecturer}
          description={SUBJECT.description}
        />
      </Grid>
      <Grid item xs={12}>
        <TaskCardList tasks={SUBJECT.deadlines} heading='Upcoming deadlines' />
      </Grid>
      <Grid item xs={12}>
        <TaskCardList tasks={SUBJECT.finishedTasks} heading='Finished tasks' />
      </Grid>
    </Grid>
  )
}

export default StudentSubject