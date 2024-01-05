import './App.css';
import React, { useEffect, useState } from 'react'

function App() {
  const[data, setData]=useState([])
  useEffect(()=>{
    fetch("https://jsonplaceholder.typicode.com/todos").then((result)=>{
      result.json().then((resp)=>{
        setData(resp)
      })
    })
  },[])
  console.warn(data)
  return (
    <div className="App">
      <h1>Hello</h1>
      <table border="1">
        <thead>
        <tr>
        <td>USERID</td>
        <td>ID</td>
        <td>TITLE</td>
        <td>COMPLETED</td>
        </tr>
        </thead>
        <tbody>
        {data.map((item) => (
            <tr key={item.id}>
              <td>{item.userId}</td>
              <td>{item.id}</td>
              <td>{item.title}</td>
              <td>{item.completed ? 'True' : 'False'}</td>
            </tr>
          ))}
          </tbody>
      </table>
    </div>
  );
}

export default App;
