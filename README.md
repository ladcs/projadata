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

<details><summary><strong> Classe Employeers </summary></strong> <br />
Há uma propriedade pública que é um list da classe Employeer.

Há dois método público: includeEmployeer, para adicionar funcionário e deleteEmployeer para deletar funcionário.
</details>
<details><summary><strong> Teste Classe employeers</strong> </summary> <br/>
Criou-se 10 funcionários, com nomes, salários, dia de nascimento e funções diferentes. Colocou na propriedade da classe Employeers, employeers, testou se há 10 empregados na propriedade, se Maria é a primeira funcionária, se a Alice é a quinta funcionária e se a Helena é a última funcionária.

Pegou a quinta funcionária e armazenou em uma variavel do tipo Employeer e armazenou em outra variavel o sexto funcionário.

Deletou o quinto funcionário e testou se o nome do quinto funcionário atual é diferente do quinto funcionário anterior e testou se o nome do sexto funcionário anteriormente é o nome do quinto funcionário atual.
</details>
<details><strong><summary> Class Application</strong></summary> <br/>
Para os métodos, há no javadoc comment como eu faria caso houvesse um banco de dados, sem ORM.

Cria-se 10 funcionários, metodo insertAll(privada), usando a class Employeers para armazenar na propriedade emp (privada).

Imprime todos os funcionários registrados na propriedade emp, metodo printAllEmployeers(privada).

Há um get para emp, getEmp(público).

Acha um funcionário pelo nome e então deleta, deteleFirstByName(público).

Mudança percentual no salário, inc(público), recebe um int, esse pode aumentar ou diminuir o salário.

Há uma propriedade groupOut(privada) com um getter, ela é um map com chave string e valor list de strings. Há também um método para printar o grupo, printAllGroup(final) há também um método group (público) que pega a List emp e coloca chaves com o nome da função no groupOut e vai colocando o nome do funcionário na list de valor para cada chave.

Há um método que pega pessoas nascida no mês, int, enviado, personBornMonth(público), e armazena a informação na propriedade month(público), map=> chave é o nome do més e valor é a lista de pessoas nascidas nesse més. Então para imprimir o map tem um método printAllInMonth(final).

Com o método findOlder(público) acha a idade, armazenando na propriedade age(private) e acha o nome da pessoa mais velha, armazenando essa informação na propriedade oldest(public) que é lista caso acha 2 pessoas ou mais do mesmo ano.

Order(pública) ordena a lista da funcionários em ordem alfabética e retorna a lista ordenada. Para imprimir printOrderPerson(final).

O método allRemuneration(público) soma o salário de todos os funcionários e retorna o valor e é chamado pela função printSumRemuneration(final).

Por fim o numberRemuneration(público), que recebe um valor double, retorna uma lista de strings dizendo o "$nome recebe $quantidade salário." ou "$nome recebe $quantidade salários.", esse método é chamado pelo printNumberofremuneration(final).
</details>

<details><strong><summary>Test Class Application</strong></summary> <br/>
Para cada teste criou uma nova classe Application, o teste descrito seguiu a ordem dos métodos da seção Class Application.

Para testar se cria a lista, usa-se o mesmo metodo de teste da classe Employeers, apenas para criação, com a diferença que usa a classe Employeer para conferir se esta tudo de acordo.

Para o segundo teste usou o mesmo procefimento para testar a classe Employeers com a diferença que usou a class Employeer.

Testou-se para o funcionário 1, Maria e o funcionário 5, Alice. Aumento o salário de todos em 10% testou se o salário inicial das duas não é igual ao atual, então incrementou com a o método setRemunarationStringWithPercentual da class Employeer e comparou se é igual.

Testou se o tamanho do map de groupOut possui 7 e testou cada chave para saber se a List é a esperada.

Testou o més de outubro, se o map tem tamanha 1 e se a saída é esta certa para o mesmo més.

Testou se o Caio é o mais velho e se tem 61 anos, testou também se foi encontrado mais alguém.

Testou se a primeira pessoa não era a Maria, testou se a primeira pessoa é a Alice e se a última era Miguel.

Testou se todos os funcionários juntos possuem o salário de 48563.31.

Por fim testou se há 10 strings na lista, se com o salário minimo de 1000 se o retorno de cada um está certa.
</details>
