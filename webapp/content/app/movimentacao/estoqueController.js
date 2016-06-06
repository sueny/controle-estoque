/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('estoqueController', estoqueController);


    function estoqueController(toastApp, movimentacaoService,cadastroService){
        var self = this;
        self.isShowFiltro = true;
        self.isSelectCosignacao = true;
        self.listaBuscaProduto = [];
        self.initFormEstoque = initFormEstoque;
        self.operacaoEstoque = '';
        self.buscarListaCliente = buscarListaCliente;
        self.buscarListaProdutos = buscarListaProdutos;
        self.Busca = { campo:'name'};
        self.estoque = { data: new Date()}
        self.campoOrdencao = 'nome';
        self.ordenaProduto = ordenaProduto;
        self.selecionarProduto = selecionarProduto;
        self.isVisibleGradeModelo = false;
        self.resetFormEstoque = resetFormEstoque;
        self.inserirEntradaEstoque = inserirEntradaEstoque;
        self.selecionarCliente = selecionarCliente;
        self.consignacao = {};
        self.listaBuscaCliente = [];
        self.montarKit = adicionarKit;
        self.selecionarProdutoConsignacao = selecionarProdutoConsignacao;
        self.fecharKit = fecharKit;
        self.totalGeralConsignacao = 0.00;
        self.retirarProduto = retirarProduto;
        self.item = {};
        self.novaConsignacao = novaConsignacao;

        function retirarProduto(index, item){
            self.totalGeralConsignacao =  (self.totalGeralConsignacao - (item.quantify * item.price))
            self.consignacao.productList.splice(index,1);
        }

        function novaConsignacao(){
            self.isShowFiltro = true;
            self.isSelectCosignacao = true;
            self.listaBuscaProduto = [];
            self.Busca = { campo:'name'};
            self.isVisibleGradeModelo = false;
             self.consignacao = {};
            self.listaBuscaCliente = [];
            self.totalGeralConsignacao = 0.00;
            self.item = {};

        }
        var novoKit = function(){
            self.isSelectCosignacao = false;
            self.consignacao.productList = [];
            self.totalGeralConsignacao =  0.00;
            self.item = {};
            self.isSelectCosignacao = !self.isSelectCosignacao;
        }


        function fecharKit(consignacao){
            console.log(consignacao.dataRetorno)
            if(consignacao.dataRetorno === undefined || consignacao.dataRetorno === ""){
                toastApp.newmessage("Data Prevista de Retorno.");
                document.getElementById("dataRetornoCliente").focus();
                return;
            }
            console.log(consignacao);
            novoKit();

            /*movimentacaoService.cadastrarKit(consignacao)
                .success(function (data) {
                    if (data.success) {
                        toastApp.newmessage("Sucesso na Operação.");

                    }else{
                        toastApp.newmessage("Problema ao cadastrar Cliente.");
                    }

                });*/
        }

        function buscarListaCliente(nome){
            if(nome === undefined || nome == ""){
                toastApp.newmessage("Digite algo...");
                document.getElementById("nomeCliente").focus();
                return
            }
        }

        function adicionarKit(item){
            self.consignacao.productList.push(item);
            self.totalGeralConsignacao =  self.totalGeralConsignacao + (item.quantify * item.price)
            self.item = {};
            self.isSelectCosignacao = !self.isSelectCosignacao;
        }


        function inserirEntradaEstoque(estoque){
            console.log(estoque);
        }


        function resetFormEstoque(){
            self.Busca = { campo:'name'};
            self.estoque = { data: new Date()};
            self.isShowFiltro = !self.isShowFiltro;

        }

        function selecionarProduto(produto){
            self.estoque = { Produto: produto, data: new Date() };
            self.isShowFiltro = !self.isShowFiltro;
            return
        }

        function selecionarProdutoConsignacao(produto){
            self.item.Product = produto;
            self.isSelectCosignacao = !self.isSelectCosignacao;
            return
        }

        function selecionarCliente(cliente){
            self.consignacao = { Client: cliente, dataSaida: new Date(), productList:[]};
            self.isShowFiltro = !self.isShowFiltro;
            initEstoque();
        }

        function buscarListaProdutos(busca){
            if(busca.palavraChave === undefined || busca.palavraChave === ""){
                toastApp.newmessage("Digite algo no campo Busca.");
                document.getElementById("palavraChaveBusca").focus();
                return
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
                    initConsignacao();
                    break;
                case "acerto":
                    self.operacaoEstoque = operacao;
                    console.log(self.operacaoEstoque);
                    initAcerto();
                    break;
                default:
                    self.operacaoEstoque = operacao;
                    initEstoque();
                    break;
            }
        }


        var initAcerto = function(){
            /*for(var i = 1; i < 5; i++){
                var cliente = {id: i, name: "Maria " +i}
                self.listaBuscaCliente.push(cliente)
            }*/
        }

        var initConsignacao = function(){
            for(var i = 1; i < 5; i++){
                var cliente = {id: i, name: "Maria " +i}
                self.listaBuscaCliente.push(cliente)
            }
        }
        var initEstoque = function(){
            self.listaBuscaProduto = [];
            for(var i = 1; i < 5; i++){
                var produto = {id: i, name: "Produto" +i, skuProduto:"S"+i+"k"+i+"U"}
                self.listaBuscaProduto.push(produto)
            }
        }


    }

})();