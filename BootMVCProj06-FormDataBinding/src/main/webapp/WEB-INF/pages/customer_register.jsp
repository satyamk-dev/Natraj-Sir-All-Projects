<%@ page isELIgnored="false"%>


<h1  style="color:red;text-align:center"> Custom register Form  </h1>

<form action="register"  method="POST">
<table bgcolor="yellow"  align="Center">
   <tr>
     <td>  customer number </td>
     <td>  <input type="text" name="cno"> </td>     
   </tr>
    <tr>
     <td>  customer name </td>
     <td>  <input type="text" name="cname"> </td>     
   </tr>
      <tr>
     <td>  customer address </td>
     <td>  <input type="text" name="caddrs"> </td>     
   </tr>
    <tr>
     <td>  customer billamt </td>
     <td>  <input type="text" name="billamt"> </td>     
   </tr>
    <tr>
       <td><input type="submit"  value="register"> </td>
       <td> <input type="reset"  value="cancel">  </td> 
    </tr>

</table>

</form>
