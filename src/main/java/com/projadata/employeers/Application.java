package com.projadata.employeers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.IntStream;

/** main class. */
public class Application {
  
  private Employeers emp = new Employeers();
  
  public Application() {
    this.insertAll(this.emp);
  }
  
  public Employeers getEmp() {
    return this.emp;
  }

  /** method main. */
  public static void main(String[] args) {
    Application app = new Application();
    app.deleteFirstByName("João");
    app.printAllEmployeers();
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
  
  /** Infelizmente não sei testar a parte de print e não sei fazer uma tabela certinha. */
  private void printAllEmployeers() {
    System.out.println("Nome | Data Nascimento | Salário | Função");
    this.emp.employeers.stream().forEach(e -> System.out.println(e.name + " | "
        + e.getBirthdateDayMonthYear() + " | " + e.getRemunerationString() + " | " + e.function));
  }
  
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
}
