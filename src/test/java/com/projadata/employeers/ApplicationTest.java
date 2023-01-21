package com.projadata.employeers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {

  @Test
  @DisplayName("Testa se cria a lista corretamente")
  void insertAll() {
    Application app = new Application();
    LocalDate mariaDate = LocalDate.of(2000, 10, 18);
    BigDecimal mariaSalario = new BigDecimal("2009.44");
    String mariaFunc = "Operador";
    Employeer maria = new Employeer("Maria", mariaDate, mariaSalario, mariaFunc);
    assertEquals(10, app.getEmp().employeers.size());
    assertEquals(maria.name, app.getEmp().employeers.get(0).name);
    assertEquals(maria.getBirthdateDayMonthYear(),
        app.getEmp().employeers.get(0).getBirthdateDayMonthYear());
    assertEquals(maria.getRemunerationString(),
        app.getEmp().employeers.get(0).getRemunerationString());
    assertEquals(maria.function, app.getEmp().employeers.get(0).function);
    LocalDate aliceDate = LocalDate.of(1995, 1, 5);
    BigDecimal aliceSalario = new BigDecimal("2234.68");
    String aliceFunc = "Recepcionista";
    Employeer alice = new Employeer("Alice", aliceDate, aliceSalario, aliceFunc);
    assertEquals(alice.name, app.getEmp().employeers.get(4).name);
    assertEquals(alice.getBirthdateDayMonthYear(),
        app.getEmp().employeers.get(4).getBirthdateDayMonthYear());
    assertEquals(alice.getRemunerationString(),
        app.getEmp().employeers.get(4).getRemunerationString());
    assertEquals(alice.function, app.getEmp().employeers.get(4).function);
  }
  
  @Test
  @DisplayName("Testa se realmente deletou")
  void deleteByName() {
    Application app = new Application();
    
    LocalDate joaoDate = LocalDate.of(1990, 5, 12);
    BigDecimal joaoSalario = new BigDecimal("2284.38");
    String joaoFunc = "Operador";
    
    Employeer joao = new Employeer("João", joaoDate, joaoSalario, joaoFunc);
    
    assertEquals(10, app.getEmp().employeers.size());
    assertEquals(joao.name, app.getEmp().employeers.get(1).name);
    assertEquals(joao.getBirthdateDayMonthYear(),
         app.getEmp().employeers.get(1).getBirthdateDayMonthYear());
    assertEquals(joao.getRemunerationString(),
         app.getEmp().employeers.get(1).getRemunerationString());
    assertEquals(joao.function, app.getEmp().employeers.get(1).function);
    
    app.deleteFirstByName("João");
    
    assertNotEquals(joao.name, app.getEmp().employeers.get(1).name);
    assertNotEquals(joao.getBirthdateDayMonthYear(),
         app.getEmp().employeers.get(1).getBirthdateDayMonthYear());
    assertNotEquals(joao.getRemunerationString(),
         app.getEmp().employeers.get(1).getRemunerationString());
    assertNotEquals(joao.function, app.getEmp().employeers.get(1).function);
    
    LocalDate caioDate = LocalDate.of(1961, 05, 02);
    BigDecimal caioSalario = new BigDecimal("9836.14");
    String caioFunc = "Coordenador";
    
    Employeer caio = new Employeer("Caio", caioDate, caioSalario, caioFunc);
    
    assertEquals(caio.name, app.getEmp().employeers.get(1).name);
    assertEquals(caio.getBirthdateDayMonthYear(),
         app.getEmp().employeers.get(1).getBirthdateDayMonthYear());
    assertEquals(caio.getRemunerationString(),
         app.getEmp().employeers.get(1).getRemunerationString());
    assertEquals(caio.function, app.getEmp().employeers.get(1).function);
  }
  
  @Test
  @DisplayName("Testa incremento salárial")
  void inc() {
    Application app = new Application();
    app.inc(10);
    LocalDate mariaDate = LocalDate.of(2000, 10, 18);
    BigDecimal mariaSalario = new BigDecimal("2009.44");
    String mariaFunc = "Operador";
    Employeer maria = new Employeer("Maria", mariaDate, mariaSalario, mariaFunc);
    
    assertNotEquals(maria.getRemunerationString(),
        app.getEmp().employeers.get(0).getRemunerationString());
    
    maria.setRemunarationStringWithPercentual(10);
    assertEquals(maria.getRemunerationString(),
            app.getEmp().employeers.get(0).getRemunerationString());
    
    LocalDate aliceDate = LocalDate.of(1995, 1, 5);
    BigDecimal aliceSalario = new BigDecimal("2234.68");
    String aliceFunc = "Recepcionista";
    Employeer alice = new Employeer("Alice", aliceDate, aliceSalario, aliceFunc);
    
    assertNotEquals(alice.getRemunerationString(),
            app.getEmp().employeers.get(4).getRemunerationString());
        
    alice.setRemunarationStringWithPercentual(10);
    assertEquals(alice.getRemunerationString(),
            app.getEmp().employeers.get(4).getRemunerationString());
  }
  
  @Test
  @DisplayName("Testa se os grupos foram feitos corretamente")
  void group() {
    Application app = new Application();
    app.group();
    
    List<String> operador = new ArrayList<>();
    operador.add("Maria");
    operador.add("João");
    operador.add("Heitor");
    
    List<String> coordenador = new ArrayList<>();
    coordenador.add("Caio");
    
    List<String> diretor = new ArrayList<>();
    diretor.add("Miguel");
    
    List<String> recepcionista = new ArrayList<>();
    recepcionista.add("Alice");
    
    List<String> contador = new ArrayList<>();
    contador.add("Arthur");
    
    List<String> gerente = new ArrayList<>();
    gerente.add("Laura");
    gerente.add("Helena");
    
    List<String> eletricista = new ArrayList<>();
    eletricista.add("Heloisa");
    
    Map<String, List<String>> groups = new LinkedHashMap<String,
            List<String>>();
    groups.put("Operador", operador);
    groups.put("Coordenador", coordenador);
    groups.put("Diretor", diretor);
    groups.put("Recepcionista", recepcionista);
    groups.put("Contador", contador);
    groups.put("Gerente", gerente);
    groups.put("Eletricista", eletricista);
    
    Map<String, List<String>> groupsToTest = app.getGroupOut();
    
    assertEquals(groups, groupsToTest);
  }
}