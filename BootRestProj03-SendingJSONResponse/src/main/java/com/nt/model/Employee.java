//Student.java
package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
   private Integer eno;
   private  String ename;
   private  String[]  friends;
   private  Boolean single;
   private  List<String> nickNames;
   private   Set<Long> phones;
   private  Map<String,Object>  idDetails;
   private   Company company;
   
   
}
