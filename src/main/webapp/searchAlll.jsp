<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
   <%@ include file="index.jsp" %>  
<h1>Employee List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Department</th><th>TimeStamp</th></tr>  
   <c:forEach var="emp" items="${mylist}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   <td>${emp.department}</td>  
   <td>${emp.timestamp}</td>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
    