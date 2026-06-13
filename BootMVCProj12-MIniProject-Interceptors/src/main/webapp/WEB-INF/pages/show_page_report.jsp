<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<div >
<h1  style="color:red;text-align:Center"  > Report page  ::  ${pageData.getNumber()+1 } / ${pageData.getTotalPages()}</h1>

<c:choose>
   <c:when test="${!empty pageData.getContent()}">
       <table  align="center"   border="0"  bgcolor="cyan">
        <thead>
         <tr>
            <th>  Doctor ID </th><th>  Doctor Name </th> <th>  Doctor Address </th> <th>  Doctor Fee </th>
            <th>  Discount </th> <th>  Final Fee </th> <th> Operations </th>
         </tr>
         </thead>
         <tbody class="table-light">
          <c:forEach  var="vo"  items="${pageData.getContent()}">
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
       <center>
       <a  href="page_report?page=0"> first</a> &nbsp;
       <c:if  test="${!pageData.isLast() }">
          <a  href="page_report?page=${pageData.getNumber()+1 }"> next</a> &nbsp;
       </c:if>
       
       <c:forEach  var="i"  begin="1"  end="${pageData.getTotalPages()}"  step="1">
              <c:choose>
               <c:when  test="${i-1==pageData.getNumber() }">
                    [ ${i} ]  &nbsp;&nbsp;
                  </c:when>
               <c:when  test="${i-1!=pageData.getNumber() }">
                     [ <a href="page_report?page=${i-1}">${i} </a>]  &nbsp;&nbsp;
                  </c:when>
                  </c:choose>
       </c:forEach>
       
       <c:if  test="${!pageData.isFirst() }">
          <a  href="page_report?page=${pageData.getNumber()-1 }"> previous</a> &nbsp;
       </c:if>
       
         <a  href="page_report?page=${pageData.getTotalPages()-1}"> Last</a> &nbsp;
     
       </center>
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