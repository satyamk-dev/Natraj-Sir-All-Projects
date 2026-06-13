<%@ page isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="sp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<h1  style="color:red;text-align:center"><sp:message  code="homepage.title"/> </h1>

<h1  style="color:red;text-align:center"><a href="register"><sp:message  code="homepage.link1"/> </a></h1>

 <h4 style="color:green"> Current  active Locale is ::  ${pageContext.response.locale}</h4>
 
  <fmt:setLocale  value="${pageContext.response.locale}"/>
  
  <fmt:formatNumber var="fdistance" value="${distance}"  type="number"/>
  <b>Formatted Number :: ${fdistance}</b>
  <br>
<fmt:formatNumber var="fprice" value="${price}"  type="currency"/>
  <b>Formatted Price :: ${fprice}</b>
  <br>
<fmt:formatNumber var="favg" value="${avg}"  type="percent"/>
  <b>Formatted Avg :: ${favg}</b>
  <br>
<fmt:formatDate var="fdate" value="${sysDate}"  type="date"  dateStyle="SHORT"/>
  <b>Formatted Date :: ${fdate}</b>
<br>
<fmt:formatDate var="ftime" value="${sysDate}"  type="time"  dateStyle="MEDIUM"/>
  <b>Formatted Time :: ${ftime}</b>
  <br>
  
<fmt:formatDate var="fdt" value="${sysDate}"  type="both"  dateStyle="FULL"/>
  <b>Formatted Date-Time :: ${fdt}</b>
  <br>
  
  
  

<center>
<a href="?domain=de_DE">German</a> &nbsp;<a href="?domain=hi_IN">Hindi</a> &nbsp;
<a href="?domain=fr_FR">French</a> &nbsp;<a href="?domain=zh_CN">chinese</a> &nbsp;
<a href="?domain=en_US">English</a>
 </center>



