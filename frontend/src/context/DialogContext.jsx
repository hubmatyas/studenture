import React from "react"

const DialogContext = React.createContext({
  taskId: '',
  show: false,
  setTaskId: () => {},
  setShow: () => {}
})

export default DialogContext