package com.projadata.employeers;

import java.util.ArrayList;
import java.util.List;

/** Class to add and delete to List .*/
public class Employeers {
  public List<Employeer> employeers = new ArrayList<>();
  
  public void includeEmployeer(Employeer employeer) {
    this.employeers.add(employeer);
  }
  
  public void deleteEmployeer(int employeer) {
    this.employeers.remove(employeer);
  }
}
