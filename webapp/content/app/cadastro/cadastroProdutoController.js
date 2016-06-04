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
        self.listaProduto = self.listaProduto;
        self.resetFormProduto = resetFormProduto;
        self.ordenaMateriaPrima = ordenaMateriaPrima;
        self.isVisibleGrandeMateriaPrima = false;
        self.showListMateriaPrima = showListMateriaPrima;
        self.selecionarMateriaPrima = selecionarMateriaPrima;
        self.initCadastroProduto = initCadastroProduto;
        self.setProductSuperCategory = setProductSuperCategory;
        self.ProductSubCategory = [];
        self.alertCadastroModelo = alertCadastroModelo;
        self.materiaPrima = {Material: {}};
        self.listaProduto = [];

        function alertCadastroModelo(){
            toastApp.newmessage("Para cadastrar novo modelo: Cadastro -> Modelo.")
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
            console.log(material);
            self.materiaPrima.Material = material;
            self.isVisibleGrandeMateriaPrima = false;
        }
        function showListMateriaPrima(){
            self.isVisibleGrandeMateriaPrima = true;
        }

        function initCadastroProduto(){

            cadastroService.listarProduto()
                .success(function (data) {
                    if(data.success){
                        self.listaProduto = data.object;
                       console.log(self.listaProduto);
                    }
                });
            cadastroService.listarModelo()
                    .success(function (data) {
                        if(data.success){
                            self.listaModelo = data.object;
                            cadastroService.listarMateriaPrima()
                                .success(function (data) {
                                    if(data.success){
                                        self.listaBuscaMateriaPrima = data.object;
                                        if(self.listaBuscaMateriaPrima.length > 0) {
                                            self.textBtnMostrarGrade = "Mostrar Lista";
                                        }
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
        }

        function validaMateria(name){
            for(var i=0; i < self.listaBuscaMateriaPrima.length; i++){
                if(name === self.listaBuscaMateriaPrima[i].name){
                    return true;
                }
            }
            toastApp.newmessage("Selecione a Materia Prima.")
            return false;
        }

        function adicionarMateriaPrima(materiaPrima){
            console.log(materiaPrima);
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
                for(var i=0; i < self.listaBuscaMateriaPrima.length; i++){
                    if(materiaPrima.Material.name === self.listaBuscaMateriaPrima[i].name){
                        self.listaBuscaMateriaPrima.splice(i,1);
                        break;
                    }
                }
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
            produto.listMaterial = self.listMaterial;
            console.log(produto);
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
                            if (data) {

                            }
                        });

                    self.isShow = false;
                    toastApp.newmessage(data.message);
                    //Limpar campos form
                });

        }

    }





})();
