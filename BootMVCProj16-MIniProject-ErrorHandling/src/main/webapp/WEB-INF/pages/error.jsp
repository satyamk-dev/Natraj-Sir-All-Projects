<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <h1  style="color:red;text-align:center"> Global Error Page  (error.jsp) </h1>
    
     <table  align="Center"  bgcolor="cyan">
        <tr>
           <td> timestamp  </td>
           <td>${timestamp}</td>
        </tr>
        
        <tr>
           <td> error  </td>
           <td>${error}</td>
        </tr>
        
        <tr>
           <td> status  </td>
           <td>${status}</td>
        </tr>
        
        <tr>
           <td> path  </td>
           <td>${path}</td>
        </tr>
        
        
     
     </table>
