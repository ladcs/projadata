package com.projadata.employeers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Class Person responsável por criar uma pessoa com nome e a data de nascimento. */
public class Person {

  public String name = null;
  public LocalDate birthdate = null;
  private String birthdateDayMonthYear = null;
  
  /** Contructor method. */
  public Person(String name, LocalDate birthdate) {
    this.name = name;
    this.birthdate = birthdate;
    this.setBirthdateDayMonthYear();
  }
  
  /** method convert date yyyy-mm-dd to dd/mm/yy. */
  private void setBirthdateDayMonthYear() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    this.birthdateDayMonthYear = this.birthdate.format(formatter);
  }
  
  public String getBirthdateDayMonthYear() {
    return this.birthdateDayMonthYear;
  }
}
