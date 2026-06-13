<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!--  Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="table-responsive">
<h1  style="color:red;text-align:Center"  class="fw-bold"> Report page</h1>
<c:choose>
   <c:when test="${!empty listVO}">
       <table  align="center"   border="0"  class="table table-hover table-success">
        <thead class="table-dark">
         <tr>
            <th>  Doctor ID </th><th>  Doctor Name </th> <th>  Doctor Address </th> <th>  Doctor Fee </th>
            <th>  Discount </th> <th>  Final Fee </th> <th> Operations </th>
         </tr>
         </thead>
         <tbody class="table-light">
          <c:forEach  var="vo"  items="${listVO}">
             <tr>
                <td> ${vo.did}</td>
                <td> ${vo.name}</td>
                <td> ${vo.addrs}</td>
                <td> ${vo.fee}</td>
                <td> ${vo.discount}</td>
                <td> ${vo.netFee}</td>
                <td> <a href="edit?id=${vo.did}"><img src="images/edit.jpg" width="20px" height="30px"></a>
                         &nbsp;
                         <a href="delete?id=${vo.did}"  onclick="return confirm('Are you sure that u want to Delete?')"><img src="images/delete.jpg" width="20px" height="30px"></a>
             </tr>
          </c:forEach>
          </tbody>
       </table>
   </c:when>
   <c:otherwise>
         <h1  style="color:red;text-align:center">  No Records Found </h1>
   </c:otherwise>
</c:choose>
<br><br>
  <h1  style="color:green;text-align:center"> ${resultMsg} </h1>
<br><br>
<h1  style="text-align:center"><a href="add"> Add Doctor <img src="images/add.jpg"/></a></h1>
<br>
   <h1  style="text-align:center"><a href="./">Home <img src="images/home.jpg"/><a/></h1>
   </div>