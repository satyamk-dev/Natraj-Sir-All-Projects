<%@ page  isELIgnored="false"%>


<h1  style="color:red;text-align:center">Spring boot MVC -- Season App</h1>

<b>  <h1 style="text-align:center"> <a  href="season">Show Current Season Name</a></h1></b>

<br><br>

<a  href="report">  showReport (GET)</a>
<br>
<a  href="test/report">  show test Report (GET)</a>

<form action="report" method="POST">
   <input type="submit"  value="send(POST)">
</form>