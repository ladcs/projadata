package com.projadata.employeers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    assertEquals(groups.size(), groupsToTest.size());
    assertEquals(groups.get("Operador"), groupsToTest.get("Operador"));
    assertEquals(groups.get("Coodenador"), groupsToTest.get("Coodenador"));
    assertEquals(groups.get("Diretor"), groupsToTest.get("Diretor"));
    assertEquals(groups.get("Recepcionista"), groupsToTest.get("Recepcionista"));
    assertEquals(groups.get("Contador"), groupsToTest.get("Contador"));
    assertEquals(groups.get("Gerente"), groupsToTest.get("Gerente"));
    assertEquals(groups.get("Eletricista"), groupsToTest.get("Eletricista"));
  }
  
  @Test
  @DisplayName("Teste de pegar pessoas do mês")
  void month() {
    Application app = new Application();
    
    app.personBornMonth(10);
    Map<String, List<String>> expcet = new HashMap<>();
    List<String> persons = new ArrayList<>();
    persons.add("Maria");
    persons.add("Miguel");
    
    expcet.put("outubro", persons);
    
    Map<String, List<String>> test = app.month;
    
    assertEquals(1, test.size());
    assertEquals(expcet.get("outubro"), test.get("outubro"));
  }
  
  @Test
  @DisplayName("Teste de pegar a pessoa mais velha")
  void oldest() {
    String expect = "Caio possui 61 anos.";
    Application app = new Application();
    app.findOlder();
    List<String> toTest = app.oldest;
    
    assertEquals(1, toTest.size());
    assertEquals(expect, toTest.get(0));
  }
  
  @Test
  @DisplayName("Teste de ordenação")
  void order() {
    List<String> expect = new ArrayList<>();
    expect.add("Alice");
    expect.add("Miguel");
    
    Application app = new Application();
    
    List<String> toTest = app.order();
    
    assertNotEquals("Maria", toTest.get(0));
    assertEquals(expect.get(0), toTest.get(0));
    assertEquals(expect.get(1), toTest.get(9));
  }
  
  @Test
  @DisplayName("Teste salário total")
  void total() {
    BigDecimal expect = new BigDecimal("48563.31");
    Application app = new Application();
    
    assertEquals(expect, app.allRemuneration());
  }
  
  @Test
  @DisplayName("Teste número de salários")
  void number() {
    Application app = new Application();
    String[] expect = {
        "Maria recebe 2 salários.",
        "João recebe 2 salários.",
        "Caio recebe 9 salários.",
        "Miguel recebe 19 salários.",
        "Alice recebe 2 salários.",
        "Heitor recebe 1 salário.",
        "Arthur recebe 4 salários.",
        "Laura recebe 3 salários.",
        "Heloisa recebe 1 salário.",
        "Helena recebe 2 salários."};
    List<String> toTest = app.numberRemuneration(1000);
    
    assertEquals(10, toTest.size());
    assertEquals(expect[0], toTest.get(0));
    assertEquals(expect[1], toTest.get(1));
    assertEquals(expect[2], toTest.get(2));
    assertEquals(expect[3], toTest.get(3));
    assertEquals(expect[4], toTest.get(4));
    assertEquals(expect[5], toTest.get(5));
    assertEquals(expect[6], toTest.get(6));
    assertEquals(expect[7], toTest.get(7));
    assertEquals(expect[8], toTest.get(8));
    assertEquals(expect[9], toTest.get(9));
  }
}