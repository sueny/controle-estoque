/**
 * Created by jesus on 20/05/2016.
 */


(function(){
    "use strict"


    angular.module('app')
        .controller('cadastroProdutoController', cadastroProdutoController);


    function cadastroProdutoController(toastApp, cadastroService, $mdDialog){
        var self = this;
        self.isShow = false;

        self.listMaterial = [];
        self.cadastrarProduto = cadastrarProduto;
        self.excluirProduto = excluirProduto;
        self.adicionarMateriaPrima = adicionarMateriaPrima;
        self.alertDeleteMateriaPrima = alertDeleteMateriaPrima;
        self.removerMateriaPrima = removerMateriaPrima;
        self.resetFormProduto = resetFormProduto;
        self.ordenaMateriaPrima = ordenaMateriaPrima;
        self.isVisibleGradeMateriaPrima = false;
        self.textBtnMostrarGrade = "Listar";
        self.isVisibleGradeProduto = false;
        self.showListMateriaPrima = showListMateriaPrima;
        self.selecionarMateriaPrima = selecionarMateriaPrima;
        self.selecionarProduto = selecionarProduto;
        self.initCadastroProduto = initCadastroProduto;
        self.setProductSuperCategory = setProductSuperCategory;
        self.ProductSubCategory = [];
        self.alertCadastroModelo = alertCadastroModelo;
        self.materiaPrima = {Material: {}};
        self.listaProduto = [];
        self.listaBuscaMateriaPrima;
        self.mostrarGradeProduto = mostrarGradeProduto;

        function selecionarProduto(produto){
            mostrarGradeProduto();
            self.Produto = produto;
            self.isShow = true;
        }

        function mostrarGradeProduto(){
            if(self.listaProduto.length > 0) {
                self.isVisibleGradeProduto = !self.isVisibleGradeProduto;
                if (self.isVisibleGradeProduto) {
                    self.textBtnMostrarGrade = "Ocultar";
                } else {
                    self.textBtnMostrarGrade = "Listar";
                }
            }else {
                toastApp.newmessage('Não existe Produto cadastrada.');
            }
        }


        function alertCadastroModelo(){
            toastApp.newmessage("Para Novo modelo: Cadastro -> Modelo.")
        }

        self.ListaProductSuperCategory = {
            ProductSuperCategory: {
                id: "", name: "", description: "", Code: "",
                productModel: [{id: ""}]
            }
            };

        function setProductSuperCategory(id){
            for(var i = 0; i < self.ListaProductSuperCategory.length; i++){
                if(self.ListaProductSuperCategory[i].id == id){
                    self.ProductSubCategory = self.ListaProductSuperCategory[i].ProductSubCategory;
                }
            }
        }

        function selecionarMateriaPrima(material){
            for(var i=0; i < self.listMaterial.length; i++){
                if(material.name === self.listMaterial[i].Material.name){
                    toastApp.newmessage(material.name + " Já foi selecionada")
                    return
                }
            }
            self.materiaPrima.Material = material;
            self.isVisibleGradeMateriaPrima = false;
            document.getElementById("quantityMateriaPrima").focus();
        }
        function showListMateriaPrima(){
            self.isVisibleGradeMateriaPrima = true;
        }

        function initCadastroProduto(){
            cadastroService.listarProduto()
                .success(function (data) {
                    if(data.success){
                        self.listaProduto = data.object;
                    }
                });
            cadastroService.listarModelo()
                    .success(function (data) {
                        if(data.success){
                            self.listaModelo = data.object;
                            cadastroService.listarMateriaPrima()
                                .success(function (data) {
                                    if(data.success){
                                        console.log(data.object)
                                        self.listaBuscaMateriaPrima = data.object;
                                    }
                                });
                        }
                    });

        }
        function ordenaMateriaPrima(campoOrdencao) {
            self.reverse = (self.campoOrdencao === campoOrdencao) ? !self.reverse : false;
            self.campoOrdencao = campoOrdencao;

        }

        function resetFormProduto(){
                self.Produto = {};
                self.listMaterial = [];
                self.materiaPrima = {};
                self.isVisibleGradeMateriaPrima = false;
            self.textBtnMostrarGrade = "Listar";
            self.isShow = false;
        }

        function validaMateria(name){
            console.log(name)
            if(name === undefined || name === ""){
                toastApp.newmessage("Selecione uma Materia Prima.")
                return false
            }
            for(var i=0; i < self.listaBuscaMateriaPrima.length; i++){
                if(name === self.listaBuscaMateriaPrima[i].name){
                    return true;
                }
            }
            toastApp.newmessage("Selecione a Materia Prima.")
            return false;
        }

        function adicionarMateriaPrima(materiaPrima){
            if(validaMateria(materiaPrima.Material.name)){
                if( materiaPrima.quantity < 0 || materiaPrima.quantity === '' || materiaPrima.quantity === undefined ){
                    toastApp.newmessage("Especifique a quantidade da Material.");
                    document.getElementById("quantityMateriaPrima").focus();
                    return;
                }
                var mp = {
                    quantity: materiaPrima.quantity,
                    Material: materiaPrima.Material,
                    isShow: false
                };
               /* for(var i=0; i < self.listaBuscaMateriaPrima.length; i++){
                    if(materiaPrima.Material.name === self.listaBuscaMateriaPrima[i].name){
                        self.listaBuscaMateriaPrima.splice(i,1);
                        break;
                    }
                }*/
                self.listMaterial.push(mp);
                self.materiaPrima = {
                    "Material": {},
                    "quantity": ""
                }
            }
        }
        function removerMateriaPrima(id,materiaPrima){
            self.listMaterial.splice(id,1);
        }
        function alertDeleteMateriaPrima(materiaPrima){
            materiaPrima.isShow = !materiaPrima.isShow;
        }



        function cadastrarProduto(produto){
            if(produto.productModel === undefined || produto.productModel === null ) {
                toastApp.newmessage("Ecolha um modelo.");
                document.getElementById("modeloProduto").focus();
                return;
            }
            produto.listMaterial = [];
            for(var i=0; i < self.listMaterial.length; i++){
                var material = {
                    "quantity": self.listMaterial[i].quantity,
                    "material": self.listMaterial[i].Material
                }
                produto.listMaterial.push(material);
            }
            cadastroService.cadastrarProduto(produto)
                .success(function (data) {
                    if (data.success) {
                        self.listaProduto.push(produto);
                        toastApp.newmessage("Cadastrado!");
                        self.resetFormProduto();
                        return;
                    }
                    toastApp.newmessage(data.msg);
                });
        }

        function excluirProduto(ev, produto) {
                var confirm = $mdDialog.confirm()
                    .parent(angular.element(document.body))
                    .title('Excluir Produto')
                    .content('Produto: ' + produto.name)
                    .ariaLabel('Excluir Produto')
                    .ok('Sim')
                    .cancel('Não')
                    .targetEvent(ev);
                $mdDialog.show(confirm).then(function () {
                    cadastroService.excluirProduto(produto)
                        .success(function (data) {
                            if (data.success) {
                                toastApp.newmessage("Produto Removido com sucesso.");
                                self.isShow = false;
                                self.Produto = {};
                                for(var i =0; i < self.listaProduto.length; i++){
                                    if(produto.id === self.listaProduto[i].id){
                                        self.listaProduto.splice(i,1);
                                    }
                                }
                            }else {
                                toastApp.newmessage("Problemas na remoção");
                            }

                        });


                });

        }

    }





})();
