package com.projadata.employeers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeersTest {

  @Test
  @DisplayName("testa se popula e deleta employeers da classe employeers")
  void test() {
    LocalDate mariaDate = LocalDate.of(2000, 10, 18);
    BigDecimal mariaSalario = new BigDecimal("2009.44");
    String mariaFunc = "Operador";
    LocalDate joaoDate = LocalDate.of(1990, 5, 12);
    BigDecimal joaoSalario = new BigDecimal("2284.38");
    String joaoFunc = "Operador";
    LocalDate caioDate = LocalDate.of(1961, 05, 02);
    BigDecimal caioSalario = new BigDecimal("9836.14");
    String caioFunc = "Coordenador";
    LocalDate miguelDate = LocalDate.of(1988, 10, 14);
    BigDecimal miguelSalario = new BigDecimal("19119.88");
    String miguelFunc = "Diretor";
    LocalDate aliceDate = LocalDate.of(1995, 1, 5);
    BigDecimal aliceSalario = new BigDecimal("2234.68");
    String aliceFunc = "Recepcionista";
    LocalDate heitorDate = LocalDate.of(1999, 11, 19);
    BigDecimal heitorSalario = new BigDecimal("1582.72");
    String heitorFunc = "Operador";
    LocalDate arthurDate = LocalDate.of(1993, 3, 31);
    BigDecimal arthurSalario = new BigDecimal("4071.84");
    String arthurFunc = "Contador";
    LocalDate lauraDate = LocalDate.of(1994, 7, 8);
    BigDecimal lauraSalario = new BigDecimal("3017.45");
    String lauraFunc = "Gerente";
    LocalDate heloisaDate = LocalDate.of(2003, 05, 24);
    BigDecimal heloisaSalario = new BigDecimal("1606.85");
    String heloisaFunc = "Eletricista";
    LocalDate helenaDate = LocalDate.of(1996, 9, 2);
    BigDecimal helenaSalario = new BigDecimal("2799.93");
    String helenaFunc = "Gerente";
    
    Employeers employeers = new Employeers();

    employeers.includeEmployeer(new Employeer("Maria", mariaDate, mariaSalario, mariaFunc));
    employeers.includeEmployeer(new Employeer("João", joaoDate, joaoSalario, joaoFunc));
    employeers.includeEmployeer(new Employeer("Caio", caioDate, caioSalario, caioFunc));
    employeers.includeEmployeer(new Employeer("Miguel", miguelDate, miguelSalario, miguelFunc));
    employeers.includeEmployeer(new Employeer("Alice", aliceDate, aliceSalario, aliceFunc));
    employeers.includeEmployeer(new Employeer("Heitor", heitorDate, heitorSalario, heitorFunc));
    employeers.includeEmployeer(new Employeer("Arthur", arthurDate, arthurSalario, arthurFunc));
    employeers.includeEmployeer(new Employeer("Laura", lauraDate, lauraSalario, lauraFunc));
    employeers.includeEmployeer(new Employeer("Heloisa", heloisaDate, heloisaSalario, heloisaFunc));
    employeers.includeEmployeer(new Employeer("Helena", helenaDate, helenaSalario, helenaFunc));
    
    assertEquals(10, employeers.employeers.size());
    assertEquals("Maria", employeers.employeers.get(0).name);
    assertEquals("18/10/2000", employeers.employeers.get(0).getBirthdateDayMonthYear());
    assertEquals("2.009,44", employeers.employeers.get(0).getRemunerationString());
    assertEquals("Operador", employeers.employeers.get(0).function);
    
    assertEquals("Alice", employeers.employeers.get(4).name);
    assertEquals("05/01/1995", employeers.employeers.get(4).getBirthdateDayMonthYear());
    assertEquals("2.234,68", employeers.employeers.get(4).getRemunerationString());
    assertEquals("Recepcionista", employeers.employeers.get(4).function);
    
    assertEquals("Helena", employeers.employeers.get(9).name);
    assertEquals("02/09/1996", employeers.employeers.get(9).getBirthdateDayMonthYear());
    assertEquals("2.799,93", employeers.employeers.get(9).getRemunerationString());
    assertEquals("Gerente", employeers.employeers.get(9).function);
    
    Employeer element4old = employeers.employeers.get(4);
    Employeer element4new = employeers.employeers.get(5);
    employeers.deleteEmployeer(4);
    assertNotEquals(element4old.name, employeers.employeers.get(4).name);
    assertEquals(element4new.name, employeers.employeers.get(4).name);
    
  }
}
