<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
</head>
<body>
   <table border=1>
     <thead>
       <tr>
       <th>username</th>
       <th>password</th>
       <th>age</th>
       <th>city</th>
       </tr>
     </thead>
     <tbody>
     <c:forEach items="${users }" var="u">
     <tr>
     <td>${u.username}</td>
     <td>${u.password}</td>
     <td>${u.age}</td>
     <td>${u.city}</td>
		
     
     </tr>
     </c:forEach>
     </tbody>
   </table>
</body>
</html>