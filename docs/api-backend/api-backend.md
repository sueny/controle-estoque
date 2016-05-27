#Documentação REST API Backend - Controle de estoque

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