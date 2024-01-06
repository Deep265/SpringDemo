<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
   <title>JPA Demo </title>
</head>
<body>
   <form action="addAlien">
     <input type="text" name="aid"><br>
     <input type="text" name="aname"><br>
     <input type="submit"><br>
   </form>

   <br>
   <br>
   <h1> Get </h1>
   <form action="getAlien">
      <input type="text" name="aid"><br>
      <input type="submit">
   </form>

   <h1> Update </h1>
   <form action="updateAlien">
        <input type="text" name="aid">
        <input type="text" name="aname">
        <input type="submit">
   </form>

   <h1> Delete </h1>
   <form action="/deleteAlien">
        <input type="text" name="aid">
        <input type="submit">
   </form>
</body>