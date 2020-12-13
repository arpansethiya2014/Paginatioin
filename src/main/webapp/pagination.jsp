<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <h1>Employee List</h1>  
  <script>            
  function incrementValue()
  {
      var value = parseInt(document.getElementById('number').value, 10);
      value = isNaN(value) ? 0 : value;
      value++;
      document.getElementById('number').value = value;
  }      
            
  function decrementValue()
  {
      var value = parseInt(document.getElementById('number1').value, 10);
      value = isNaN(value) ? 0 : value;
      value--;
      document.getElementById('number1').value = value;
  }
        </script>
  
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
   
   <a href="/springmvc/pagination/first"> <h3> << First </h3> </a>   
   
   <a href="/springmvc/pagination/1" id="number" onclick="incrementValue()"> <h3> < Previous </h3> </a>
 
   <a href="/springmvc/pagination/2" id="number1"  onclick="decrementValue()"> <h3>  Next > </h3> </a>   
 
   <a href="/springmvc/pagination/last"> <h3> Last>>  </h3> </a>  