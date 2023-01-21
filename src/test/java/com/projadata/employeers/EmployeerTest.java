package com.projadata.employeers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class TestClassEmployeer {

  @Test
  void test() {
    String employeerName1 = "employeer1";
    LocalDate birthdate1 = LocalDate.of(1992, 2, 19);
    BigDecimal remuneration1 = new BigDecimal("3000.00");
    String function1 = "dev";
    
    Employeer employeer1 = new Employeer(employeerName1, birthdate1, remuneration1, function1);
    
    assertEquals("employeer1", employeer1.name);
    assertEquals(birthdate1, employeer1.birthdate);
    assertEquals(remuneration1, employeer1.remuneration);
    assertEquals("dev", employeer1.function);
    assertEquals("19/02/1992", employeer1.getBirthdateDayMonthYear());
    assertEquals("3.000,00", employeer1.getRemunerationString());
    employeer1.setRemunarationStringWithPercentual(-10);
    assertEquals("2.700,00", employeer1.getRemunerationString());
    employeer1.setRemunarationStringWithPercentual(10);
    assertEquals("2.970,00", employeer1.getRemunerationString());
    
    String employeerName2 = "employer2";
    LocalDate birthdate2 = LocalDate.of(1985, 3, 22);
    BigDecimal remuneration4 = new BigDecimal("3000.92");
    String function2 = "web";
    
    Employeer employeer2 = new Employeer(employeerName2, birthdate2, remuneration4, function2);
    assertEquals("3.000,92", employeer2.getRemunerationString());
    employeer2.setRemunarationStringWithPercentual(10);
    assertEquals("3.301,01", employeer2.getRemunerationString());
  }
}