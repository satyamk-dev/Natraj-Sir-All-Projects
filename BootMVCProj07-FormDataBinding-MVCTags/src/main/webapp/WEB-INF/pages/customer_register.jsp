<%@ page isELIgnored="false"%>
<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="frm" %>

<h1  style="color:red;text-align:center"> Custom register Form  </h1>

<frm:form     modelAttribute="cust">
<table bgcolor="yellow"  align="Center">
   <tr>
     <td>  customer number </td>
     <td>  <frm:input type="text" path="cno"/> </td>     
   </tr>
    <tr>
     <td>  customer name </td>
     <td>  <frm:input type="text" path="cname"/> </td>     
   </tr>
      <tr>
     <td>  customer address </td>
     <td>  <frm:input type="text" path="caddrs"/> </td>     
   </tr>
    <tr>
     <td>  customer billamt </td>
     <td>  <frm:input type="text" path="billamt"/> </td>     
   </tr>
    <tr>
       <td><input type="submit"  value="register"> </td>
       <td> <input type="reset"  value="cancel">  </td> 
    </tr>

</table>

</frm:form>
