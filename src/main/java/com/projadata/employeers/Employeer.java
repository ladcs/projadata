package com.projadata.employeers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

/** class Employeer responsável por criar um empregado. */
public class Employeer extends Person {

  public String function = null;
  public BigDecimal remuneration = null;
  private String remunerationString = null;

  /** constructor da classe employeer. */
  public Employeer(String name, LocalDate birthdate, BigDecimal remuneration, String function) {
    super(name, birthdate);
    this.function = function;
    this.remuneration = remuneration;
    this.remunerationToString();
  }
  
  public int numberOfRemuneration(double min) {
    BigDecimal multiply = new BigDecimal(1 / min);
    return this.remuneration.multiply(multiply).intValue();
  }
  
  private void remunerationToString() {
    DecimalFormat df = new DecimalFormat("#,###.00");
    this.remunerationString = df.format(this.remuneration);
  }
  
  public String getRemunerationString() {
    return this.remunerationString;
  }
  
  /** set remunerationString. */
  public void setRemunarationStringWithPercentual(int porcent) {
    BigDecimal porcentToBigDecimal = new BigDecimal(1 + porcent * 0.01);
    BigDecimal newRemuneration = this.remuneration.multiply(porcentToBigDecimal);
    this.remuneration = newRemuneration;
    this.remunerationToString();
  }

}
