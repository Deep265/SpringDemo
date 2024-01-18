import './App.css';
import { BrowserRouter, Route, Router, Routes } from 'react-router-dom';
import React, { useEffect, useState } from 'react'
import ViewUsers from './components/ViewUsers';
import AddUser from './components/AddUser';
import UpdateUser from './components/UpdateUser';
import DeleteUser from './components/DeleteUser';
import Header from './components/Header';

function App() {
  
  
  return (
      <>
      <h1>CRUD APP</h1>
      <Header/>
      <BrowserRouter>
      <Routes>
        <Route path={"/"} element={<ViewUsers/>} exact={true}/>
        <Route path={"/viewusers"} element={<ViewUsers/>} exact={true}/>
        <Route path={"/adduser"} element={<AddUser/>} exact={true}/>
        <Route path={"/updateuser/:eid"} element={<UpdateUser/>} exact={true}/>
        <Route path={"/deleteuser/:eid"} element={<DeleteUser/>} exact={true}/>
      </Routes>
      </BrowserRouter>
      </>
  );
}

export default App;
