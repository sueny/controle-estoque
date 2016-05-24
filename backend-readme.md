#Como rodar o backend no seu computador

###Pré requisitos
* Maven
* Java
* Servidor de aplicação de sua preferência (ex: glassfish)
* Gerenciador de banco de dados (ex: MySql)

###Passos 
* Criar banco de dados (ex: estoque)
* Configurar JDBC Resource (colocar esse nome: jdbc/estoqueDS) e pool do servidor de aplicação. Se estiver usando o glassfish acesse o tutorial.
[Criar Datasource mysql no glassfish](https://luizgustavoss.wordpress.com/2010/03/17/criando-um-datasource-mysql-no-glassfish/ "Title")

* Construir o projeto. Executar o comando: mvn install -DskipTests

  *Após executar o comando o arquivo para deploy estará na pasta controle-estoque-ear\target\controle-estoque-ear-[version].ear*
* Implantar a aplicação. Se estiver usando o glassfish acesse o tutorial: [Deploying an Application Using the Administration Console](https://docs.oracle.com/cd/E19798-01/821-1757/ghgjn/index.html "Title")
