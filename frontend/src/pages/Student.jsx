import React, { Fragment } from 'react'
import TaskCardList from '../components/general/TaskCardList';
import SchoolYears from '../components/student/SchoolYears';

const DEADLINES = [
  {
    id: 1,
    name: 'Matrix multiplication excercise',
    deadline: '4/12/2022',
    subject: 'Mathematics',
    points: 10,
  },
  {
    id: 2,
    name: 'Factory design pattern',
    deadline: '4/12/2022',
    subject: 'Introduction to programming',
    points: 20,
  },
  {
    id: 3,
    name: 'Horizontal and vertical scaling',
    deadline: '4/12/2022',
    subject: 'Introduction to programming',
    points: 10,
  },
  {
    id: 4,
    name: 'OOP Seminar work',
    deadline: '4/12/2022',
    subject: 'Introduction to programming',
    points: 30,
  },
]

const Student = () => {
  return (
    <Fragment>
      <TaskCardList tasks={DEADLINES} heading='Upcoming deadlines'/>
      <SchoolYears />
    </Fragment>
  )
}

export default Student