/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('estoqueController', estoqueController);


    function estoqueController(toastApp){
        var self = this;
        self.isShowFiltro = true;
        self.listaBuscaProduto = [];
        self.initFormEstoque = initFormEstoque;
        self.operacaoEstoque = '';
        self.bucarListaProdutos = bucarListaProdutos;
        self.Busca = { campo:'name'};
        self.estoque = { data: new Date()}
        self.campoOrdencao = 'nome';
        self.ordenaProduto = ordenaProduto;
        self.selecionarProduto = selecionarProduto;
        self.isVisibleGradeModelo = false;
        self.resetFormEstoque = resetFormEstoque;
        self.inserirEntradaEstoque = inserirEntradaEstoque;


        function inserirEntradaEstoque(estoque){
            console.log(estoque);
        }


        function resetFormEstoque(){
            self.Busca = { campo:'name'};
            self.estoque = { data: new Date()}
            self.isShowFiltro = !self.isShowFiltro;

        }

        function selecionarProduto(produto){
            self.estoque = { Produto: produto, data: new Date() };
            self.isShowFiltro = !self.isShowFiltro;
            return
        }

        function bucarListaProdutos(busca){
            if(busca.palavraChave === undefined || busca.palavraChave === ""){
                toastApp.newmessage("Digite algo no campo Busca.");
                document.getElementById("palavraChaveBusca").focus();
            }
        }

        function ordenaProduto(campoOrdencao) {
            self.reverse = (self.campoOrdencao === campoOrdencao) ? !self.reverse : false;
            self.campoOrdencao = campoOrdencao;

        }

        function initFormEstoque(operacao){
            switch (operacao) {
                case "consignacao":
                    self.operacaoEstoque = operacao;
                    console.log(self.operacaoEstoque);
                    break;
                case "venda":
                    self.operacaoEstoque = operacao;
                    console.log(self.operacaoEstoque);
                    break;
                default:
                    self.operacaoEstoque = operacao;
                    initEstoque();
                    break;
            }
        }

        var initEstoque = function(){
            for(var i = 1; i < 5; i++){
                var produto = {id: i, name: "Produto" +i, skuProduto:"S"+i+"k"+i+"U"}
                self.listaBuscaProduto.push(produto)
            }
        }


    }

})();