import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import { Button } from './components/ui/button'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <h1>This is my Application</h1>
     <Button variant={"outline"}>Click Me</Button>
    </>
  )
}

export default App
