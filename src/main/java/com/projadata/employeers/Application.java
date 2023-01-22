package com.projadata.employeers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** main class. */
public class Application {
  /** method main. */
  public static void main(String[] args) {
    Application app = new Application();
    app.deleteFirstByName("João");
    app.printAllEmployeers();
    app.inc(10);
    app.group();
    app.printAllGroup();
    app.personBornMonth(10);
    app.personBornMonth(12);
    app.printAllInMonth();
    app.findOlder();
    app.printOldest();
    app.printOrderPerson();
  }
  
  private int age = 0;
    
  private Employeers emp = new Employeers();
  private Map<String, List<String>> groupOut = new LinkedHashMap<String,
      List<String>>();  
  public Map<String, List<String>> month = new HashMap<>();
  public List<String> oldest = new ArrayList<>();
  
  public Application() {
    this.insertAll(this.emp);
  }
  
  /** método para ordernar os funcionários. */
  public List<String> order() {
    List<Employeer> save = this.emp.employeers;
    List<String> order = save.stream()
        .map(e -> e.name)
        .sorted()
        .collect(Collectors.toList());
    return order;
  }
  
  public Employeers getEmp() {
    return this.emp;
  }
  
  /** pegar o mais velho. */
  public void findOlder() {
    LocalDate toDay = LocalDate.now();
    List<Employeer> save = this.emp.employeers;
    LocalDate oldestYear = save.stream()
        .map(e -> e.birthdate)
        .sorted()
        .collect(Collectors.toList()).get(0);
    
    if (oldestYear.getMonthValue() >= toDay.getMonthValue()) {
      if (oldestYear.getDayOfMonth() >= toDay.getDayOfMonth()) {
        this.age = toDay.getYear() - oldestYear.getYear();
      } else {
        this.age = toDay.getYear() - oldestYear.getYear() - 1;
      }
    }
    save.stream()
        .filter(e -> e.birthdate.equals(oldestYear))
        .forEach(e -> this.oldest.add(e.name + " possui " + this.age + " anos."));
  }
  
  /** Pega as pessoas que nasceram no mês dado e coloca no Map month. */
  public void personBornMonth(int i) {
    String[] nameMonth = {
      "janeiro",
      "fevereiro",
      "março",
      "abril",
      "maio",
      "junho",
      "julho",
      "agosto",
      "setembro",
      "outubro",
      "novembro",
      "dezembro"  
    };
    List<String> employeer = this.emp.employeers.stream()
          .filter(e -> i == e.birthdate.getMonthValue())
          .map(e -> e.name)
          .collect(Collectors.toList());
    this.month.put(nameMonth[i - 1], employeer);
  }
  
  /**Imprimir o(s) nome(s) e a idade do(s) mais velho(s).*/
  final void printOldest() {
    System.out.println("\n\n");
    for (String oldest : this.oldest) {
      System.out.println(oldest);
    }
  }
  
  final void printOrderPerson() {
    System.out.println("\n\n");
    System.out.println(this.order());
  }
  
  /**Imprimir os nomes das pessoas do mes. */
  final void printAllInMonth() {
    System.out.println("\n\n");
    System.out.println(this.month);
  }

  /** Imprimir os grupos e o nome dos funcionários, acredito que era isso. */
  final void printAllGroup() {
    System.out.println("\n\n");
    System.out.println(this.groupOut);  
  }
    
  /** delete one employeer by name. */
  public void deleteFirstByName(String name) {
    int findIndex = IntStream.range(0, this.emp.employeers.size())
        .filter(emp -> Objects.equals(this.emp.employeers.get(emp).name, name))
        .findFirst()
        .orElse(-1);
    if (findIndex > 0) {
      this.emp.deleteEmployeer(findIndex);
    }
  }
  
  /** Infelizmente não sei testar a parte de imprimir e não sei fazer uma tabela certinha. */
  private void printAllEmployeers() {
    System.out.println("Nome | Data Nascimento | Salário | Função");
    this.emp.employeers.stream().forEach(e -> System.out.println(e.name + " | "
        + e.getBirthdateDayMonthYear() + " | " + e.getRemunerationString() + " | " + e.function));
  }
  
  /** Muda salário. */
  public void inc(int i) {
    this.emp.employeers.stream()
        .forEach(e -> e.setRemunarationStringWithPercentual(i));
  }
  
  /** Group by job. */
  public void group() {
    for (int i = 0; i < this.emp.employeers.size(); i += 1) {
      String key = this.emp.employeers.get(i).function;
      String element = this.emp.employeers.get(i).name;
      if (!this.getGroupOut().containsKey(key)) {
        this.getGroupOut().put(key, new ArrayList<String>());
      }
      this.getGroupOut().get(key).add(element);
    }
  }
  
  /** Adiciona todos funcionários. */
  private void insertAll(Employeers e) {
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

    e.includeEmployeer(new Employeer("Maria", mariaDate, mariaSalario, mariaFunc));
    e.includeEmployeer(new Employeer("João", joaoDate, joaoSalario, joaoFunc));
    e.includeEmployeer(new Employeer("Caio", caioDate, caioSalario, caioFunc));
    e.includeEmployeer(new Employeer("Miguel", miguelDate, miguelSalario, miguelFunc));
    e.includeEmployeer(new Employeer("Alice", aliceDate, aliceSalario, aliceFunc));
    e.includeEmployeer(new Employeer("Heitor", heitorDate, heitorSalario, heitorFunc));
    e.includeEmployeer(new Employeer("Arthur", arthurDate, arthurSalario, arthurFunc));
    e.includeEmployeer(new Employeer("Laura", lauraDate, lauraSalario, lauraFunc));
    e.includeEmployeer(new Employeer("Heloisa", heloisaDate, heloisaSalario, heloisaFunc));
    e.includeEmployeer(new Employeer("Helena", helenaDate, helenaSalario, helenaFunc));
  }

  public Map<String, List<String>> getGroupOut() {
    return groupOut;
  }
}
