<%@ page  isELIgnored="false"   %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>


<h1  style="color:red;text-align:center">Result Page</h1>

<b>  <h1 style="text-align:center"> result is:: ${resultMsg}</h1></b>

<br><br>
<b> Simple model attributes :: <c:out value="${resultMsg}"/> , <c:out value="${age}" /></b>
<br><br>
<br>
<b> Arrays and collection model attributes  ::  </b> <br>
  <c:forEach var="color" items="${favColors}">
        ${color},
  </c:forEach>
  <br>
  <c:forEach var="fr" items="${friends}">
        ${fr},
  </c:forEach>
  
  <br>
  <c:forEach var="ph" items="${phones}">
        ${ph},
  </c:forEach>
  <br>
  <c:forEach var="id" items="${idDetails}">
        ${id.key} <===> ${id.value} ,
  </c:forEach>
 <br><br>
  <b> Model  class obj  as model attribute</b>
    <b> Customer data is ::  ${custData}</b> <br>
    <br>  Model  attribute values ::  ${custData.cno}  , ${custData.cname} , ${custData.billAmt} <br> 
 <br><br><br>
 <br>  Collection of Model class objs as model attribute vlaues <br>
 <c:choose>
   <c:when test="${!empty custList}">
     <table  border="1" bgcolor="cyan"  align="Center">
       <tr>
          <th> cno  </th> <th> cname </th> <th> caddrs </th> <th> bill amt </th>
       </tr>
       <c:forEach var="cust"  items="${custList}">
          <tr>
            <td>${cust.cno}</td>
            <td>${cust.cname}</td>
            <td>${cust.caddrs}</td>
            <td>${cust.billAmt}</td>
          </tr>
       </c:forEach>
     </table>
   </c:when>
   <c:otherwise>
       <h1  style="color:red;text-align:center"> No records </h1>
   </c:otherwise>  
 </c:choose>
<a href="./">home</a>

