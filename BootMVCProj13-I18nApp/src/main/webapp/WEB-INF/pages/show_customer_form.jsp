<%@ page isELIgnored="false"  pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="sp" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>


<h1  style="color:red;text-align:center"><sp:message code="registrationpage.title"/> </h1>

<frm:form  modelAttribute="cust">
   <table align="Center"  bgcolor="cyan">
      <tr>
         <td><sp:message  code="registrationpage.cno"/> </td>
         <td> <frm:input type="text"  path="cno"/> </td>
      </tr>
      <tr>
         <td><sp:message  code="registrationpage.cname"/> </td>
         <td> <frm:input type="text"  path="cname"/> </td>
      </tr>
      <tr>
         <td><sp:message  code="registrationpage.addrs"/> </td>
         <td> <frm:input type="text"  path="caddrs"/> </td>
      </tr>
      <tr>
         <td><sp:message  code="registrationpage.billamount"/> </td>
         <td> <frm:input type="text"  path="billAmt"/> </td>
      </tr>
      
      <tr>
         <td > <input type="submit"  value="<sp:message  code="registrationpage.caption"/>"/> </td>
         <td>  <input type="reset"  value="cancel"> </td>
      </tr>
      
      
  <center>
          <a href="?domain=de_DE">German</a> &nbsp;<a href="?domain=hi_IN">Hindi</a> &nbsp;
          <a href="?domain=fr_FR">French</a> &nbsp;<a href="?domain=zh_CN">chinese</a> &nbsp;
          <a href="?domain=en_US">English</a>
 </center>
      
      
   
   </table>


</frm:form>


