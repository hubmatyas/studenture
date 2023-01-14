import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Student from "./pages/Student";
import Professor from "./pages/Professor";
import ProfessorSubject from "./pages/ProfessorSubject";
import StudentSubject from "./pages/StudentSubject";
import Administrator from "./pages/Administrator";
import Login from "./pages/Login";
import Layout from "./components/layout/Layout";
import './index.css'
import { Fragment, React, useState } from "react";
import { CssBaseline } from "@mui/material";
import DialogContext from "./context/DialogContext";
import ProfessorTaskDetailDialog from "./components/professor/ProfessorTaskDetailDialog";


function App() {
  const [taskId, setTaskId] = useState('')
  const [show, setShow] = useState(false)

  const dialogContextValue = { taskId, setTaskId, show, setShow }

  return (
    <Fragment>
      <CssBaseline />
      <Router>
        <Layout>
          <DialogContext.Provider value={dialogContextValue}>
            {/* TODO: Decide how to switch between dialogs */}
            {/* <StudentTaskDetailDialog 
              open={show}
              onClose={() => setShow(false)}
            /> */}
            <ProfessorTaskDetailDialog
              open={show}
              onClose={() => setShow(false)}
            />
            <Routes>
              <Route path="/" element={<Login/>}/>
              <Route path="/student" element={<Student/>}/>
              <Route path="/student/subject/:id" element={<StudentSubject/>}/>            
              <Route path="/professor" element={<Professor/>}/>
              <Route path="/professor/subject/:id" element={<ProfessorSubject/>}/>
              <Route path="/administrator" element={<Administrator/>}/>
            </Routes>
          </DialogContext.Provider>
        </Layout>
      </Router>
    </Fragment>
  );
}

export default App;
