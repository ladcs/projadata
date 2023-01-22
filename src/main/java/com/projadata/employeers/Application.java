package com.projadata.employeers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
  /** Propriedades. */
  private Employeers emp = new Employeers();
  private Map<String, List<String>> groupOut = new LinkedHashMap<String,
        List<String>>();  
  public Map<String, List<String>> month = new HashMap<>();
  private int age = 0;
  public List<String> oldest = new ArrayList<>();

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
    app.printSumRemuneration();
    app.printNumberofremuneration(1212.00);
  }
  
  /** Construtor. */
  public Application() {
    this.insertAll(this.emp);
  }
    
  /** 
   * Adiciona todos funcionários. 
   * Não sei fazer a ligação entre o banco e Java.
   * Caso haja um banco de dados SQL:
   * INSERT INTO employeers.db ('Nome', 'Data Nascimento', 'Salário', 'Função') VALUES
   * ('Maria', '18/10/2000', '2.009,44', 'Operador'),
   * ('João', '12/05/1990', '2.284,38', 'Operador'),
   * ('Caio', '02/05/1961', '9.836,14', 'Coordenador'), 
   * ('Heitor', '19/11/1999', '1.582,72', 'Operador'),
   * ('Arthur', '31/03/1993', '4.071,84', 'Contador'),
   * ('Laura', '08/07/1994', '3.017,45', 'Gerente'),
   * ('Heloisa', '24/05/2003', '1.606,85', 'Eletricista'),
   * ('Helena', '02/09/1996', '2.799,93', 'Gerente');
   * No exemplo usou-se a tabela employeers e o banco db.
   * */
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

  /**
   * Remove o primeiro pelo nome.
   * Remover no SQL:
   * DELETE FROM db.employeers
   * WHERE (
   * SELECT id FROM employeers.banco
   * WHERE name IS 'João'
   * LIMIT 1;
   * );
   * No exemplo usou-se a tabela employeers e o banco db, removendo o João da tabela.  
   * */
  public void deleteFirstByName(String name) {
    int findIndex = IntStream.range(0, this.emp.employeers.size())
        .filter(emp -> Objects.equals(this.emp.employeers.get(emp).name, name))
        .findFirst()
        .orElse(-1);
    if (findIndex > 0) {
      this.emp.deleteEmployeer(findIndex);
    }
  }
  
  /** 
   * Muda salário. 
   * Para pegar todos os funcionários usa-se:
   * SELECT * FROM employeers.db;
   * Com os funcionários provavelmente em uma List, pega o campo salario e faz
   * List<String> salarios = dbInfo.stream()
   *    .map(e -> e.salario)
   *    .forEach(e -> e.replaceAll(".", ""))
   *    .forEach(e -> e.replaceAll(",", "."))
   *    .collect(Collectors.toList());
   * List<String[]> date = dbInfo.stream()
   *    .map(e -> e.data_nascimento)
   *    .forEach(e -> e.split("/"))
   *    .collect(Collectors.toList());
   * Essas 3 Listas vão manter na ordenada pela criação do banco, essa ordem é o mesmo do id.
   * Sei que é o mesmo do id porque usaria id como autoincrement.
   * Com essas 3 lista faria uma outra lista de employeers, usando o processo do método insertAll.
   * Com a lista formada faria usaria o método inc.
   * Com isso faria:
   * UPDATE db.employeers
   * SET salario = employeer[i].remuneration
   * WHERE id = i; 
   * */
  public void inc(int i) {
    this.emp.employeers.stream()
        .forEach(e -> e.setRemunarationStringWithPercentual(i));
  }
  
  /**
   * Group by job.
   * Seguiria o processo descrito no metodo inc para criar a lista de employeer e usaria o método.
   * */
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
  
  /** 
   * Pega as pessoas que nasceram no mês dado e coloca no Map month.
   * Seguiria o processo descrito no metodo inc para criar a lista de employeer e usaria o método. 
   * */
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
  
  /** 
   * pegar o mais velho. 
   * Seguiria o processo descrito no metodo inc para criar a lista de employeer e usaria o método.
   * */
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
  
  /**
   * Método para ordernar os funcionários.
   * Seguiria o processo descrito no metodo inc para criar a lista de employeer e usaria o método.
   *  */
  public List<String> order() {
    List<Employeer> save = this.emp.employeers;
    List<String> order = save.stream()
        .map(e -> e.name)
        .sorted()
        .collect(Collectors.toList());
    return order;
  }
  
  /**
   * soma todos os salários. 
   * Como salarios na tabela seriam do tipo VARCHAR,
   * não poderia usar aggregation para somar.
   * Seguiria o processo descrito no metodo inc para criar a lista de employeer e usaria o método.
   * */
  public BigDecimal allRemuneration() {
    BigDecimal allValue = this.emp.employeers.stream()
        .map(e -> e.remuneration)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    return allValue;
  }
  
  /** 
   * numero de Salários.
   * Novamente não poderia fazer uma divisão para achar então seguiria o mesmo processo anterior. 
   * */
  public List<String> numberRemuneration(double min) {
    List<Employeer> save = this.emp.employeers;
    List<String> names = save.stream()
        .map(e -> e.name)
        .collect(Collectors.toList());
    List<Integer> number = save.stream()
        .map(e -> e.numberOfRemuneration(min))
        .collect(Collectors.toList());
    List<String> result = new ArrayList<>();
    for (int i = 0; i < names.size(); i++) {
      if (number.get(i) > 1) {
        result.add(names.get(i) + " recebe " + number.get(i) + " salários.");  
      } else {
        result.add(names.get(i) + " recebe " + number.get(i) + " salário.");
      }
    }
    return result;
  }
  
  /** Infelizmente não sei testar a parte de imprimir.
   *  Imprime a lista emp. */
  final void printAllEmployeers() {
    System.out.println("------------------------------------------------------------------");
    System.out.printf("%10s %20s %10s %20s \n", "Nome", "Data Nascimento", "Salário", "Função");

    System.out.println("------------------------------------------------------------------");
    this.emp.employeers.stream().forEach(e -> System.out.format("%10s %18s %12s %20s \n", 
              e.name, e.getBirthdateDayMonthYear(), e.getRemunerationString(), e.function));
    System.out.println("------------------------------------------------------------------");
  }
  
  /** Imprimir os grupos e o nome dos funcionários, acredito que era isso. */
  final void printAllGroup() {
    System.out.println("\n\n");
    System.out.println(this.groupOut);  
  }  
  
  /**Imprimir o(s) nome(s) e a idade do(s) mais velho(s).*/
  final void printOldest() {
    System.out.println("\n\n");
    for (String oldest : this.oldest) {
      System.out.println(oldest);
    }
  }
  
  /** Imprimir as pessoas ordenadas. */
  final void printOrderPerson() {
    System.out.println("\n\n");
    System.out.println(this.order());
  }
  
  /** Imprimir o salário total. */
  final void printSumRemuneration() {
    DecimalFormat df = new DecimalFormat("#,###.00");
    System.out.println("\n\n");
    System.out.println(df.format(this.allRemuneration()));
  }

  /**Imprimir os nomes das pessoas do mes. */
  final void printAllInMonth() {
    System.out.println("\n\n");
    System.out.println(this.month);
  }
  
  final void printNumberofremuneration(double min) {
    System.out.println("\n\n");
    List<String> toPrint = this.numberRemuneration(min);
    toPrint.stream().forEach(e -> System.out.println(e));
  }
  
  /** getters. */
  public Employeers getEmp() {
    return this.emp;
  }

  public Map<String, List<String>> getGroupOut() {
    return groupOut;
  }
}
