#Documentação REST API Backend

O backend foi desenvolvido através das seguintes IDE / Ferramentas: 
•	IDE: NetBeans 8.0; 
•	Database MySQL 5.1; 
•	ORM: EcliseLink
•	Application Server: GlassFish 4.0.

A equipe de software optou pela utilização da ferramenta MAVEN com a finalidade de 
gerenciar as dependências do projeto. 
A estrutura da API do projeto foi desenvolvida em seguindo o padrão MVC 
(Model View Controller), este padrão tem como finalidade dividir a aplicação 
separando a camada de visualização das demais – Regra de Negócio e Acesso / Manipulação dos dados, 
para manipulação destes a API faz uso do ORM  (Object Relation Mapper) EclipseLink no qual 
permite a equipe de desenvolvedores interagir com vários tipos de bases de dados, 
objetos xml dentre outros meios de registro de dados.
Da integração: Com rotas pré-definidas (request) são solicitadas e passadas 
informações ao servidor de aplicação e este através do método (response) 
permite que sejam retornadas as informações solicitadas pelo cliente.

###Produto

####Rotas
```
/product
	/cadastrar
	/remover
	/listar
```
####Formato dos dados

-	id: number
-	skuCode: string
-	name: string
-	productModel: ??
-	size: string ('X_SMALL', 'SMALL', 'MEDIUM', 'LARGE', 'X_LARGE')
-	variation: string

###Modelo de produto

####Rotas
```
/productmodel
	/cadastrar
	/remover
	/listar
```
####Formato dos dados

-	id: number
-	name: string
-	productSubCategory: ??
-	season: string ('WINTER', 'SUMMER', 'ANY')
-	description

###Outros
```
/producsubcategory
	/listar
```

-	id
-	name
-	productSuperCategory
-	decription
-	code

```
/productsupercategory
	/listar
```

-	id
-	name
-	description
-	code
-	

####Cadastro de Material####
####Rotas
```
/material
	/cadastrar
	/alterar
	/remover
	/listar
```
####Formato dos dados

-	id: number
-	description: string
-	materialCategory: MaterialCategory
-	measuringUnit: MeasuringUnit ('KG', 'PIECES', 'METER', 'SQUARE_METER')

###Cadastro de Clientes###
####Rotas
```
/customer
	/cadastrar
	/alterar
	/remover
	/listar
```
####Formato dos dados

-	id  	    : number
-	name	    : string
-	phoneNumber : string
-	cellNumver  : string
-	cnpj 	    : string
-	ie   	    : string
-	address     : string
-	number      : string
-	city	    : string
-	state       : string
-	cep         : string
-	email	    : string
-	obs	    : string



