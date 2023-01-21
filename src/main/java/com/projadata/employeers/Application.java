package com.projadata.employeers;

import java.math.BigDecimal;
import java.time.LocalDate;

/** main class. */
public class Application {

  /** method main. */
  public static void main() {
    Application app = new Application();
    app.insertAll();
  }
  
  private void insertAll() {
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

    Employeer maria = new Employeer("Maria", mariaDate, mariaSalario, mariaFunc);
    Employeer joao = new Employeer("João", joaoDate, joaoSalario, joaoFunc);
    Employeer caio = new Employeer("Caio", caioDate, caioSalario, caioFunc);
    Employeer miguel = new Employeer("Miguel", miguelDate, miguelSalario, miguelFunc);
    Employeer alice = new Employeer("Alice", aliceDate, aliceSalario, aliceFunc);
    Employeer heitor = new Employeer("Heitor", heitorDate, heitorSalario, heitorFunc);
    Employeer arthur = new Employeer("Arthur", arthurDate, arthurSalario, arthurFunc);
    Employeer laura = new Employeer("Laura", lauraDate, lauraSalario, lauraFunc);
    Employeer heloisa = new Employeer("Heloisa", heloisaDate, heloisaSalario, heloisaFunc);
    Employeer helena = new Employeer("Helena", helenaDate, helenaSalario, helenaFunc);
  }
}
