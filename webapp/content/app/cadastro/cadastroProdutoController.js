/**
 * Created by jesus on 20/05/2016.
 */


(function(){
    "use strict";


    angular.module('app')
        .controller('cadastroProdutoController', cadastroProdutoController);


    function cadastroProdutoController(toastApp, cadastroService, $mdDialog){
        var self = this;
        self.isShow = false;
        self.isShowBtnCadastrar = false;
        self.listaMateriaPrima = [];
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
        self.materiaprima = {name:"", skuCode:""};

        self.ListaProductSuperCategory = {
            ProductSuperCategory: {
                id: "", name: "", description: "", Code: "",
                ProductSubCategory: [{id: "", name: "", description: "", Code: ""}]
            }
            };

        function setProductSuperCategory(id){

            for(var i = 0; i < self.ListaProductSuperCategory.length; i++){
                if(self.ListaProductSuperCategory[i].id == id){
                    self.ProductSubCategory = self.ListaProductSuperCategory[i].ProductSubCategory;
                }
            }
        }

        function selecionarMateriaPrima(materiaPrima){
            self.materiaprima.name = materiaPrima.name;
            self.isVisibleGrandeMateriaPrima = false;
        }

        self.listaBuscaMateriaPrima = [{
            "name": "000001",
            "skuCode": "000004",
            "unidade": "KG"
        }
        ]
        function showListMateriaPrima(){
            self.isVisibleGrandeMateriaPrima = true;
        }

        function initCadastroProduto(){
            for(var i = 0; i < 20; i++){
                var materiaprima = {
                    "name": "0" + i,
                    "skuCode": "000001" + i,
                    "unidade": "KG"
                }
                self.listaBuscaMateriaPrima.push(materiaprima)
            }
            self.ListaProductSuperCategory = [];
            for(var i=1; i < 5; i++){
                var ProductSuperCategory = {
                    id: "000000" + i, name: "SuperCategory" + i, description: "Descrição SuperCategory" + i, Code: "0000X0" +i,
                        ProductSubCategory: []
                }
                self.ListaProductSuperCategory.push(ProductSuperCategory)
                for(var j=1; j < 3; j++){
                    var ProductSubCategory = {id: j, name: "Sub " + j + " da Super " + i, description: "SubCategira " + j + " da Categoria " + i, Code: "001" + i + j};
                    self.ListaProductSuperCategory[i-1].ProductSubCategory.push(ProductSubCategory);
                }

            }
        }
        function ordenaMateriaPrima(campoOrdencao) {
            self.reverse = (self.campoOrdencao === campoOrdencao) ? !self.reverse : false;
            self.campoOrdencao = campoOrdencao;

        }

        function resetFormProduto(){

        }

        function validaMateria(name){
            for(var i=0; i < self.listaBuscaMateriaPrima.length; i++){
                if(name === self.listaBuscaMateriaPrima[i].name){
                    return true;
                }
            }
            toastApp.newmessage("Selecione a Materia Prima na gride abaixo.")
            return false;
        }

        function adicionarMateriaPrima(materiaPrima){
            if(validaMateria(materiaPrima.name)){
                console.log(materiaPrima.qte)
                if( materiaPrima.qte < 0 || materiaPrima.qte === '' || materiaPrima.qte === undefined ){
                    toastApp.newmessage("Especifique a quantidade da Material com valores positivos.");
                    document.getElementById("qteMateriaPrima").focus();
                    return;
                }
                var mp = {
                    id: materiaPrima.id,
                    name: materiaPrima.name,
                    qte: materiaPrima.qte,
                    isShow: false
                };
                for(var i=0; i < self.listaBuscaMateriaPrima.length; i++){
                    if(materiaPrima.name === self.listaBuscaMateriaPrima[i].name){
                        self.listaBuscaMateriaPrima.splice(i,1);
                        break;
                    }
                }
                self.listaMateriaPrima.push(mp);
                self.isShowBtnCadastrar = true;
                self.materiaprima = {
                    "name": "",
                    "qte": ""
                }

            }
        }
        function removerMateriaPrima(id,materiaPrima){
            console.log(id);
            self.listaMateriaPrima.splice(id,1);
            if(self.listaMateriaPrima.length === 0) self.isShowBtnCadastrar = false;
        }
        function alertDeleteMateriaPrima(materiaPrima){
            materiaPrima.isShow = !materiaPrima.isShow;
        }



        function cadastrarProduto(produto){
            cadastroService.cadastrarProduto(produto)
                .success(function (data) {
                    if (data) {
                        self.listaProduto.push(produto);
                    }
                    toastApp.newmessage(data.mensagem);
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