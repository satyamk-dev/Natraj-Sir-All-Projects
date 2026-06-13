<%@ page  isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"   prefix="frm"%>

<h1  style="color:red;text-align:center">  Doctor Registration Page </h1>

<frm:form  modelAttribute="dvo">
  <table   bgcolor="cyan" align="center">
     <tr>
        <td>  Doctor Name::  </td>
        <td> <frm:input path="name"/></td>
     </tr>
     <tr>
        <td>  Doctor Address::  </td>
        <td> <frm:input path="addrs"/></td>
     </tr>
     <tr>
        <td>  Doctor Fee::  </td>
        <td> <frm:input path="fee"/></td>
     </tr>
     <tr>
        <td> <input type="submit"  value="Register"/> </td>
        <td><input type="reset"  value="Cancel"/> </td>
     </tr>
  </table>

</frm:form>

