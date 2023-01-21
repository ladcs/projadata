package com.projadata.employeers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeerTest {

  @Test
  @DisplayName("testa se cria corretamenta empregados e se há um incremento no salario.")
  void test() {
    String employeerName1 = "employeer1";
    LocalDate birthdate1 = LocalDate.of(1992, 2, 19);
    BigDecimal remuneration1 = new BigDecimal("3000.00");
    String function1 = "dev";

    Employeer employeer1 = new Employeer(employeerName1, birthdate1, remuneration1, function1);
    
    assertEquals("employeer1", employeer1.name);
    assertEquals(remuneration1, employeer1.remuneration);
    assertEquals(birthdate1, employeer1.birthdate);
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
    
    BigDecimal remuneration3 = new BigDecimal("1212.00");
    Employeer employeer3 = new Employeer("employeer3", birthdate2, remuneration3, "dev");
    
    assertEquals(1, employeer3.numberOfRemuneration(1212));
    employeer3.setRemunarationStringWithPercentual(100);
    assertEquals(2, employeer3.numberOfRemuneration(1212));
    employeer3.setRemunarationStringWithPercentual(100);
    assertEquals(4, employeer3.numberOfRemuneration(1212));
    assertNotEquals(3, employeer3.numberOfRemuneration(1212));
    employeer3.setRemunarationStringWithPercentual(24);
    assertEquals(4, employeer3.numberOfRemuneration(1212));
  }
}