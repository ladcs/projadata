# # Teste Técnico para PROJEDATA

Esse projeto foi feito com a linguagem Java, com o teste Junit 5.

Para iniciar o projeto:

git clone https://github.com/ladcs/projadata
cd projadata
mvn install

<details><summary><strong> Classe Person </summary></strong> <br />

A classe person tem os parámetros nome (name) e data de nascimento (birthdate), há um método (birthdateToDayMonthYear) responsável por mudar birthdate de LocalDate para string com o formato dd/mm/yyy.

</details>
<details><summary><strong> Teste Classe person </summary></strong> <br/>

Cria uma nova person, coloca o nome Luciano e a data de nascimento 1992-02-19. Então testa se retorna Luciano como String para personTest1.name e LocalDate 1992-02-19 para personTest1.birthdate, testa o método birthdateToDayMonthYear da seguinte maneira: personTest1.birthdateToDayMonthYear retorna 19/02/1992.
</details>

<details><summary><strong> Classe Employeer </summary></strong> <br />

A classe employeer extende a classe person, assim ela herda as duas propriedades da mesma e o método birthdateToDayMonthYear. tem os parámetros nome (name), data de nascimento (birthdate), salário (remuneration) e função (function) como publicas, todos devem ser enviados na criação de um novo objeto, enquanto o parámetro remuneração em string (remunerationString) é privada tendo seu getter (getRemunerationString) e seu setter (setRemunarationStringWithPercentual), onde o primeiro retorna o preço com o valor m.cdu,dd fazendo uso do methodo privado remunerationToString para a formatação. O setter da remuneração recebe um inteiro que é convertido para porcentagem e muda o valor. Há também o método público para retornar o número de salário mínimo (numberOfRemuneration), esse recebe um double, sendo o valor do salário mínimo, e retorna a quantidade em inteiro de salário.

</details>
<details><summary><strong> Teste Classe employeer</strong> </summary> <br/>

Cria um novo empregado, coloca o nome employeer1, a data de nascimento 1992-02-19, salário 3000.00 e função dev. Então testa se retorna employeer1 como String para employeer1.name, LocalDate 1992-02-19 para employeer1.birthdate, BigDecimal 3000.00 para employeer1.remuneration e dev para employeer1.function, testa o método birthdateToDayMonthYear da seguinte maneira: employeer1.birthdateToDayMonthYear retorna 19/02/1992, testa se employeer1.getRemunerationString retorna 3.000,00 com uma redução de 10 porcento no salário, testa se employeer1.getRemunerationString retorna 2.700,00, com o incremento de 10, em 2.700,00, retorna 2.970,00 em employeer1.getRemunerationString.

Criando um employeer2 com o salário de 3000.92, testa se retorna em employeer2.getRemunerationString 3.000,92, incrementando 10 testa se employeer2.getRemunerationString retorna 3.301,01.

Para o método numberOfRemuneration testos recebendo o valor de 1212 para um employeer3, com o salário de 1.212,00 no primeiro momento testo se retorn 1, aumento o salário em 100% testou se retorna 2, dobrou o salário e testou se retorna 4 e por fim teve um aumento de 24% e testou se ainda retorna 4.
</details>

<details><strong><summary> Class Application</strong></summary> <br/>
Cria-se 10 funcionários.

</details>

